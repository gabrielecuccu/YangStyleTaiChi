package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class EightPieces extends MovementSet {

    public EightPieces() {
        add(new Movement("Reach to the sky", getName()));
        add(new Movement("Shoot the golden eagle", getName()));
        add(new Movement("Touch heaven and earth", getName()));
        add(new Movement("Cow looks at the moon behind", getName()));
        add(new Movement("Willow cools its leaves in the stream", getName()));
        add(new Movement("White crane washes its wings", getName()));
        add(new Movement("Punching the air", getName()));
        add(new Movement("Shaking the tail-feathers", getName()));
    }

    @Override
    public String getName() {
        return "Eight pieces of silk brocade";
    }
}
