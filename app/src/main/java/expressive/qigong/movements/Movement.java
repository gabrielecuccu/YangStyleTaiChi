package expressive.qigong.movements;

public class Movement {
    private String name;
    private String set;

    public Movement(String name, String set) {
        this.name = name;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public String getSet() {
        return set;
    }
}
