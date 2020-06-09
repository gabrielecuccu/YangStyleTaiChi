package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class WarmUp extends MovementSet {

    public WarmUp() {
        add(new Movement("Swinging arms", getName()));
        add(new Movement("Yin swimming dragon", getName()));
        add(new Movement("Yang swimming dragon", getName()));
        add(new Movement("Catherine Wheels", getName()));
        add(new Movement("Support the Sky", getName()));
        add(new Movement("Fishes in Eight", getName()));
        add(new Movement("Iron Butterfly", getName()));
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
