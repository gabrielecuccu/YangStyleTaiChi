package expressive.qigong.gui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import androidx.preference.PreferenceManager;
import expressive.qigong.R;
import expressive.qigong.gui.controllers.MovementSetActivityControllerImpl;
import expressive.qigong.gui.core.MovementSetActivityController;
import expressive.qigong.gui.core.MovementSetActivityView;

public class MovementSetActivity extends Activity implements TextToSpeech.OnInitListener, MovementSetActivityView {

    private TextToSpeech tts;

    private final MovementSetActivityController controller = new MovementSetActivityControllerImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_movement_set);

        controller.processIntentExtra(getIntent().getExtras().getString("set"));
        controller.processMovementSet();

        findViewById(R.id.back_button).setOnClickListener(view -> controller.backButtonPressed());
        findViewById(R.id.speak_button).setOnClickListener(view -> controller.speakButtonClicked());

        this.tts = new TextToSpeech(this, this);
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
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ADD_WARM_UP_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeFiveGates() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ADD_FIVE_GATES_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeFiveElements() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ADD_FIVE_ELEMENTS_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeCoiling() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ADD_COILING_TO_RANDOM", false);
    }

    @Override
    public boolean getIncludeBlackDragon() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ADD_BLACK_DRAGON_TO_RANDOM", false);
    }

    @Override
    public int getMovementDuration() {
        String duration = PreferenceManager.getDefaultSharedPreferences(this).getString("RANDOM_DURATION", "60");
        return Integer.parseInt(duration);
    }

    @Override
    public boolean getSuggestTenPrinciples() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("SUGGEST_TEN_PRINCIPLES", false);
    }

    @Override
    public int getNumberOfMovements() {
        String number = PreferenceManager.getDefaultSharedPreferences(this).getString("RANDOM_NUMBER_OF_MOVEMENTS", "10");
        return Integer.parseInt(number);
    }
}
