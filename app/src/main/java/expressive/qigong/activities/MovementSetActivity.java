package expressive.qigong.activities;

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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import expressive.qigong.R;
import expressive.qigong.movements.Movement;
import expressive.qigong.movements.MovementSet;
import expressive.qigong.movements.MovementSetFactory;

public class MovementSetActivity extends Activity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    private MovementSet movementSet;

    private Timer timer;

    private boolean speaking = false;

    private String[] lastRepetitionSentences = new String[] {
            "ten more seconds",
            "make this your last one",
            "almost there",
            "almost time for the next one"
    };

    private String[] tenPrinciples = new String[] {
            "remember to suspend the head from the sky",
            "remember to sink the chest, open the upper back",
            "remember to loosen the waist",
            "remember to sink the shoulders, drop the elbows",
            "remember to distinguish between full and empty",
            "remember to use will, not strength",
            "remember to coordinate the upper and lower body",
            "remember to unify external and internal movements",
            "remember the unbroken continuity of flow",
            "remember to seek stillness in movement"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_movement_set);

        Bundle b = getIntent().getExtras();
        String className = b.getString("set");
        movementSet = MovementSetFactory.getInstance().getMovementSet(className);

        ((TextView) findViewById(R.id.movement_title)).setText(movementSet.getName());

        findViewById(R.id.back_button).setOnClickListener(view -> super.onBackPressed());
        findViewById(R.id.speak_button).setOnClickListener(view -> speakButtonClicked());

        // Create text
        StringBuilder movementList = new StringBuilder();
        int index = 1;
        for (Movement movement : movementSet) {
            movementList.append(index++ + ") " + movement.getName()).append("\n\n");
        }

        // Show text
        TextView movList = findViewById(R.id.movement_list);
        movList.setText(movementList.toString());

        // set the scrollbar
        movList.setMovementMethod(new ScrollingMovementMethod());

        // disable the copy and paste
        movList.setCustomSelectionActionModeCallback(new CustomActionMode());
        movList.setLongClickable(false);
        movList.setTextIsSelectable(false);

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

    private void speakButtonClicked() {
        if (speaking) {
            stopSpeaking();
        } else {
            startSpeaking();
        }
    }

    private void startSpeaking() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Say the set name
                tts.speak(movementSet.getName(), TextToSpeech.QUEUE_FLUSH, null, null);
                sleep(2000);
                if (!speaking) {
                    stopSpeaking();
                    return;
                }

                for (Movement mov : movementSet) {
                    // Say the movement name
                    tts.speak(mov.getName(), TextToSpeech.QUEUE_FLUSH, null, null);
                    sleep(25000);
                    if (!speaking) {
                        stopSpeaking();
                        return;
                    }

                    // Say a random principle
                    int randomIndex = new Random().nextInt(tenPrinciples.length);
                    String principle = tenPrinciples[randomIndex];
                    tts.speak(principle, TextToSpeech.QUEUE_FLUSH, null, null);
                    sleep(25000);
                    if (!speaking) {
                        stopSpeaking();
                        return;
                    }

                    // Say it's almost time for the next movement
                    randomIndex = new Random().nextInt(lastRepetitionSentences.length);
                    String text = lastRepetitionSentences[randomIndex];
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                    sleep(10000);
                    if (!speaking) {
                        stopSpeaking();
                        return;
                    }
                }

                // Say to dantien breathing
                tts.speak("Dantien breathing", TextToSpeech.QUEUE_FLUSH, null, null);
                sleep(10000);
                if (!speaking) {
                    stopSpeaking();
                    return;
                }

                // Say the set is finished
                tts.speak("Open your eyes, enjoy the rest of your day", TextToSpeech.QUEUE_FLUSH, null, null);
                sleep(5000);
                stopSpeaking();
            }
        }, 100);

        speaking = true;
        ((Button) findViewById(R.id.speak_button)).setText("Stop");
        findViewById(R.id.speak_progress).setVisibility(View.VISIBLE);

    }

    private void stopSpeaking() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }

        tts.stop();
        speaking = false;

        MovementSetActivity.this.runOnUiThread(() -> {
            ((Button) findViewById(R.id.speak_button)).setText("Speak");
            findViewById(R.id.speak_progress).setVisibility(View.GONE);
        });
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();
        }

        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }
}
