package commands;

import ca.tristan.jdacommands.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class CmdClear implements ICommand {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public void execute(MessageReceivedEvent messageReceivedEvent) {

        String[] args = messageReceivedEvent.getMessage().getContentRaw().split(" ");

        if(args.length != 2){
            return;
        }

        if(!isNumber(args[1])) {
            messageReceivedEvent.getChannel().sendMessage("Awa chyta 7aiwan, awa to bashari, number retard number.").queue();
            return;
        }

        //only allow for admins
        Guild guild = messageReceivedEvent.getGuild();
        Role role = guild.getRoleById("887347823908114563");
        List<Member> members = guild.getMembersWithRoles(role);
        if(!members.contains(messageReceivedEvent.getMember())) {
            messageReceivedEvent.getChannel().sendMessage("You're black, you have no rights").queue();
            return;
        }


        List<Message> messageList = messageReceivedEvent.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]) + 1).complete();
        messageReceivedEvent.getTextChannel().deleteMessages(messageList).queue();

    }

    private boolean isNumber(String msg){
        try {
            Integer.parseInt(msg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
