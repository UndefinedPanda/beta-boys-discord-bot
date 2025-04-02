package ca.northshoretech.commands;

import ca.northshoretech.BetaBoys;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class DailyQuestionCommand extends ListenerAdapter {

    private final String prefix = BetaBoys.getConfig().get("PREFIX");

    /**
     * Handles incoming messages for the daily question command
     *
     * @param event the message received event
     */
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        // check which channel the message is being sent in
        // check if author is admin
        // get the message content and author if the message

        if (!event.getMessage().getContentRaw().startsWith(prefix + "qotd"))
            return;

        String question = event.getMessage().getContentRaw();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Question of The Day!");
        embedBuilder.setColor(Color.BLUE);


    }
}
