package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class TenPrinciples extends SimpleMovementSet {

    public TenPrinciples() {
        add(new StandardMovement("Suspend the head from the sky", getName()));
        add(new StandardMovement("Sink the chest, open the upper back", getName()));
        add(new StandardMovement("Loosen the waist", getName()));
        add(new StandardMovement("Sink the shoulders, drop the elbows", getName()));
        add(new StandardMovement("Distinguish between full and empty", getName()));
        add(new StandardMovement("Use will, not strength", getName()));
        add(new StandardMovement("Co-ordinate the upper and lower body", getName()));
        add(new StandardMovement("Unify external and internal movements", getName()));
        add(new StandardMovement("Unbroken continuity of flow", getName()));
        add(new StandardMovement("Seek stillness in movement", getName()));
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
