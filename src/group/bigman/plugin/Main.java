package group.bigman.plugin;

import group.bigman.plugin.api.RandomInsult;
import group.bigman.plugin.api.RandomQuote;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;

public class Main extends JavaPlugin implements Listener {
    RandomQuote randomQuote;
    RandomInsult randomInsult;

    public Main() throws MalformedURLException {
        randomQuote = new RandomQuote();
        randomInsult = new RandomInsult();
    }

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){

    }

    @EventHandler
    public void onAsyncChatEvent(@NotNull AsyncPlayerChatEvent event){
        if(this.randomInsult.hasPWord(event.getMessage())){
            String insult = this.randomInsult.getRandomInsult();
            event.setMessage(insult);
        }
    }

    @EventHandler
    public void onPlayerLoginEvent(@NotNull PlayerJoinEvent event){
        String quote = this.randomQuote.getRandomQuote();
        if(quote != null) event.getPlayer().sendMessage(this.randomQuote.getRandomQuote());
    }
}
