package expressive.qigong.core.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;

public class Random extends MovementSet {

    private boolean includeWarmUp = false;

    private boolean includeFiveGates = false;

    private boolean includeFiveElements = false;

    private boolean includeCoiling = false;

    private boolean includeBlackDragon = false;

    private int numberOfMovements = 10;

    public Random() {

    }

    @Override
    public String getName() {
        return "Ten minutes Qi Gong";
    }

    @Override
    public boolean canSpeak() {
        return true;
    }

    @Override
    public boolean requiresSettings() {
        return true;
    }

    @Override
    public MovementSet includeWarmUp(boolean include) {
        this.includeWarmUp = include;
        return this;
    }

    @Override
    public MovementSet includeFiveGates(boolean include) {
        this.includeFiveGates = include;
        return this;
    }

    @Override
    public MovementSet includeFiveElements(boolean include) {
        this.includeFiveElements = include;
        return this;
    }

    @Override
    public MovementSet includeCoiling(boolean include) {
        this.includeCoiling = include;
        return this;
    }

    @Override
    public MovementSet includeBlackDragon(boolean include) {
        this.includeBlackDragon = include;
        return this;
    }

    @Override
    public MovementSet setNumberOfMovements(int numberOfMovements) {
        this.numberOfMovements = numberOfMovements;
        return this;
    }

    @Override
    public void build() {
        List<Movement> movs = new ArrayList<>();
        if (includeWarmUp) {
            movs.addAll(new WarmUp());
        }

        if (includeFiveGates) {
            movs.addAll(new FiveGates());
        }

        if (includeFiveElements) {
            movs.addAll(new FiveElementsBreathing());
        }

        if (includeCoiling) {
            movs.addAll(new Coiling());
        }

        if (includeBlackDragon) {
            movs.addAll(new BlackDragonBodyWave());
        }

        movs.addAll(new EightPieces());
        movs.addAll(new EightBreaths());
        movs.addAll(new TwoEightSteps());

        Collections.shuffle(movs);
        movs = movs.subList(0, numberOfMovements);

        for (Movement mov : movs) {
            add(new Movement("From " + mov.getSet() + ":\n" + mov.getName() + "\n", getName()));
        }
    }
}
