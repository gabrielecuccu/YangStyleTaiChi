package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class SabreForm extends SimpleMovementSet {

    public SabreForm() {
        add(new StandardMovement("Opening the Form", getName()));
        add(new StandardMovement("Step up to seven stars", getName()));
        add(new StandardMovement("Sit back to ride the tiger", getName()));
        add(new StandardMovement("Raise leg to cut", getName()));
        add(new StandardMovement("Coil the sabre to pierce", getName()));
        add(new StandardMovement("Push the blade", getName()));
        add(new StandardMovement("Right, left and forward cartwheel", getName()));
        add(new StandardMovement("Retreat to attack", getName()));
        add(new StandardMovement("Entwine to hack", getName()));
        add(new StandardMovement("Turn and slash", getName()));
        add(new StandardMovement("Entwine to hack", getName()));
        add(new StandardMovement("Turn and slash", getName()));
        add(new StandardMovement("Raise leg to pierce", getName()));
        add(new StandardMovement("Advance and stab upwards", getName()));
        add(new StandardMovement("Turn and slash", getName()));
        add(new StandardMovement("Transfer the sabre to kick", getName()));
        add(new StandardMovement("Shake loose the girdle to tie up the tiger", getName()));
        add(new StandardMovement("Kick like a mandarin duck", getName()));
        add(new StandardMovement("Split Mount Tai", getName()));
        add(new StandardMovement("Raise leg to pierce", getName()));
        add(new StandardMovement("Entwine to slash", getName()));
        add(new StandardMovement("Turn and enter diagonally", getName()));
        add(new StandardMovement("Left, right and upward cartwheel", getName()));
        add(new StandardMovement("Carp jumps through the dragon's gate", getName()));
        add(new StandardMovement("Entwine to hack, shift and slash", getName()));
        add(new StandardMovement("Step back to seven stars", getName()));
        add(new StandardMovement("Closing the Form", getName()));
    }

    @Override
    public String getName() {
        return "Sabre form";
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}
