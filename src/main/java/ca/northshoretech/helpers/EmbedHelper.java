package ca.northshoretech.helpers;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.awt.*;
import java.time.Instant;

public class EmbedHelper {

    public static void sendErrorEmbed(MessageChannel channel, String errorMessage) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("An error has occurred");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setDescription(errorMessage);
        embedBuilder.setTimestamp(Instant.now());
        embedBuilder.setFooter("Powered By BetaBoys", "https://media.discordapp.net/attachments/1352001410069172387/1352464998886277161/image.jpg?ex=67dec56f&is=67dd73ef&hm=ef420dc5c3306558c8e6b4c732dccdda0356f1e8ccedaf3c6e5fdbaaa6314fb7&=&format=webp&width=960&height=960");
        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendWarningEmbed(MessageChannel channel, String warningMessage) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Warning!");
        embedBuilder.setColor(Color.YELLOW);
        embedBuilder.setDescription(warningMessage);
        embedBuilder.setTimestamp(Instant.now());
        embedBuilder.setFooter("Powered By BetaBoys", "https://media.discordapp.net/attachments/1352001410069172387/1352464998886277161/image.jpg?ex=67dec56f&is=67dd73ef&hm=ef420dc5c3306558c8e6b4c732dccdda0356f1e8ccedaf3c6e5fdbaaa6314fb7&=&format=webp&width=960&height=960");
        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendCorrectRiddleAnswerToChannel(MessageChannel channel, User user) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Winner Winner, Chicken Dinner!");
        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setDescription(user.getAsMention() + " has guessed the correct answer!");
        embedBuilder.setTimestamp(Instant.now());
        embedBuilder.setFooter("Powered By BetaBoys", "https://media.discordapp.net/attachments/1352001410069172387/1352464998886277161/image.jpg?ex=67dec56f&is=67dd73ef&hm=ef420dc5c3306558c8e6b4c732dccdda0356f1e8ccedaf3c6e5fdbaaa6314fb7&=&format=webp&width=960&height=960");
        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendRiddleAnswerResponseToDM(MessageChannel channel, boolean correctAnswer) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        if (correctAnswer) {
            embedBuilder.setTitle("Answer Correct!");
            embedBuilder.setColor(Color.GREEN);
            embedBuilder.setDescription("Good job! You got the answer correct!!");
        } else {
            embedBuilder.setTitle("Wrong Answer!");
            embedBuilder.setColor(Color.RED);
            embedBuilder.setDescription("Sorry, wrong answer! Try again.");
        }
        embedBuilder.setTimestamp(Instant.now());
        embedBuilder.setFooter("Powered By BetaBoys", "https://media.discordapp.net/attachments/1352001410069172387/1352464998886277161/image.jpg?ex=67dec56f&is=67dd73ef&hm=ef420dc5c3306558c8e6b4c732dccdda0356f1e8ccedaf3c6e5fdbaaa6314fb7&=&format=webp&width=960&height=960");
        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
