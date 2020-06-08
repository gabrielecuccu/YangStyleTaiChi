package expressive.qigong.gui.activities;

import expressive.qigong.R;
import expressive.qigong.gui.controllers.MainActivityControllerImpl;
import expressive.qigong.gui.core.MainActivityController;
import expressive.qigong.gui.core.MainActivityView;
import expressive.qigong.core.movements.MovementSet;

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
    public void startMovementSetActivity(Class<? extends MovementSet> clazz) {
        Intent intent = new Intent(this, MovementSetActivity.class);
        intent.putExtra("set", clazz.getCanonicalName());
        startActivity(intent);
    }
}
