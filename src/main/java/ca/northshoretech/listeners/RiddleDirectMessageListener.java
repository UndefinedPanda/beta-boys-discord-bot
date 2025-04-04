package ca.northshoretech.listeners;

import ca.northshoretech.BetaBoys;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class RiddleDirectMessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        BetaBoys.getLogger().info("called from dm");
    }
}
