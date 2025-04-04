package ca.northshoretech.managers;

import ca.northshoretech.Riddle;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RiddleManager {

    private final ArrayList<Riddle> activeRiddles;

    public RiddleManager() {
        this.activeRiddles = new ArrayList<>();
    }

    public void sendRiddleAnswer(TextChannel channel) {
        final Riddle riddle = activeRiddles.getFirst();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("The Answer For The Riddle of The Day is!");
        embedBuilder.setColor(Color.MAGENTA);
        embedBuilder.setDescription(riddle.getAnswer());
        embedBuilder.setTimestamp(Instant.now());
        embedBuilder.setFooter("Powered By BetaBoys", "https://media.discordapp.net/attachments/1352001410069172387/1352464998886277161/image.jpg?ex=67dec56f&is=67dd73ef&hm=ef420dc5c3306558c8e6b4c732dccdda0356f1e8ccedaf3c6e5fdbaaa6314fb7&=&format=webp&width=960&height=960");
        channel.sendMessageEmbeds(embedBuilder.build()).queue();

        riddle.setIsCompleted(true);
    }

    public void addRiddleToList(Riddle riddle) {
        // TODO: Make sure theres only one riddle in the list, duplicates may cause issues with the thread scheduling of sending the response
        activeRiddles.add(riddle);
    }

    public void removeRiddleFromList() {
        activeRiddles.removeFirst();
    }

}
