package expressive.qigong.core.sets;

import expressive.qigong.core.movements.ShorterMovement;
import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class EightPieces extends SimpleMovementSet {

    public EightPieces() {
        add(new StandardMovement("Reach to the sky", getName()));
        add(new StandardMovement("Shoot the golden eagle", getName()));
        add(new StandardMovement("Touch heaven and earth", getName()));
        add(new StandardMovement("Cow looks at the moon behind", getName()));
        add(new StandardMovement("Willow cools its leaves in the stream", getName()));
        add(new ShorterMovement("White crane washes its wings", getName()));
        add(new StandardMovement("Punching the air", getName()));
        add(new ShorterMovement("Shaking the tail-feathers", getName(), "remember to breath softly through the nose"));
    }

    @Override
    public String getName() {
        return "Eight pieces of silk brocade";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
