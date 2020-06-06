package expressive.qigong.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import expressive.qigong.R;
import expressive.qigong.movements.Movement;
import expressive.qigong.movements.MovementSet;
import expressive.qigong.movements.MovementSetFactory;

public class MovementSetActivity extends Activity {

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
        int index = 1;
        for (Movement movement : movementSet) {
            movementList.append(index++ + ") " + movement.getName()).append("\n\n");
        }
        ((TextView) findViewById(R.id.movement_list)).setText(movementList.toString());
    }
}
