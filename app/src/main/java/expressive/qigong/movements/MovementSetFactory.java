package expressive.qigong.movements;

import expressive.qigong.sets.EightBreaths;
import expressive.qigong.sets.EightPieces;
import expressive.qigong.sets.FiveGates;
import expressive.qigong.sets.Random;
import expressive.qigong.sets.TwoEightSteps;

public class MovementSetFactory {
    private final static MovementSetFactory instance = new MovementSetFactory();

    public static MovementSetFactory getInstance() {
        return instance;
    }

    public MovementSet getMovementSet(String name) {
        if (EightPieces.class.getCanonicalName().equals(name)) {
            return new EightPieces();
        } else if (EightBreaths.class.getCanonicalName().equals(name)) {
            return new EightBreaths();
        } else if (TwoEightSteps.class.getCanonicalName().equals(name)) {
            return new TwoEightSteps();
        }  else if (FiveGates.class.getCanonicalName().equals(name)) {
            return new FiveGates();
        } else if (Random.class.getCanonicalName().equals(name)) {
            return new Random();
        }  else {
            return null;
        }
    }
}
