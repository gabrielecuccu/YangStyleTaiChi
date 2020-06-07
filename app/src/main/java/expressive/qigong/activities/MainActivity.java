package expressive.qigong.activities;

import expressive.qigong.R;
import expressive.qigong.controllers.MainActivityControllerImpl;
import expressive.qigong.core.MainActivityController;
import expressive.qigong.core.MainActivityView;
import expressive.qigong.movements.MovementSet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity implements MainActivityView {

    private final MainActivityController controller = new MainActivityControllerImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        findViewById(R.id.eight_pieces_button).setOnClickListener(view -> controller.eightPiecesClicked());
        findViewById(R.id.two_eight_button).setOnClickListener(view -> controller.twoEightStepClicked());
        findViewById(R.id.eight_breaths_button).setOnClickListener(view -> controller.eightBreathClicked());
        findViewById(R.id.five_gates_button).setOnClickListener(view -> controller.fiveGatesClicked());
        findViewById(R.id.random_button).setOnClickListener(view -> controller.randomClicked());
    }

    @Override
    public void startMovementSetActivity(Class<? extends MovementSet> clazz) {
        Intent intent = new Intent(this, MovementSetActivity.class);
        intent.putExtra("set", clazz.getCanonicalName());
        startActivity(intent);
    }
}
