import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import commands.CalculateCommands;
import commands.FilterMessage;
import commands.ServerInfo;
import events.CategoryCreate;
import events.GuildLeave;
import events.HelloEvent;
import events.InviteCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class bot extends ListenerAdapter {

    public static void main(String args[]) throws Exception{
        JDA jda = new JDABuilder("").build(); //left token out; insert token to use
        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new CategoryCreate());
        jda.addEventListener((new CalculateCommands()));
        jda.addEventListener(new InviteCommand());
        jda.addEventListener(new Filter());
        jda.addEventListener(new FilterMessage());
        jda.addEventListener(new FilterOnOff());
        jda.addEventListener(new GuildLeave());

        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(""); //left token out; insert token to use
        builder.setPrefix("!");
        builder.setHelpWord("help");
        builder.addCommand(new ServerInfo());

        CommandClient client = builder.build();
        jda.addEventListener(client);
    }





}
