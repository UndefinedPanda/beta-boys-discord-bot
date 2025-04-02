package ca.northshoretech;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class BetaBoys {

    private final ShardManager shardManager;
    private final Dotenv config;

    public BetaBoys() throws LoginException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        
        if (token == null) throw new LoginException("There was no token in the dot env file");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching("Beta Boys Streamers"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return this.shardManager;
    }

    public static void main(String[] args) {
        try {
            BetaBoys bot = new BetaBoys();
        } catch (LoginException e) {
            System.err.println("There was an error with the discord login token");
            throw new RuntimeException(e);
        }
    }
}