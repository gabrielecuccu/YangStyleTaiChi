package expressive.qigong.core.movements;

public class StandardMovement extends Movement {
    public StandardMovement(String name, String set) {
        super(name, set, "", 1);
    }

    public StandardMovement(String name, String set, String hint) {
        super(name, set, hint, 1);
    }
}
