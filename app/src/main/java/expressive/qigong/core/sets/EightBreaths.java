package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class EightBreaths extends SimpleMovementSet {

    public EightBreaths() {
        add(new StandardMovement("Heaven and earth", getName()));
        add(new StandardMovement("Lift the sky", getName()));
        add(new StandardMovement("Push the sides", getName()));
        add(new StandardMovement("Push the mountain", getName()));
        add(new StandardMovement("Yang circle", getName()));
        add(new StandardMovement("Yin circle", getName()));
        add(new StandardMovement("Twisting up and down", getName()));
        add(new StandardMovement("Twisting sideways", getName()));
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
