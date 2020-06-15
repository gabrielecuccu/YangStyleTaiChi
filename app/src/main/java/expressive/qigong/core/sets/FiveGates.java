package expressive.qigong.core.sets;

import expressive.qigong.core.movements.ShorterMovement;
import expressive.qigong.core.movements.SimpleMovementSet;
import expressive.qigong.core.movements.StandardMovement;

public class FiveGates extends SimpleMovementSet {

    public FiveGates() {
        add(new StandardMovement("Neck", getName()));
        add(new StandardMovement("Shoulders", getName(), "change side if you haven't yet"));
        add(new ShorterMovement("Hip rotation", getName(), "have you changed direction?"));
        add(new ShorterMovement("Knee rotation", getName()));
        add(new StandardMovement("Ankle rotation", getName(), "change leg if you haven't yet"));
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
