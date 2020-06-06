package expressive.qigong.activities;

import androidx.appcompat.app.AppCompatActivity;
import expressive.qigong.movements.Movement;
import expressive.qigong.movements.MovementSet;
import expressive.qigong.movements.MovementSetFactory;
import expressive.qigong.R;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MovementSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_movement_set);

        Bundle b = getIntent().getExtras();
        String className = b.getString("set");
        MovementSet movementSet = MovementSetFactory.getInstance().getMovementSet(className);

        ((TextView) findViewById(R.id.movement_title)).setText(movementSet.getName());

        StringBuilder movementList = new StringBuilder();
        for (Movement movement : movementSet) {
            movementList.append(movement.getName()).append("\n");
        }
        ((TextView) findViewById(R.id.movement_list)).setText(movementList.toString());
    }
}
