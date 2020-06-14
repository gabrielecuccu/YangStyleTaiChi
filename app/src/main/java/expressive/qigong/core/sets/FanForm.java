package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class FanForm extends SimpleMovementSet {

    public FanForm() {
        add(new StandardMovement("Opening the form", getName()));
        add(new StandardMovement("Embrace the moon", getName()));
        add(new StandardMovement("Swallow swoops on the water", getName()));
        add(new StandardMovement("Push the boat with the current", getName()));
        add(new StandardMovement("Dr. Hua Tuo lowers the blind", getName()));
        add(new StandardMovement("Yellow nightingale's descent", getName()));
        add(new StandardMovement("Phoenix dances in a circle", getName()));
        add(new StandardMovement("Black dragon shakes its tail", getName()));
        add(new StandardMovement("Turn around and strike the tiger", getName()));
        add(new StandardMovement("Spirit dragon turns its head", getName()));
        add(new StandardMovement("Pluck the lotus from the lake", getName()));
        add(new StandardMovement("Wild goose flies south", getName()));
        add(new StandardMovement("Zhoajun catches butterflies", getName()));
        add(new StandardMovement("Flood dragon plays with the pearl", getName()));
        add(new StandardMovement("Roc spreads its wings", getName()));
        add(new StandardMovement("Press the wrist to raise the blind", getName()));
        add(new StandardMovement("Black clouds rolling", getName()));
        add(new StandardMovement("Swing fan up (in back crossed step)", getName()));
        add(new StandardMovement("LIft the arm to look at the flowers", getName()));
        add(new StandardMovement("Willow waves in the breeze", getName()));
        add(new StandardMovement("Dust against the wind", getName()));
        add(new StandardMovement("Pushing the waves", getName()));
        add(new StandardMovement("Turn around and strike with the fan", getName()));
        add(new StandardMovement("Wave long sleeve like flower", getName()));
        add(new StandardMovement("Place a flower in your hair", getName()));
        add(new StandardMovement("Pour water from a golden jar", getName()));
        add(new StandardMovement("Turn around and look at the flowers", getName()));
        add(new StandardMovement("Quin Yu lifts up the tripod", getName()));
        add(new StandardMovement("Spirit fan pierces the mist", getName()));
        add(new StandardMovement("Looking tall to fours seas", getName()));
        add(new StandardMovement("Hold the fan in crouching stance", getName()));
        add(new StandardMovement("White crane spreads its wings", getName()));
        add(new StandardMovement("Wind sweeps the autumn leaves", getName()));
        add(new StandardMovement("Spring returns to the land", getName()));
        add(new StandardMovement("Butterflies fly up and down", getName()));
        add(new StandardMovement("Closing the form", getName()));
    }

    @Override
    public String getName() {
        return "Fan form";
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}
