import api.ZenQuotes;
import events.EventJoin;
import events.EventMessage;
import model.ZenQuotesModel;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import io.github.cdimascio.dotenv.Dotenv;

import javax.security.auth.login.LoginException;
import java.util.Arrays;

public class Main extends ListenerAdapter {

    public static final GatewayIntent[] INTENTS = {GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_VOICE_STATES};

    public static void main(String[] args) throws LoginException {

        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("TOKEN");
        JDA jda = JDABuilder.create(token, Arrays.asList(INTENTS))
                .enableCache(CacheFlag.VOICE_STATE)
                .setActivity(Activity.playing("TEST ACTIVITY STATUS"))
                .setStatus(OnlineStatus.ONLINE)
                .addEventListeners(new EventJoin())
                .addEventListeners(new EventMessage())
                .build();
        jda.addEventListener(new Main());
    }
}
