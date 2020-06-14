package expressive.qigong.core.movements;

import android.text.TextUtils;

public abstract class Movement {
    private String name;
    private String set;
    private String hint;
    private float duration;

    public Movement(String name, String set, String hint, float duration) {
        this.name = name;
        this.set = set;
        this.hint = hint;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getSet() {
        return set;
    }

    public boolean hasHint() {
        return !TextUtils.isEmpty(this.hint);
    }

    public String getHint() {
        return hint;
    }

    public float getDuration() {
        return duration;
    }
}
