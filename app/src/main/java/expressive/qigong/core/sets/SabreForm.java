package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class SabreForm extends MovementSet {

    public SabreForm() {
        add(new Movement("Opening the Form", getName()));
        add(new Movement("Step up to seven stars", getName()));
        add(new Movement("Sit back to ride the tiger", getName()));
        add(new Movement("Raise leg to cut", getName()));
        add(new Movement("Coil the sabre to pierce", getName()));
        add(new Movement("Push the blade", getName()));
        add(new Movement("Right, left and forward cartwheel", getName()));
        add(new Movement("Retreat to attack", getName()));
        add(new Movement("Entwine to hack", getName()));
        add(new Movement("Turn and slash", getName()));
        add(new Movement("Entwine to hack", getName()));
        add(new Movement("Turn and slash", getName()));
        add(new Movement("Raise leg to pierce", getName()));
        add(new Movement("Advance and stab upwards", getName()));
        add(new Movement("Turn and slash", getName()));
        add(new Movement("Transfer the sabre to kick", getName()));
        add(new Movement("Shake loose the girdle to tie up the tiger", getName()));
        add(new Movement("Kick like a mandarin duck", getName()));
        add(new Movement("Split Mount Tai", getName()));
        add(new Movement("Raise leg to pierce", getName()));
        add(new Movement("Entwine to slash", getName()));
        add(new Movement("Turn and enter diagonally", getName()));
        add(new Movement("Left, right and upward cartwheel", getName()));
        add(new Movement("Carp jumps through the dragon's gate", getName()));
        add(new Movement("Entwine to hack, shift and slash", getName()));
        add(new Movement("Step back to seven stars", getName()));
        add(new Movement("Closing the Form", getName()));
    }

    @Override
    public String getName() {
        return "Sabre form";
    }
}
