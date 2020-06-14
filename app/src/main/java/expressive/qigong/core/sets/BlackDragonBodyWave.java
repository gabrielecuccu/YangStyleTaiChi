package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class BlackDragonBodyWave extends SimpleMovementSet {

    public BlackDragonBodyWave() {
        add(new StandardMovement("Dragon swims in the ocean", getName()));
        add(new StandardMovement("Dragon pounces on its prey", getName()));
        add(new StandardMovement("Dragon dives for pearls", getName()));
        add(new StandardMovement("Dragon stretches its wings", getName()));
    }

    @Override
    public String getName() {
        return "Black dragon body wave Qi Gong";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
