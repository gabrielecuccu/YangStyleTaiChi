package expressive.qigong.gui.core;

public interface MovementSetActivityView {

    void goBack();

    void setTitle(String title);

    void showMovementSet(String movements);

    void stopTTS();

    void setSpeakButtonText(String text);

    void hideProgress();

    void showProgress();

    void say(String sentence);

    void shutdownTTS();

    void hideSpeakButton();

    boolean getIncludeWarmUp();

    boolean getIncludeFiveGates();

    boolean getIncludeFiveElements();

    boolean getIncludeCoiling();

    boolean getIncludeBlackDragon();

    int getMovementDuration();

    boolean getSuggestTenPrinciples();
}
