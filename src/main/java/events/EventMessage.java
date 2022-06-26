package events;

import api.ZenQuotes;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventMessage extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.TEXT)) {
            MessageChannel channel = event.getChannel();
            Message message = event.getMessage();
            User author = event.getAuthor();
            String msg = message.getContentDisplay();

            if (msg.equals("!ping")){
                channel.sendMessage("pong! " + author.getName()).queue();
            }

            if (msg.equals("=quote")) {
                ZenQuotes quotes = new ZenQuotes();
                try {
                    String quote = quotes.parseURL();
                    channel.sendMessage(quote).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //printing guild messages to console
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());

        }
        else {
            System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
        }
    }
}
