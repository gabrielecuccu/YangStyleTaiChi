package expressive.qigong.gui.controllers;

import expressive.qigong.core.sets.BasicStances;
import expressive.qigong.core.sets.FiveElementsBreathing;
import expressive.qigong.core.sets.TenPrinciples;
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

    @Override
    public void tenPrinciplesClicked() {
        view.startMovementSetActivity(TenPrinciples.class);
    }

    @Override
    public void fiveElementsClicked() {
        view.startMovementSetActivity(FiveElementsBreathing.class);
    }

    @Override
    public void basicStancesClicked() {
        view.startMovementSetActivity(BasicStances.class);
    }
}
