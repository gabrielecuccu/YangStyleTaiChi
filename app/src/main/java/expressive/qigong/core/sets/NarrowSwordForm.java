package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class NarrowSwordForm extends SimpleMovementSet {

    public NarrowSwordForm() {
        add(new StandardMovement("Opening the form", getName()));
        add(new StandardMovement("Step up and close the gate", getName()));
        add(new StandardMovement("Immortal points the way", getName()));
        add(new StandardMovement("Three halos around the moon including Big Chief Star", getName()));
        add(new StandardMovement("Swallow swoops on the water", getName()));
        add(new StandardMovement("Left sweep", getName()));
        add(new StandardMovement("Right sweep", getName()));
        add(new StandardMovement("Little chief star", getName()));
        add(new StandardMovement("Yellow bee enters the hole", getName()));
        add(new StandardMovement("Spirit cat catches the mouse", getName()));
        add(new StandardMovement("Dragonfly touches the water", getName()));
        add(new StandardMovement("Swallow enters the nest", getName()));
        add(new StandardMovement("Phoenix spreads its wings", getName()));
        add(new StandardMovement("Whirlwind to right", getName()));
        add(new StandardMovement("Whirlwind to left", getName()));
        add(new StandardMovement("Waiting for fish", getName()));
        add(new StandardMovement("Part the grass in search for the snake", getName()));
        add(new StandardMovement("Birds fly to the forest to roost", getName()));
        add(new StandardMovement("Black dragon waves its tail", getName()));
        add(new StandardMovement("Wind rolls the lotus leaves", getName()));
        add(new StandardMovement("Lion shakes its head", getName()));
        add(new StandardMovement("Tiger holds its head", getName()));
        add(new StandardMovement("Wild horse jumps the stream", getName()));
        add(new StandardMovement("Turning the body to reign the horse", getName()));
        add(new StandardMovement("Compass Point", getName()));
        add(new StandardMovement("Wind blows the dust away", getName()));
        add(new StandardMovement("Push the boat with the current", getName()));
        add(new StandardMovement("Comet chases the moon", getName()));
        add(new StandardMovement("Birds fly over the waterfall", getName()));
        add(new StandardMovement("Raise the screen", getName()));
        add(new StandardMovement("Left wheel sword", getName()));
        add(new StandardMovement("Right wheel sword", getName()));
        add(new StandardMovement("Swallow scoops up mud with its beak", getName()));
        add(new StandardMovement("Roc spreads its wings", getName()));
        add(new StandardMovement("Pluck moon from bottom of the ocean", getName()));
        add(new StandardMovement("Hold moon to the body", getName()));
        add(new StandardMovement("Night demon tests depths of the ocean", getName()));
        add(new StandardMovement("Rhinoceros looks at the moon", getName()));
        add(new StandardMovement("Shoot the geese", getName()));
        add(new StandardMovement("Blue dragon shakes it claws", getName()));
        add(new StandardMovement("Phoenix spreads its wings", getName()));
        add(new StandardMovement("Step over obstacles left/right", getName()));
        add(new StandardMovement("Shoot the geese", getName()));
        add(new StandardMovement("White ape offers up the fruit", getName()));
        add(new StandardMovement("Falling flowers posture", getName()));
        add(new StandardMovement("Jade lady works shuttles", getName()));
        add(new StandardMovement("White tiger waves its tail", getName()));
        add(new StandardMovement("Fish jumps through the dragon gate", getName()));
        add(new StandardMovement("Black dragon wraps around the pole", getName()));
        add(new StandardMovement("Immortal points the way: second form", getName()));
        add(new StandardMovement("The wind blows away the plum flowers", getName()));
        add(new StandardMovement("Hold the tablet", getName()));
        add(new StandardMovement("Hold the sword and return to the beginning", getName()));
        add(new StandardMovement("Close the form", getName()));
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
