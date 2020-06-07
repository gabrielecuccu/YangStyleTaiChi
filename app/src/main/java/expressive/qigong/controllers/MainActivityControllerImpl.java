package expressive.qigong.controllers;

import expressive.qigong.core.MainActivityController;
import expressive.qigong.core.MainActivityView;
import expressive.qigong.sets.EightBreaths;
import expressive.qigong.sets.EightPieces;
import expressive.qigong.sets.FiveGates;
import expressive.qigong.sets.Random;
import expressive.qigong.sets.TwoEightSteps;

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
