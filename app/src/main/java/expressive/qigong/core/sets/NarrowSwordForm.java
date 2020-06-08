package expressive.qigong.core.sets;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class NarrowSwordForm extends MovementSet {

    public NarrowSwordForm() {
        add(new Movement("Opening the form", getName()));
        add(new Movement("Step up and close the gate", getName()));
        add(new Movement("Immortal points the way", getName()));
        add(new Movement("Three halos around the moon including Big Chief Star", getName()));
        add(new Movement("Swallow swoops on the water", getName()));
        add(new Movement("Left sweep", getName()));
        add(new Movement("Right sweep", getName()));
        add(new Movement("Little chief star", getName()));
        add(new Movement("Yellow bee enters the hole", getName()));
        add(new Movement("Spirit cat catches the mouse", getName()));
        add(new Movement("Dragonfly touches the water", getName()));
        add(new Movement("Swallow enters the nest", getName()));
        add(new Movement("Phoenix spreads its wings", getName()));
        add(new Movement("Whirlwind to right", getName()));
        add(new Movement("Whirlwind to left", getName()));
        add(new Movement("Waiting for fish", getName()));
        add(new Movement("Part the grass in search for the snake", getName()));
        add(new Movement("Birds fly to the forest to roost", getName()));
        add(new Movement("Black dragon waves its tail", getName()));
        add(new Movement("Wind rolls the lotus leaves", getName()));
        add(new Movement("Lion shakes its head", getName()));
        add(new Movement("Tiger holds its head", getName()));
        add(new Movement("Wild horse jumps the stream", getName()));
        add(new Movement("Turning the body to reign the horse", getName()));
        add(new Movement("Compass Point", getName()));
        add(new Movement("Wind blows the dust away", getName()));
        add(new Movement("Push the boat with the current", getName()));
        add(new Movement("Comet chases the moon", getName()));
        add(new Movement("Birds fly over the waterfall", getName()));
        add(new Movement("Raise the screen", getName()));
        add(new Movement("Left wheel sword", getName()));
        add(new Movement("Right wheel sword", getName()));
        add(new Movement("Swallow scoops up mud with its beak", getName()));
        add(new Movement("Roc spreads its wings", getName()));
        add(new Movement("Pluck moon from bottom of the ocean", getName()));
        add(new Movement("Hold moon to the body", getName()));
        add(new Movement("Night demon tests depths of the ocean", getName()));
        add(new Movement("Rhinoceros looks at the moon", getName()));
        add(new Movement("Shoot the geese", getName()));
        add(new Movement("Blue dragon shakes it claws", getName()));
        add(new Movement("Phoenix spreads its wings", getName()));
        add(new Movement("Step over obstacles left/right", getName()));
        add(new Movement("Shoot the geese", getName()));
        add(new Movement("White ape offers up the fruit", getName()));
        add(new Movement("Falling flowers posture", getName()));
        add(new Movement("Jade lady works shuttles", getName()));
        add(new Movement("White tiger waves its tail", getName()));
        add(new Movement("Fish jumps through the dragon gate", getName()));
        add(new Movement("Black dragon wraps around the pole", getName()));
        add(new Movement("Immortal points the way: second form", getName()));
        add(new Movement("The wind blows away the plum flowers", getName()));
        add(new Movement("Hold the tablet", getName()));
        add(new Movement("Hold the sword and return to the beginning", getName()));
        add(new Movement("Close the form", getName()));
    }

    @Override
    public String getName() {
        return "Narrow sword form";
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}
