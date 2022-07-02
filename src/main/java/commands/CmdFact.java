package commands;

import api.Facts;
import ca.tristan.jdacommands.ICommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdFact implements ICommand {
    @Override
    public String getName() {
        return "fact";
    }

    @Override
    public void execute(MessageReceivedEvent messageReceivedEvent) {
        MessageChannel channel = messageReceivedEvent.getChannel();
        Message message = messageReceivedEvent.getMessage();
        User author = messageReceivedEvent.getAuthor();
        String msg = message.getContentDisplay();

        Facts facts = new Facts();
        try {
            String randomFact = facts.randomFact();
            channel.sendMessage(randomFact).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
