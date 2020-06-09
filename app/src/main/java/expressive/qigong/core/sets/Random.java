package expressive.qigong.core.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class Random extends MovementSet {

    public Random() {

        List<Movement> movs = new ArrayList<>();
        movs.addAll(new WarmUp());
        movs.addAll(new EightPieces());
        movs.addAll(new EightBreaths());
        movs.addAll(new TwoEightSteps());
        movs.addAll(new FiveGates());
        movs.addAll(new FiveElementsBreathing());

        Collections.shuffle(movs);
        movs = movs.subList(0, 10);

        for (Movement mov : movs) {
            add(new Movement("From " + mov.getSet() + ":\n" + mov.getName() + "\n", getName()));
        }
    }

    @Override
    public String getName() {
        return "Ten minutes Qi Gong";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
