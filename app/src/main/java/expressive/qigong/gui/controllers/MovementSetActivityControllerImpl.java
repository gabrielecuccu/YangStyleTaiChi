package expressive.qigong.gui.controllers;

import java.util.Timer;
import java.util.TimerTask;

import expressive.qigong.gui.core.MovementSetActivityController;
import expressive.qigong.gui.core.MovementSetActivityView;
import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;
import expressive.qigong.core.movements.MovementSetFactory;
import expressive.qigong.gui.shuffle.ShuffledDantienSentences;
import expressive.qigong.gui.shuffle.ShuffledFinishSentences;
import expressive.qigong.gui.shuffle.ShuffledLastRepetitionSentences;
import expressive.qigong.gui.shuffle.ShuffledTenPrinciples;
import expressive.qigong.gui.shuffle.ShuffledWarmUps;
import expressive.qigong.gui.shuffle.ShuffledWordList;

public class MovementSetActivityControllerImpl implements MovementSetActivityController {

    private MovementSetActivityView view;

    private MovementSet movementSet;

    private boolean speaking = false;

    private Timer timer;

    private Thread currentSpeakingThread;

    private ShuffledWordList warmUps = new ShuffledWarmUps();

    private ShuffledWordList lastRepetitionSentences = new ShuffledLastRepetitionSentences();

    private ShuffledWordList tenPrinciples = new ShuffledTenPrinciples();

    private ShuffledWordList dantienSentences = new ShuffledDantienSentences();

    private ShuffledWordList finishSentences = new ShuffledFinishSentences();

    public MovementSetActivityControllerImpl(MovementSetActivityView view) {
        this.view = view;
    }

    @Override
    public void backButtonPressed() {
        view.goBack();
    }

    @Override
    public void processIntentExtra(String set) {
        movementSet = MovementSetFactory.getInstance().getMovementSet(set);
        if (movementSet.requiresSettings()) {
            movementSet
                    .includeWarmUp(view.getIncludeWarmUp())
                    .includeFiveGates(view.getIncludeFiveGates())
                    .includeFiveElements(view.getIncludeFiveElements())
                    .includeCoiling(view.getIncludeCoiling())
                    .includeBlackDragon(view.getIncludeBlackDragon())
                    .setNumberOfMovements(view.getNumberOfMovements());
        }
        movementSet.build();
        view.setTitle(movementSet.getName());
    }

    @Override
    public void processMovementSet() {
        StringBuilder movementList = new StringBuilder();
        int index = 1;
        for (Movement movement : movementSet) {
            movementList.append(index++ + ") " + movement.getName()).append("\n\n");
        }

        view.showMovementSet(movementList.toString());
        if (!movementSet.canSpeak()) {
            view.hideSpeakButton();
        }
    }

    @Override
    public void speakButtonClicked() {
        if (speaking) {
            stopSpeaking();
        } else {
            startSpeaking();
        }
    }

    @Override
    public void destroy() {
        if (timer != null) {
            timer.cancel();
        }

        view.shutdownTTS();
        view.stopMusic();
    }

    private void startSpeaking() {
        view.keepScreenOn();

        view.playMusic();

        int movementDuration = view.getMovementDuration() * 1000;
        int halfMovementDuration = (movementDuration - 10000) / 2;

        boolean suggestTenPrinciples = view.getSuggestTenPrinciples();
        boolean addWarmUp = view.getAddWarmUpToAllSets();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentSpeakingThread = Thread.currentThread();

                // Say the set name
                view.say(movementSet.getName());
                sleep(3000);
                if (!speaking) {
                    return;
                }

                if (addWarmUp) {
                    view.say("Let's start with some warm up exercises");
                    sleep(3000);
                    if (!speaking) {
                        return;
                    }

                    view.say("As usual, let's start with swinging arms");
                    sleep(100 * 1000);
                    if (!speaking) {
                        return;
                    }

                    view.say("When you are ready, switch to " + warmUps.next());
                    sleep(100 * 1000);
                    if (!speaking) {
                        return;
                    }

                    view.say("When you are ready, switch to " + warmUps.next());
                    sleep(100 * 1000);
                    if (!speaking) {
                        return;
                    }

                    view.say("Finish there, it's Chee Gong time!");
                    sleep(5000);
                    if (!speaking) {
                        return;
                    }
                }

                int count = 0;
                for (Movement mov : movementSet) {
                    // Say the movement name
                    view.say("number " + (++count) + ". " + mov.getName());
                    sleep((int) (halfMovementDuration * mov.getDuration()));
                    if (!speaking) {
                        return;
                    }

                    // Say a random principle
                    if (mov.hasHint()) {
                        view.say(mov.getHint());
                    } else if (suggestTenPrinciples) {
                        view.say(tenPrinciples.next());
                    }

                    sleep((int) (halfMovementDuration * mov.getDuration()));
                    if (!speaking) {
                        return;
                    }

                    // If this is not the last movement, say it's almost time for the next movement
                    if (count != movementSet.size()) {
                        view.say(lastRepetitionSentences.next());
                        sleep(10000);
                        if (!speaking) {
                            return;
                        }
                    }
                }

                // start fading out
                view.setMediaPlayerVolume(0.4f);
                view.say("This is the last repetition, slowly come to an end and relax your arms.");
                sleep(10000);
                if (!speaking) {
                    return;
                }

                // start fading out
                view.setMediaPlayerVolume(0.3f);

                // Say to dantien breathing
                view.say(dantienSentences.next());
                sleep(10000);
                if (!speaking) {
                    return;
                }

                // fade out
                view.setMediaPlayerVolume(0.20f);
                sleep(10000);
                if (!speaking) {
                    return;
                }

                // fade out
                view.setMediaPlayerVolume(0.1f);

                // Say the set is finished
                view.say(finishSentences.next());
                sleep(5000);
                if (!speaking) {
                    return;
                }

                // fade out
                view.setMediaPlayerVolume(0.05f);
                sleep(2000);
                if (!speaking) {
                    return;
                }

                // fade out
                view.setMediaPlayerVolume(0.025f);
                sleep(2000);

                stopSpeaking();
            }
        }, 100);

        speaking = true;
        view.setSpeakButtonText("Stop");
        view.showProgress();
    }

    private void stopSpeaking() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }

        view.stopTTS();
        speaking = false;

        if (currentSpeakingThread != null) {
            currentSpeakingThread.interrupt();
        }

        view.setSpeakButtonText("Speak");
        view.hideProgress();
        view.clearKeepScreenOn();
        view.stopMusic();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
