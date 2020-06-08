package expressive.qigong.core.movements;

import java.util.ArrayList;

public abstract class MovementSet extends ArrayList<Movement> {

    public abstract String getName();

    public abstract boolean canSpeak();
}
