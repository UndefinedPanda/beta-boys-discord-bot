package ca.northshoretech;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class Riddle {

    // TODO: Make this available to be used in multiple guilds

    private final UUID uuid;
    private final String riddle;
    private final String answer;
    private boolean isCompleted = false;

    private TextChannel channel;
    private final Timer timer;
    private TimerTask timerTask;

    public Riddle(TextChannel channel, String riddle, String answer) {
        this.channel = channel;
        this.uuid = UUID.randomUUID();
        this.riddle = riddle;
        this.answer = answer;
        this.timer = new Timer();

        initializeTimer();
    }

    /**
     * initialize the timer task which will post the riddle answer at 11:59pm EST
     */
    private void initializeTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                BetaBoys.getRiddleManager().sendRiddleAnswer(channel);
                BetaBoys.getRiddleManager().removeRiddleFromList();
                timer.cancel();
            }
        };

        // Set the time for the timer to execute at 11:59PM
        Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR_OF_DAY, 21);
        date.set(Calendar.MINUTE, 36);
        date.set(Calendar.SECOND, 0);

        timer.schedule(timerTask, date.getTime());
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
