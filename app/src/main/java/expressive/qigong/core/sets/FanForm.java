package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class FanForm extends SimpleMovementSet {

    public FanForm() {
        add(new Movement("Opening the form", getName()));
        add(new Movement("Embrace the moon", getName()));
        add(new Movement("Swallow swoops on the water", getName()));
        add(new Movement("Push the boat with the current", getName()));
        add(new Movement("Dr. Hua Tuo lowers the blind", getName()));
        add(new Movement("Yellow nightingale's descent", getName()));
        add(new Movement("Phoenix dances in a circle", getName()));
        add(new Movement("Black dragon shakes its tail", getName()));
        add(new Movement("Turn around and strike the tiger", getName()));
        add(new Movement("Spirit dragon turns its head", getName()));
        add(new Movement("Pluck the lotus from the lake", getName()));
        add(new Movement("Wild goose flies south", getName()));
        add(new Movement("Zhoajun catches butterflies", getName()));
        add(new Movement("Flood dragon plays with the pearl", getName()));
        add(new Movement("Roc spreads its wings", getName()));
        add(new Movement("Press the wrist to raise the blind", getName()));
        add(new Movement("Black clouds rolling", getName()));
        add(new Movement("Swing fan up (in back crossed step)", getName()));
        add(new Movement("LIft the arm to look at the flowers", getName()));
        add(new Movement("Willow waves in the breeze", getName()));
        add(new Movement("Dust against the wind", getName()));
        add(new Movement("Pushing the waves", getName()));
        add(new Movement("Turn around and strike with the fan", getName()));
        add(new Movement("Wave long sleeve like flower", getName()));
        add(new Movement("Place a flower in your hair", getName()));
        add(new Movement("Pour water from a golden jar", getName()));
        add(new Movement("Turn around and look at the flowers", getName()));
        add(new Movement("Quin Yu lifts up the tripod", getName()));
        add(new Movement("Spirit fan pierces the mist", getName()));
        add(new Movement("Looking tall to fours seas", getName()));
        add(new Movement("Hold the fan in crouching stance", getName()));
        add(new Movement("White crane spreads its wings", getName()));
        add(new Movement("Wind sweeps the autumn leaves", getName()));
        add(new Movement("Spring returns to the land", getName()));
        add(new Movement("Butterflies fly up and down", getName()));
        add(new Movement("Closing the form", getName()));
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
