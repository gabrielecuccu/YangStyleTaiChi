package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class BasicStances extends MovementSet {

    public BasicStances() {
        add(new Movement("Taiji Stance", getName()));
        add(new Movement("Hanging Stance", getName()));
        add(new Movement("Bow stance / gōngbù", getName()));
        add(new Movement("Snake stance", getName()));
        add(new Movement("Taming the Tiger Stance", getName()));
        add(new Movement("Snake Creeps Down", getName()));
        add(new Movement("Golden Cockerel Stands On One Leg", getName()));
        add(new Movement("Horse Riding Stance", getName()));
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
