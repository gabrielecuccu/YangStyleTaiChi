package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class BasicStances extends SimpleMovementSet {

    public BasicStances() {
        add(new StandardMovement("Taiji Stance", getName()));
        add(new StandardMovement("Hanging Stance", getName()));
        add(new StandardMovement("Bow stance / gōngbù", getName()));
        add(new StandardMovement("Snake stance", getName()));
        add(new StandardMovement("Taming the Tiger Stance", getName()));
        add(new StandardMovement("Snake Creeps Down", getName()));
        add(new StandardMovement("Golden Cockerel Stands On One Leg", getName()));
        add(new StandardMovement("Horse Riding Stance", getName()));
    }

    @Override
    public String getName() {
        return "Basic Stances";
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}
