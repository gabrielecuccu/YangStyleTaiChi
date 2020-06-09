package expressive.qigong.gui.controllers;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import expressive.qigong.gui.core.MovementSetActivityController;
import expressive.qigong.gui.core.MovementSetActivityView;
import expressive.qigong.core.movements.Movement;
import expressive.qigong.core.movements.MovementSet;
import expressive.qigong.core.movements.MovementSetFactory;

public class MovementSetActivityControllerImpl implements MovementSetActivityController {

    private MovementSetActivityView view;

    private MovementSet movementSet;

    private boolean speaking = false;

    private Timer timer;

    private Thread currentSpeakingThread;

    private String[] lastRepetitionSentences = new String[] {
            "ten more seconds",
            "make this your last one",
            "almost there",
            "almost time for the next one"
    };

    private String[] tenPrinciples = new String[] {
            "remember to suspend the head from the sky",
            "remember to sink the chest, open the upper back",
            "remember to loosen the waist",
            "remember to sink the shoulders, drop the elbows",
            "remember to distinguish between full and empty",
            "remember to use will, not strength",
            "remember to coordinate the upper and lower body",
            "remember to unify external and internal movements",
            "remember the unbroken continuity of flow",
            "remember to seek stillness in movement"
    };

    private String[] dantienSentences = new String[] {
            "Close your eyes. Dantien breathing",
            "Put your hands on your Dantien",
            "Finish there. Dantien breating",
            "Dantien breathing"
    };

    private String[] finishSentences = new String[] {
            "Open your eyes. Thank you",
            "Open your eyes. Finished",
            "Open your eyes. Enjoy the rest of your day",
            "Open your eyes. I hope you enjoyed this session",
            "See you next time. Thank you",
            "Finished. See you next time",
            "Finished. Thank you.",
            "Finished. Enjoy the rest of your day"
    };

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
                    .includeBlackDragon(view.getIncludeBlackDragon());
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
    }

    private void startSpeaking() {
        int movementDuration = view.getMovementDuration() * 1000;
        int halfMovementDuration = (movementDuration - 10000) / 2;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentSpeakingThread = Thread.currentThread();

                // Say the set name
                view.say(movementSet.getName());
                sleep(2000);
                if (!speaking) {
                    return;
                }

                int count = 0;
                for (Movement mov : movementSet) {
                    // Say the movement name
                    view.say("number " + (++count) + ". " + mov.getName());
                    sleep(halfMovementDuration);
                    if (!speaking) {
                        return;
                    }

                    // Say a random principle
                    int randomIndex = new Random().nextInt(tenPrinciples.length);
                    String principle = tenPrinciples[randomIndex];
                    view.say(principle);
                    sleep(halfMovementDuration);
                    if (!speaking) {
                        return;
                    }

                    // Say it's almost time for the next movement
                    randomIndex = new Random().nextInt(lastRepetitionSentences.length);
                    String text = lastRepetitionSentences[randomIndex];
                    view.say(text);
                    sleep(10000);
                    if (!speaking) {
                        return;
                    }
                }

                // Say to dantien breathing
                int randomIndex = new Random().nextInt(dantienSentences.length);
                String text = dantienSentences[randomIndex];
                view.say(text);
                sleep(10000);
                if (!speaking) {
                    return;
                }

                // Say the set is finished
                randomIndex = new Random().nextInt(finishSentences.length);
                text = finishSentences[randomIndex];
                view.say(text);
                sleep(5000);
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
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
