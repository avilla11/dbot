import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FilterOnOff extends ListenerAdapter {
    public static boolean filterOn = true;
    public void onGuildMessageReceived(GuildMessageReceivedEvent f){
        if(f.getMessage().getContentRaw().equalsIgnoreCase("!togglefilter") && filterOn){ //toggles the filter
            filterOn=false;
            f.getChannel().sendMessage("The filter has been disabled by: " + f.getMember().getUser().getName()).queue();
        }
        else if((f.getMessage().getContentRaw().equalsIgnoreCase("!togglefilter") && filterOn==false)){ //toggles the filter
            filterOn=true;
                    f.getChannel().sendMessage("The filer has been enabled by: " + f.getMember().getUser().getName()).queue();
        }
    }
}
