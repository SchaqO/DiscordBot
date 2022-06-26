package events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        if(!event.getGuild().getId().equals("887342154245083146")) {
            return;
        }

        event.getGuild().getTextChannelById("986649971308777522").sendMessage("Welcome to the server! " + event.getMember().getAsMention()).queue();
    }
}
