package expressive.qigong.core.movements;

import expressive.qigong.core.sets.EightBreaths;
import expressive.qigong.core.sets.EightPieces;
import expressive.qigong.core.sets.FiveGates;
import expressive.qigong.core.sets.Random;
import expressive.qigong.core.sets.TwoEightSteps;

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
