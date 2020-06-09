package expressive.qigong.core.movements;

import java.util.ArrayList;

public abstract class MovementSet extends ArrayList<Movement> {

    public abstract String getName();

    public abstract boolean canSpeak();

    public abstract boolean requiresSettings();

    public abstract MovementSet includeWarmUp(boolean b);

    public abstract MovementSet includeFiveGates(boolean b);

    public abstract MovementSet includeFiveElements(boolean b);

    public abstract MovementSet includeCoiling(boolean b);

    public abstract MovementSet includeBlackDragon(boolean b);

    public abstract MovementSet setNumberOfMovements(int i);

    public abstract void build();
}
