package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CalculateCommands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split(" ");
        int num1 = Integer.parseInt((message[2])); //reads the number entered
        int num2 = Integer.parseInt(message[3]);   //reads the number entered
        int num3 = num1 + num2; //handles addition of num1 and num2 and stores it in a new variable, num3
        int num4 = num1 - num2; //handles the subtraction of num1 and num2 and stores it in a new variable, num4
        int num5 = num1 * num2; //handles the multiplication of num1 and num2 and stores it in a new variable, num5
        int num6 = num1 / num2; //handles the division of num1 and num2 and stores it in a new variable, num6

        if (message[0].equalsIgnoreCase("!calculate") && message.length == 1){
            e.getChannel().sendMessage("to use the command use !calculate followed by add, subtract multiply or divide followed by two numbers").queue();
        }
       else if (message[0].equalsIgnoreCase("!calculate")&& message[1].equalsIgnoreCase("add")) {
            e.getChannel().sendMessage("this is the result: " + num3).queue();
        }
        else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("subtract")){
            e.getChannel().sendMessage("this is the result: " + num4).queue();
        }
        else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("multiply")){
            e.getChannel().sendMessage("this is the result: " + num5).queue();
        }
        else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("divide")){
            e.getChannel().sendMessage("this is the result: " + num6).queue();
        }
    }
}
