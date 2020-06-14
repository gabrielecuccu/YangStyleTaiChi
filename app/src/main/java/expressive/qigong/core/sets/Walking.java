package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class Walking extends SimpleMovementSet {

    public Walking() {
        add(new Movement("Part the wild horse's mane", getName()));
        add(new Movement("Stretch the heel", getName()));
        add(new Movement("Back-stepping monkey", getName()));
        add(new Movement("Circle punching", getName()));
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
