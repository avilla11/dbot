package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ServerInfo extends Command{ //extends the command interface
    public ServerInfo(){
        this.name = "serverinfo";
        this.aliases = new String[]{"server"};
        this.help = "Gives information about the server";
    }
    protected void execute(CommandEvent c){
        c.reply("For server info, a list of commands and general help, message the server owner");
    }
}

