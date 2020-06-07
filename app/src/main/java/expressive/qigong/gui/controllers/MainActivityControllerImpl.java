package expressive.qigong.gui.controllers;

import expressive.qigong.gui.core.MainActivityController;
import expressive.qigong.gui.core.MainActivityView;
import expressive.qigong.core.sets.EightBreaths;
import expressive.qigong.core.sets.EightPieces;
import expressive.qigong.core.sets.FiveGates;
import expressive.qigong.core.sets.Random;
import expressive.qigong.core.sets.TwoEightSteps;

public class MainActivityControllerImpl implements MainActivityController {

    private MainActivityView view;

    public MainActivityControllerImpl(MainActivityView view) {
        this.view = view;
    }

    @Override
    public void eightPiecesClicked() {
        view.startMovementSetActivity(EightPieces.class);
    }

    @Override
    public void eightBreathClicked() {
        view.startMovementSetActivity(EightBreaths.class);
    }

    @Override
    public void fiveGatesClicked() {
        view.startMovementSetActivity(FiveGates.class);
    }

    @Override
    public void twoEightStepClicked() {
        view.startMovementSetActivity(TwoEightSteps.class);
    }

    @Override
    public void randomClicked() {
        view.startMovementSetActivity(Random.class);
    }
}
