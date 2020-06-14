package expressive.qigong.core.sets;

import expressive.qigong.core.movements.LongerMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class FiveElementsBreathing extends SimpleMovementSet {

    public FiveElementsBreathing() {
        add(new LongerMovement("Earth (nose, nose)", getName(), "remember to breathe in and out through the nose, eyes closed"));
        add(new LongerMovement("Water (nose, mouth)", getName(), "remember to breathe in through the nose, and out through the mouth, eyes closed"));
        add(new LongerMovement("Fire (mouth, nose)", getName(), "remember to breathe in through the mouth, and out through the nose, eyes closed"));
        add(new LongerMovement("Air (Metal) (mouth, mouth)", getName(), "remember to breathe in and out through the mouth, eyes closed"));
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
