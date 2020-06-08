package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class EightBreaths extends MovementSet {

    public EightBreaths() {
        add(new Movement("Heaven and earth", getName()));
        add(new Movement("Lift the sky", getName()));
        add(new Movement("Push the sides", getName()));
        add(new Movement("Push the mountain", getName()));
        add(new Movement("Yang circle", getName()));
        add(new Movement("Yin circle", getName()));
        add(new Movement("Twisting up and down", getName()));
        add(new Movement("Twisting sideways", getName()));
    }

    @Override
    public String getName() {
        return "Eight taiji breaths";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
