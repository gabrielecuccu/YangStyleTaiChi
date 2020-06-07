package expressive.qigong.core;

import expressive.qigong.movements.MovementSet;

public interface MainActivityView {
    void startMovementSetActivity(Class<? extends MovementSet> clazz);
}
