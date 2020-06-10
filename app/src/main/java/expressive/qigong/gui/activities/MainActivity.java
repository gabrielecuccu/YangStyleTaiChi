package expressive.qigong.gui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import expressive.qigong.R;
import expressive.qigong.core.movements.MovementSet;
import expressive.qigong.gui.controllers.MainActivityControllerImpl;
import expressive.qigong.gui.core.MainActivityController;
import expressive.qigong.gui.core.MainActivityView;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private final MainActivityController controller = new MainActivityControllerImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        findViewById(R.id.warm_up_button).setOnClickListener(view -> controller.warmUpClicked());
        findViewById(R.id.eight_pieces_button).setOnClickListener(view -> controller.eightPiecesClicked());
        findViewById(R.id.two_eight_button).setOnClickListener(view -> controller.twoEightStepClicked());
        findViewById(R.id.eight_breaths_button).setOnClickListener(view -> controller.eightBreathClicked());
        findViewById(R.id.five_gates_button).setOnClickListener(view -> controller.fiveGatesClicked());
        findViewById(R.id.coiling_button).setOnClickListener(view -> controller.coilingClicked());
        findViewById(R.id.black_dragon_button).setOnClickListener(view -> controller.blackDragonClicked());
        findViewById(R.id.random_button).setOnClickListener(view -> controller.randomClicked());
        findViewById(R.id.ten_principles_button).setOnClickListener(view -> controller.tenPrinciplesClicked());
        findViewById(R.id.five_elements_breathing_button).setOnClickListener(view -> controller.fiveElementsClicked());
        findViewById(R.id.basic_stances_button).setOnClickListener(view -> controller.basicStancesClicked());
        findViewById(R.id.short_form_button).setOnClickListener(view -> controller.shortFormClicked());
        findViewById(R.id.sabre_form_button).setOnClickListener(view -> controller.sabreFormClicked());
        findViewById(R.id.narrow_sword_form_button).setOnClickListener(view -> controller.narrowSwordFormClicked());
        findViewById(R.id.fan_form_button).setOnClickListener(view -> controller.fanFormClicked());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_about:
                // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage(R.string.about_dialog_text)
                        .setTitle(R.string.about_dialog_title);

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void startMovementSetActivity(Class<? extends MovementSet> clazz) {
        Intent intent = new Intent(this, MovementSetActivity.class);
        intent.putExtra("set", clazz.getCanonicalName());
        startActivity(intent);
    }
}
