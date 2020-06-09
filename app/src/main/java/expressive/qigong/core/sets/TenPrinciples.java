package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class TenPrinciples extends SimpleMovementSet {

    public TenPrinciples() {
        add(new Movement("Suspend the head from the sky", getName()));
        add(new Movement("Sink the chest, open the upper back", getName()));
        add(new Movement("Loosen the waist", getName()));
        add(new Movement("Sink the shoulders, drop the elbows", getName()));
        add(new Movement("Distinguish between full and empty", getName()));
        add(new Movement("Use will, not strength", getName()));
        add(new Movement("Co-ordinate the upper and lower body", getName()));
        add(new Movement("Unify external and internal movements", getName()));
        add(new Movement("Unbroken continuity of flow", getName()));
        add(new Movement("Seek stillness in movement", getName()));
    }

    @Override
    public String getName() {
        return "The ten principles";
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}
