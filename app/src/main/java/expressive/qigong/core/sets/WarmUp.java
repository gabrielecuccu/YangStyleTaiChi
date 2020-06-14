package expressive.qigong.core.sets;

import expressive.qigong.core.movements.LongerMovement;
import expressive.qigong.core.movements.ShorterMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class WarmUp extends SimpleMovementSet {

    public WarmUp() {
        add(new LongerMovement("Swinging arms", getName()));
        add(new LongerMovement("Yin swimming dragon", getName()));
        add(new LongerMovement("Yang swimming dragon", getName()));
        add(new LongerMovement("Catherine Wheels", getName()));
        add(new ShorterMovement("Support the Sky", getName()));
        add(new LongerMovement("Fishes in Eight", getName()));
        add(new LongerMovement("Iron Butterfly", getName()));
    }

    @Override
    public String getName() {
        return "Warm up exercises";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
