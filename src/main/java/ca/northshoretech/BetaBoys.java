package ca.northshoretech;

import ca.northshoretech.commands.DailyQuestionCommand;
import ca.northshoretech.commands.DailyRiddleCommand;
import ca.northshoretech.listeners.ReadyListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class BetaBoys {

    private static final Logger logger = LoggerFactory.getLogger(BetaBoys.class);

    private final ShardManager shardManager;
    private static final Dotenv config = Dotenv.configure().load();

    /**
     * Loads environment variables and builds the bot shard manager
     *
     * @throws LoginException
     */
    public BetaBoys() throws LoginException {
        String token = config.get("TOKEN");

        // Check to make sure the token is valid from the dotenv file
        if (token == null) throw new LoginException("There was no token in the dot env file");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching("Beta Boys Streamers"));
        shardManager = builder.build();

        // Register event listeners
        shardManager.addEventListener(new ReadyListener());
        shardManager.addEventListener(new DailyQuestionCommand());
        shardManager.addEventListener(new DailyRiddleCommand());
    }

    /**
     * Main entry point to the bot
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            BetaBoys bot = new BetaBoys();
        } catch (LoginException e) {
            getLogger().error("There was an error with the discord login token");
//            System.err.println("There was an error with the discord login token");
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the created shard manager
     *
     * @return the ShardManager instance
     */
    public ShardManager getShardManager() {
        return this.shardManager;
    }

    /**
     * Gets the dotenv config
     *
     * @return Dotenv config
     */
    public static Dotenv getConfig() {
        return config;
    }

    /**
     * Gets the static logger instance
     *
     * @return Logger for SLF4J
     */
    public static Logger getLogger() {
        return logger;
    }

}