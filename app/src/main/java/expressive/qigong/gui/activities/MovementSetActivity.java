package expressive.qigong.gui.activities;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;
import static android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;
import expressive.qigong.R;
import expressive.qigong.gui.controllers.MovementSetActivityControllerImpl;
import expressive.qigong.gui.core.MovementSetActivityController;
import expressive.qigong.gui.core.MovementSetActivityView;

public class MovementSetActivity extends Activity
        implements TextToSpeech.OnInitListener, MovementSetActivityView {

    private TextToSpeech tts;

    private final MovementSetActivityController controller =
            new MovementSetActivityControllerImpl(this);

    private MediaPlayer mediaPlayer;

    private List<Integer> musicIds = Arrays.asList(
            R.raw.india,
            R.raw.littleplanet,
            R.raw.relaxing,
            R.raw.deepblue,
            R.raw.love,
            R.raw.november,
            R.raw.slowmotion);

    private int currentMusicIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        setContentView(R.layout.activity_movement_set);

        controller.processIntentExtra(getIntent().getExtras().getString("set"));
        controller.processMovementSet();

        findViewById(R.id.back_button).setOnClickListener(view -> controller.backButtonPressed());
        findViewById(R.id.speak_button).setOnClickListener(view -> controller.speakButtonClicked());

        tts = new TextToSpeech(this, this);
        Collections.shuffle(musicIds);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.UK);
            tts.setSpeechRate(0.85f);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {

                findViewById(R.id.speak_button).setEnabled(false);
            } else {
                findViewById(R.id.speak_button).setEnabled(true);
            }

        } else {
            findViewById(R.id.speak_button).setEnabled(false);
        }
    }

    @Override
    protected void onDestroy() {
        controller.destroy();
        super.onDestroy();
    }

    @Override
    public void goBack() {
        super.onBackPressed();
    }

    @Override
    public void setTitle(String title) {
        ((TextView) findViewById(R.id.movement_title)).setText(title);
    }

    @Override
    public void showMovementSet(String movements) {
        // Show text
        TextView movList = findViewById(R.id.movement_list);
        movList.setText(movements);

        // set the scrollbar
        movList.setMovementMethod(new ScrollingMovementMethod());

        // disable the copy and paste
        movList.setCustomSelectionActionModeCallback(new CustomActionMode());
        movList.setLongClickable(false);
        movList.setTextIsSelectable(false);
    }

    @Override
    public void stopTTS() {
        tts.stop();
    }

    @Override
    public void setSpeakButtonText(String text) {
        runOnUiThread(() -> ((Button) findViewById(R.id.speak_button)).setText(text));
    }

    @Override
    public void hideProgress() {
        runOnUiThread(() -> findViewById(R.id.speak_progress).setVisibility(View.GONE));
    }

    @Override
    public void showProgress() {
        runOnUiThread(() -> findViewById(R.id.speak_progress).setVisibility(View.VISIBLE));
    }

    @Override
    public void say(String sentence) {
        tts.speak(sentence, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    public void shutdownTTS() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }

    @Override
    public void hideSpeakButton() {
        findViewById(R.id.speak_button).setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean getIncludeWarmUp() {
        return getDefaultSharedPreferences(this).getBoolean("ADD_WARM_UP_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeFiveGates() {
        return getDefaultSharedPreferences(this).getBoolean("ADD_FIVE_GATES_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeFiveElements() {
        return getDefaultSharedPreferences(this).getBoolean("ADD_FIVE_ELEMENTS_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeCoiling() {
        return getDefaultSharedPreferences(this).getBoolean("ADD_COILING_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeBlackDragon() {
        return getDefaultSharedPreferences(this).getBoolean("ADD_BLACK_DRAGON_TO_RANDOM", false);
    }

    @Override
    public int getMovementDuration() {
        String duration = getDefaultSharedPreferences(this).getString("RANDOM_DURATION", "90");
        return Integer.parseInt(duration);
    }

    @Override
    public boolean getSuggestTenPrinciples() {
        return getDefaultSharedPreferences(this).getBoolean("SUGGEST_TEN_PRINCIPLES", true);
    }

    @Override
    public int getNumberOfMovements() {
        String number = getDefaultSharedPreferences(this).getString("RANDOM_NUMBER_OF_MOVEMENTS", "10");
        return Integer.parseInt(number);
    }

    @Override
    public boolean getAddWarmUpToAllSets() {
        return getDefaultSharedPreferences(this).getBoolean("ADD_WARM_UP_TO_ALL_SETS", false);
    }

    @Override
    public void keepScreenOn() {
        runOnUiThread(() -> getWindow().addFlags(FLAG_KEEP_SCREEN_ON));
    }

    @Override
    public void clearKeepScreenOn() {
        runOnUiThread(() -> getWindow().clearFlags(FLAG_KEEP_SCREEN_ON));
    }

    @Override
    public void playMusic() {
        boolean shouldPlayMusic = getDefaultSharedPreferences(this).getBoolean("PLAY_MUSIC", true);

        if (mediaPlayer == null && shouldPlayMusic) {
            mediaPlayer = MediaPlayer.create(this, musicIds.get(currentMusicIndex));
            mediaPlayer.setVolume(0.75f, 0.75f);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mp -> {
                currentMusicIndex = (currentMusicIndex + 1) % musicIds.size();
                AssetFileDescriptor afd =
                        getResources().openRawResourceFd(musicIds.get(currentMusicIndex));
                try {
                    mp.reset();
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    afd.close();
                    mp.prepare();
                    mp.start();
                } catch (IOException ignored) {

                }
            });
        }
    }

    @Override
    public void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
