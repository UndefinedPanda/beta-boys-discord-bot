package ca.northshoretech.commands;

import ca.northshoretech.BetaBoys;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.Timestamp;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;

public class DailyRiddleCommand extends ListenerAdapter {

    private final String prefix = BetaBoys.getConfig().get("PREFIX");
    private final String commandPrefix = prefix + "rotd";

    /**
     * Handles incoming messages for the daily riddle command
     *
     * @param event the message received event
     */
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        // check if the message is being sent in the correct admin channel
        // check if author is admin
        // get the message content and author if the message

        // send the message in the Question of The Day channel

        if (!event.getMessage().getContentRaw().startsWith(commandPrefix))
            return;

        String riddle = event.getMessage().getContentRaw().substring(commandPrefix.length());

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Riddle of The Day!");
        embedBuilder.setColor(Color.BLUE);
        embedBuilder.setDescription(riddle);
        embedBuilder.setTimestamp(Instant.now());
        embedBuilder.setFooter("Powered By BetaBoys", "https://media.discordapp.net/attachments/1352001410069172387/1352464998886277161/image.jpg?ex=67dec56f&is=67dd73ef&hm=ef420dc5c3306558c8e6b4c732dccdda0356f1e8ccedaf3c6e5fdbaaa6314fb7&=&format=webp&width=960&height=960");

        event.getChannel().sendMessage("@everyone").setEmbeds(embedBuilder.build()).queue();
    }
}
