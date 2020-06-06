package expressive.qigong.activities;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Locale;
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
        findViewById(R.id.speak_button).setOnClickListener(view -> speak());

        StringBuilder movementList = new StringBuilder();
        int index = 1;
        for (Movement movement : movementSet) {
            movementList.append(index++ + ") " + movement.getName()).append("\n\n");
        }

        TextView movList = findViewById(R.id.movement_list);
        movList.setText(movementList.toString());

        // set the scrollbar
        movList.setMovementMethod(new ScrollingMovementMethod());

        // disable the copy and paste
        movList.setCustomSelectionActionModeCallback(new ActionMode.Callback() {

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }
        });

        movList.setLongClickable(false);
        movList.setTextIsSelectable(false);

        this.tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.UK);
            tts.setSpeechRate(1f);

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

    private void speak() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tts.speak(movementSet.getName(), TextToSpeech.QUEUE_FLUSH, null, null);
                sleep(2000);
                for (Movement mov : movementSet) {
                    tts.speak(mov.getName(), TextToSpeech.QUEUE_FLUSH, null, null);
                    sleep(50000);
                    tts.speak("ten more seconds", TextToSpeech.QUEUE_FLUSH, null, null);
                    sleep(10000);
                }
                tts.speak("Dantien breathing", TextToSpeech.QUEUE_FLUSH, null, null);
                sleep(10000);
                tts.speak("Open your eyes, enjoy the rest of your day", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 100);
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
