import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static commands.FilterMessage.allowed;

public class Filter extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent filter){
        if (FilterOnOff.filterOn==true) {

            String[] LIST_OF_BAD_WORDS = {"placeholder"}; //only put placeholder as a word in the array because it would seem unprofessional to put actual words that need to be filtered. Replace placeholder with a list of words you wish to be filtered
            String[] message = filter.getMessage().getContentRaw().split(" ");
            for (int i = 0; i < message.length; i++) { //the first array iterates through the length of the message typed by the user
                for (int j = 0; j < LIST_OF_BAD_WORDS.length; j++) { //the second array iterates through the list of bad words provided and checks if any math with the if statement below
                    if (message[i].equalsIgnoreCase(LIST_OF_BAD_WORDS[j])) {
                        filter.getMessage().delete().queue(); //deletes the bad word before printing the message below
                        if(allowed=true){
                            filter.getChannel().sendMessage("Dont use curse words").queue();
                        }
                    }
                }
            }
        }
        else if(FilterOnOff.filterOn==false){ //calling the static
            System.out.println("The filter is off"); //prints if the filter has been toggled off
        }
    }
}
