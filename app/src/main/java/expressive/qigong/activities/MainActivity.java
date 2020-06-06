package expressive.qigong.activities;

import androidx.appcompat.app.AppCompatActivity;
import expressive.qigong.R;
import expressive.qigong.sets.EightBreaths;
import expressive.qigong.sets.EightPieces;
import expressive.qigong.sets.FiveGates;
import expressive.qigong.sets.Random;
import expressive.qigong.sets.TwoEightSteps;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        findViewById(R.id.eight_pieces_button).setOnClickListener(view -> buttonClicked(EightPieces.class));
        findViewById(R.id.two_eight_button).setOnClickListener(view -> buttonClicked(TwoEightSteps.class));
        findViewById(R.id.eight_breaths_button).setOnClickListener(view -> buttonClicked(EightBreaths.class));
        findViewById(R.id.five_gates_button).setOnClickListener(view -> buttonClicked(FiveGates.class));
        findViewById(R.id.random_button).setOnClickListener(view -> buttonClicked(Random.class));
    }

    private void buttonClicked(Class clazz) {
        Intent intent = new Intent(this, MovementSetActivity.class);
        intent.putExtra("set", clazz.getCanonicalName());
        startActivity(intent);
    }
}
