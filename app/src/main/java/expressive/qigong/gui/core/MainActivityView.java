package expressive.qigong.gui.core;

import expressive.qigong.core.movements.MovementSet;

public interface MainActivityView {
    void startMovementSetActivity(Class<? extends MovementSet> clazz);
}
