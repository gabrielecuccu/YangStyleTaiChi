package expressive.qigong.core.sets;

import expressive.qigong.core.movements.LongerMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class Walking extends SimpleMovementSet {

    public Walking() {
        add(new LongerMovement("Part the wild horse's mane", getName()));
        add(new LongerMovement("Stretch the heel", getName()));
        add(new LongerMovement("Back-stepping monkey", getName()));
        add(new LongerMovement("Circle punching", getName()));
    }

    @Override
    public String getName() {
        return "Five Gates Qi Gong";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
