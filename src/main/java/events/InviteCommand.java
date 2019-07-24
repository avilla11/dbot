package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InviteCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("!invite")&& message.length==1){
            e.getChannel().sendMessage("to use the command, type !invite create").queue();
        }
        else if(message.length >= 2 && message[0].equalsIgnoreCase("!invite") && message[1].equalsIgnoreCase("create")){
            e.getChannel().sendMessage("Hey " + e.getAuthor().getName() + "! Do you want to invite someone?").queue();
            e.getChannel().sendMessage("Give them this link: " + e.getChannel().createInvite().complete().getUrl()).queue();
        }
    }
}
