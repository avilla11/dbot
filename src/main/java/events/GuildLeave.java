package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Random;

public class GuildLeave extends ListenerAdapter {
    @Override
    public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent event) {
        super.onGuildMemberLeave(event);
        String[] messages = {
                "[member] left. I hope you said your goodbyes", //prints when someone has left the discord server
        };
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder bed = new EmbedBuilder();
        bed.setColor(Color.red);
        bed.setDescription(messages[number].replace("[member]", event.getMember().getAsMention())); //mentions the user who has left using an embed

        event.getGuild().getDefaultChannel().sendMessage(bed.build()).queue();
    }
}
