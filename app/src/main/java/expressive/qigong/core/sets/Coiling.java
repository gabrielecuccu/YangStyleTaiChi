package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class Coiling extends SimpleMovementSet {

    public Coiling() {
        add(new StandardMovement("Yin Yang Hands", getName()));
        add(new StandardMovement("Drilling forward and pulling back", getName()));
        add(new StandardMovement("Fire and Water intermingle", getName()));
        add(new StandardMovement("Great Bear swims in the ocean", getName()));
        add(new StandardMovement("Golden Cockerel twists its wings", getName()));
        add(new StandardMovement("Great Python twists its body", getName()));
        add(new StandardMovement("Great Bear seize the moon", getName()));
        add(new StandardMovement("Holding up the world", getName()));
        add(new StandardMovement("Turning heaven and earth in front of the body", getName()));
        add(new StandardMovement("Turn the head to look at the moon", getName()));
        add(new StandardMovement("Coiling up and down", getName()));
        add(new StandardMovement("Balancing Yin and Yang", getName()));
    }

    @Override
    public String getName() {
        return "Coiling Qi Gong";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
