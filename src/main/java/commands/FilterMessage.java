package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FilterMessage extends ListenerAdapter {
    public static boolean allowed = true; //boolean variable to check if the filter is on
    public void onGuildReceivedMessage(GuildMessageReceivedEvent filt){
        if(filt.getMessage().getContentRaw().equalsIgnoreCase("!filtermessage") && allowed){
            filt.getChannel().sendMessage("The filter has been disabled").queue(); //prints if the filter has been disabled
            System.out.println("Disabled");
            allowed = false;
        }
        else if(filt.getMessage().getContentRaw().equalsIgnoreCase("!filtermessage") && !allowed){
            filt.getChannel().sendMessage("Filter has been enabled").queue(); //prints if the filter has been enabled
            System.out.println("Enabled");
            allowed = true;
        }

    }
}
