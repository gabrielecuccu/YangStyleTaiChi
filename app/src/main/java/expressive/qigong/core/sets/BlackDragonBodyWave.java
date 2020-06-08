package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class BlackDragonBodyWave extends MovementSet {

    public BlackDragonBodyWave() {
        add(new Movement("Dragon swims in the ocean", getName()));
        add(new Movement("Dragon pounces on its prey", getName()));
        add(new Movement("Dragon dives for pearls", getName()));
        add(new Movement("Dragon stretches its wings", getName()));
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
