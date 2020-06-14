package expressive.qigong.core.sets;

import expressive.qigong.core.movements.LongerMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class FiveElementsBreathing extends SimpleMovementSet {

    public FiveElementsBreathing() {
        add(new LongerMovement("Earth (nose, nose)", getName()));
        add(new LongerMovement("Water (nose, mouth)", getName()));
        add(new LongerMovement("Fire (mouth, nose)", getName()));
        add(new LongerMovement("Air (Metal) (mouth, mouth)", getName()));
        add(new LongerMovement("Wood", getName()));
    }

    @Override
    public String getName() {
        return "Five elements breathing";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
