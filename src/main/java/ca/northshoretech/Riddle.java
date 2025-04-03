package ca.northshoretech;

import java.util.UUID;

public class Riddle {

    // TODO: Make this available to be used in multiple guilds

    private final UUID uuid;
    private final String riddle;
    private final String answer;
    private boolean isCompleted = false;

    public Riddle(String riddle, String answer) {
        this.uuid = UUID.randomUUID();
        this.riddle = riddle;
        this.answer = answer;
    }

    /**
     * gets the id of the riddle
     *
     * @return UUID
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * gets the riddle content
     *
     * @return String
     */
    public String getRiddle() {
        return riddle;
    }

    /**
     * gets the answer of the riddle
     *
     * @return String
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * sets is completed for the riddle
     *
     * @param isCompleted determines whether the riddle is completed
     */
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    /**
     * gets is completed from the riddle
     *
     * @return boolean
     */
    public boolean isCompleted() {
        return isCompleted;
    }
}
