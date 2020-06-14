package expressive.qigong.core.movements;

import expressive.qigong.core.sets.BasicStances;
import expressive.qigong.core.sets.BlackDragonBodyWave;
import expressive.qigong.core.sets.Coiling;
import expressive.qigong.core.sets.EightBreaths;
import expressive.qigong.core.sets.EightPieces;
import expressive.qigong.core.sets.FanForm;
import expressive.qigong.core.sets.FiveElementsBreathing;
import expressive.qigong.core.sets.FiveGates;
import expressive.qigong.core.sets.NarrowSwordForm;
import expressive.qigong.core.sets.Random;
import expressive.qigong.core.sets.SabreForm;
import expressive.qigong.core.sets.ShortForm;
import expressive.qigong.core.sets.TenPrinciples;
import expressive.qigong.core.sets.TwoEightSteps;
import expressive.qigong.core.sets.Walking;
import expressive.qigong.core.sets.WarmUp;

public class MovementSetFactory {
    private final static MovementSetFactory instance = new MovementSetFactory();

    public static MovementSetFactory getInstance() {
        return instance;
    }

    public MovementSet getMovementSet(String name) {
        if (WarmUp.class.getCanonicalName().equals(name)) {
            return new WarmUp();
        } else if (EightPieces.class.getCanonicalName().equals(name)) {
            return new EightPieces();
        } else if (EightBreaths.class.getCanonicalName().equals(name)) {
            return new EightBreaths();
        } else if (TwoEightSteps.class.getCanonicalName().equals(name)) {
            return new TwoEightSteps();
        } else if (FiveGates.class.getCanonicalName().equals(name)) {
            return new FiveGates();
        } else if (Walking.class.getCanonicalName().equals(name)) {
            return new Walking();
        } else if (Coiling.class.getCanonicalName().equals(name)) {
            return new Coiling();
        } else if (BlackDragonBodyWave.class.getCanonicalName().equals(name)) {
            return new BlackDragonBodyWave();
        } else if (Random.class.getCanonicalName().equals(name)) {
            return new Random();
        } else if (TenPrinciples.class.getCanonicalName().equals(name)) {
            return new TenPrinciples();
        } else if (FiveElementsBreathing.class.getCanonicalName().equals(name)) {
            return new FiveElementsBreathing();
        } else if (BasicStances.class.getCanonicalName().equals(name)) {
            return new BasicStances();
        } else if (ShortForm.class.getCanonicalName().equals(name)) {
            return new ShortForm();
        } else if (SabreForm.class.getCanonicalName().equals(name)) {
            return new SabreForm();
        } else if (NarrowSwordForm.class.getCanonicalName().equals(name)) {
            return new NarrowSwordForm();
        } else if (FanForm.class.getCanonicalName().equals(name)) {
            return new FanForm();
        } else {
            return null;
        }
    }
}
