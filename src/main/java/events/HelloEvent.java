package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Random;

public class HelloEvent extends ListenerAdapter { //method that has the bot print hello followed by their name when a user types hi
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();
        if(messageSent[0].equalsIgnoreCase("hi")){
                if(!event.getMember().getUser().isBot()){
                    event.getChannel().sendMessage("hello " + name).queue();
                }
            }
        }

    @Override
    public void onCategoryDelete(@Nonnull CategoryDeleteEvent cat) { //when a category has been deleted, the message below prints
        super.onCategoryDelete(cat);
        cat.getGuild().getDefaultChannel().sendMessage("A catergory has been deleted").queue();
    }

    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent join) {
        String[] messages = {
                "[member] joined. You must construct additional pylons.",
                "Never gonna give [member] up. Never let [member] down!",
                "Hey! Listen! [member] has joined!",
                "Ha! [member] has joined! You activated my trap card!",
                "We've been expecting you, [member].",
                "It's dangerous to go alone, take [member]!",
                "Swoooosh. [member] just landed.",
                "Brace yourselves. [member] just joined the server.",
                "A wild [member] appeared." //a string array that contains messages that will be used to greet a user when they join
        };
        super.onGuildMemberJoin(join);
        Random rand = new Random();
        int number = rand.nextInt(messages.length); //randomly chooses a message to display from the string array when a user joins

        EmbedBuilder bed = new EmbedBuilder();
        bed.setColor(Color.blue);
        bed.setDescription(messages[number].replace("[member]", join.getMember().getAsMention()));

        join.getGuild().getDefaultChannel().sendMessage(bed.build()).queue(); //displays using an embed
    }
}
