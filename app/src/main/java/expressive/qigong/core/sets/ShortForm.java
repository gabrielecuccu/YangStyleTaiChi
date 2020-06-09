package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class ShortForm extends SimpleMovementSet {

    public ShortForm() {
        add(new Movement("Opening the Form", getName()));
        add(new Movement("Part the wild horse's mane", getName()));
        add(new Movement("White crane spreads its wings", getName()));
        add(new Movement("Brush knee twist step", getName()));
        add(new Movement("Play the guitar", getName()));
        add(new Movement("Back stepping monkey", getName()));
        add(new Movement("Grasp the sparrow's tail while warding off the tiger", getName()));
        add(new Movement("Single whip", getName()));
        add(new Movement("Cloud hands", getName()));
        add(new Movement("Single whip", getName()));
        add(new Movement("Mount the horse", getName()));
        add(new Movement("Stretch the right heel", getName()));
        add(new Movement("Boxing the tigers' ears", getName()));
        add(new Movement("Stretch the left heel", getName()));
        add(new Movement("Snake creeps down", getName()));
        add(new Movement("Golden cockerel stands on one leg", getName()));
        add(new Movement("Snake creeps down", getName()));
        add(new Movement("Golden cockerel stands on one leg", getName()));
        add(new Movement("Jade lady works the shuttles", getName()));
        add(new Movement("Pluck the needle from the bottom of the ocean", getName()));
        add(new Movement("Fan through the back", getName()));
        add(new Movement("Turn, parry and punch", getName()));
        add(new Movement("Apparent close-up", getName()));
        add(new Movement("Closing the Form", getName()));
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
