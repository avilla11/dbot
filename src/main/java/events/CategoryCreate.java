package events;

import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CategoryCreate extends ListenerAdapter {
    public void onCategoryCreate(CategoryCreateEvent e){
        e.getGuild().getDefaultChannel().sendMessage("someone just created a new category").queue(); //prints the message when a category is created

    }
}
