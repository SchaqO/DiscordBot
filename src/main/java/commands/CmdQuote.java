package commands;

import api.ZenQuotes;
import ca.tristan.jdacommands.ICommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdQuote implements ICommand {
    @Override
    public String getName() {
        return "quote";
    }

    @Override
    public void execute(MessageReceivedEvent messageReceivedEvent) {
        MessageChannel channel = messageReceivedEvent.getChannel();
        Message message = messageReceivedEvent.getMessage();
        User author = messageReceivedEvent.getAuthor();
        String msg = message.getContentDisplay();


        ZenQuotes quotes = new ZenQuotes();
        try {
            String quote = quotes.parseURL();
            channel.sendMessage(quote).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
