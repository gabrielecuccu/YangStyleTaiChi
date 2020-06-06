package expressive.qigong.sets;

import expressive.qigong.movements.Movement;
import expressive.qigong.movements.MovementSet;

public class FiveGates extends MovementSet {

    public FiveGates() {
        add(new Movement("Neck", getName()));
        add(new Movement("Shoulders", getName()));
        add(new Movement("Hip rotation", getName()));
        add(new Movement("Knee rotation", getName()));
        add(new Movement("Ankle rotation", getName()));
    }

    @Override
    public String getName() {
        return "Five Gates Qi Gong";
    }
}
