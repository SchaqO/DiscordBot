package commands;

import ca.tristan.jdacommands.ICommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdHello implements ICommand {
    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public void execute(MessageReceivedEvent messageReceivedEvent) {
        messageReceivedEvent.getChannel().sendMessage("Hello World!").queue();

    }
}
