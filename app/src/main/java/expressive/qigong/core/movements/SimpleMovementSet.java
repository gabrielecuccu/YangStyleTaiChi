package expressive.qigong.core.movements;

public abstract class SimpleMovementSet extends MovementSet {

    @Override
    public boolean requiresSettings() {
        return false;
    }

    public MovementSet includeWarmUp(boolean b) {
        return this;
    }

    @Override
    public MovementSet includeFiveGates(boolean b) {
        return null;
    }

    @Override
    public MovementSet includeFiveElements(boolean b) {
        return null;
    }

    @Override
    public MovementSet includeCoiling(boolean b) {
        return null;
    }

    @Override
    public MovementSet includeBlackDragon(boolean b) {
        return null;
    }

    @Override
    public MovementSet setNumberOfMovements(int i) {
        return null;
    }

    public void build() {

    }
}
