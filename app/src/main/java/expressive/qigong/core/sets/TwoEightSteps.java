package expressive.qigong.core.sets;

import expressive.qigong.core.movements.StandardMovement;
import expressive.qigong.core.movements.SimpleMovementSet;

public class TwoEightSteps extends SimpleMovementSet {

    public TwoEightSteps() {
        add(new StandardMovement("Heaven and earth", getName()));
        add(new StandardMovement("Opening the chest", getName()));
        add(new StandardMovement("Dancing with rainbows", getName()));
        add(new StandardMovement("Separating the clouds", getName()));
        add(new StandardMovement("Rolling back the upper arm", getName()));
        add(new StandardMovement("Rowing a boat in the centre of the lake", getName()));
        add(new StandardMovement("Supporting a ball in front of the shoulders", getName()));
        add(new StandardMovement("Turning the body to gaze at the moon", getName()));
        add(new StandardMovement("Pushing the palms", getName()));
        add(new StandardMovement("Hands moving in the clouds", getName()));
        add(new StandardMovement("Dredging the ocean and looking at the sky", getName()));
        add(new StandardMovement("Regulate the Qi with upward and downward movements", getName()));
        add(new StandardMovement("Pushing the waves", getName()));
        add(new StandardMovement("Soothe the chest and abdomen with Qi", getName()));
        add(new StandardMovement("Flying white dove", getName()));
        add(new StandardMovement("Twin dragons coil around the pillar", getName()));
        add(new StandardMovement("Grasp the sparrow’s tail while warding off the tiger", getName()));
        add(new StandardMovement("Lifting and filling with Qi", getName()));
        add(new StandardMovement("Closing the palms", getName()));
        add(new StandardMovement("Charging the fists", getName()));
    }

    @Override
    public String getName() {
        return "28 Step Qi Gong";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }
}
