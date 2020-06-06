package expressive.qigong.sets;

import expressive.qigong.movements.Movement;
import expressive.qigong.movements.MovementSet;

public class TwoEightSteps extends MovementSet {

    public TwoEightSteps() {
        add(new Movement("Heaven and earth", getName()));
        add(new Movement("Opening the chest", getName()));
        add(new Movement("Dancing with rainbows", getName()));
        add(new Movement("Separating the clouds", getName()));
        add(new Movement("Rolling back the upper arm", getName()));
        add(new Movement("Rowing a boat in the centre of the lake", getName()));
        add(new Movement("Supporting a ball in front of the shoulders", getName()));
        add(new Movement("Turning the body to gaze at the moon", getName()));
        add(new Movement("Pushing the palms", getName()));
        add(new Movement("Hands moving in the clouds", getName()));
        add(new Movement("Dredging the ocean and looking at the sky", getName()));
        add(new Movement("Regulate the Qi with upward and downward movements", getName()));
        add(new Movement("Pushing the waves", getName()));
        add(new Movement("Soothe the chest and abdomen with Qi", getName()));
        add(new Movement("Flying white dove", getName()));
        add(new Movement("Twin dragons coil around the pillar", getName()));
        add(new Movement("Grasp the sparrow’s tail while warding off the tiger", getName()));
        add(new Movement("Lifting and filling with Qi", getName()));
        add(new Movement("Closing the palms", getName()));
        add(new Movement("Charging the fists", getName()));
    }

    @Override
    public String getName() {
        return "28 Step Qi Gong";
    }
}
