package expressive.qigong.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import expressive.qigong.movements.Movement;
import expressive.qigong.movements.MovementSet;

public class Random extends MovementSet {

    public Random() {

        List<Movement> movs = new ArrayList<>();
        movs.addAll(new EightPieces());
        movs.addAll(new EightBreaths());
        movs.addAll(new TwoEightSteps());

        Collections.shuffle(movs);
        movs = movs.subList(0, 10);

        for (Movement mov : movs) {
            add(new Movement("From " + mov.getSet() + ":\n" + mov.getName() + "\n", getName()));
        }
    }

    @Override
    public String getName() {
        return "Random Qigong";
    }
}
