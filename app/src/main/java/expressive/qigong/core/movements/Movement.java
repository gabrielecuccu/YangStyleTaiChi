package expressive.qigong.core.movements;

public abstract class Movement {
    private String name;
    private String set;
    private float duration;

    public Movement(String name, String set, float duration) {
        this.name = name;
        this.set = set;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getSet() {
        return set;
    }

    public float getDuration() {
        return duration;
    }
}
