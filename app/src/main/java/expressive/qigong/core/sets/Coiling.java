package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class Coiling extends SimpleMovementSet {

    public Coiling() {
        add(new Movement("Yin Yang Hands", getName()));
        add(new Movement("Drilling forward and pulling back", getName()));
        add(new Movement("Fire and Water intermingle", getName()));
        add(new Movement("Great Bear swims in the ocean", getName()));
        add(new Movement("Golden Cockerel twists its wings", getName()));
        add(new Movement("Great Python twists its body", getName()));
        add(new Movement("Great Bear seize the moon", getName()));
        add(new Movement("Holding up the world", getName()));
        add(new Movement("Turning heaven and earth in front of the body", getName()));
        add(new Movement("Turn the head to look at the moon", getName()));
        add(new Movement("Coiling up and down", getName()));
        add(new Movement("Balancing Yin and Yang", getName()));
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
