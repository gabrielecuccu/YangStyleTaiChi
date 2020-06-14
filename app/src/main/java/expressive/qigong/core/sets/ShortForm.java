package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class ShortForm extends SimpleMovementSet {

    public ShortForm() {
        add(new StandardMovement("Opening the Form", getName()));
        add(new StandardMovement("Part the wild horse's mane", getName()));
        add(new StandardMovement("White crane spreads its wings", getName()));
        add(new StandardMovement("Brush knee twist step", getName()));
        add(new StandardMovement("Play the guitar", getName()));
        add(new StandardMovement("Back stepping monkey", getName()));
        add(new StandardMovement("Grasp the sparrow's tail while warding off the tiger", getName()));
        add(new StandardMovement("Single whip", getName()));
        add(new StandardMovement("Cloud hands", getName()));
        add(new StandardMovement("Single whip", getName()));
        add(new StandardMovement("Mount the horse", getName()));
        add(new StandardMovement("Stretch the right heel", getName()));
        add(new StandardMovement("Boxing the tigers' ears", getName()));
        add(new StandardMovement("Stretch the left heel", getName()));
        add(new StandardMovement("Snake creeps down", getName()));
        add(new StandardMovement("Golden cockerel stands on one leg", getName()));
        add(new StandardMovement("Snake creeps down", getName()));
        add(new StandardMovement("Golden cockerel stands on one leg", getName()));
        add(new StandardMovement("Jade lady works the shuttles", getName()));
        add(new StandardMovement("Pluck the needle from the bottom of the ocean", getName()));
        add(new StandardMovement("Fan through the back", getName()));
        add(new StandardMovement("Turn, parry and punch", getName()));
        add(new StandardMovement("Apparent close-up", getName()));
        add(new StandardMovement("Closing the Form", getName()));
    }

    @Override
    public String getName() {
        return "Short form";
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}
