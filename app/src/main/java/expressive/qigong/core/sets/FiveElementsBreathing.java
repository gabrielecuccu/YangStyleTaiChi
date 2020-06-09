package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class FiveElementsBreathing extends SimpleMovementSet {

    public FiveElementsBreathing() {
        add(new Movement("Earth (nose, nose)", getName()));
        add(new Movement("Water (nose, mouth)", getName()));
        add(new Movement("Fire (mouth, nose)", getName()));
        add(new Movement("Air (Metal) (mouth, mouth)", getName()));
        add(new Movement("Wood", getName()));
    }

    @Override
    public String getName() {
        return "Five elements breathing";
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}
