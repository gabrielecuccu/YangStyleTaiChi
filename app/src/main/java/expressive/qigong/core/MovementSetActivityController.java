package expressive.qigong.core;

public interface MovementSetActivityController {

    void backButtonPressed();

    void processIntentExtra(String set);

    void processMovementSet();

    void speakButtonClicked();

    void destroy();
}
