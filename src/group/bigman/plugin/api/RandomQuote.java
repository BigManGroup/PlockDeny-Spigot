package group.bigman.plugin.api;

import org.bukkit.ChatColor;
import org.json.simple.JSONObject;
import java.net.MalformedURLException;

public class RandomQuote extends SendRequest{

    public RandomQuote() throws MalformedURLException {
        super("https://bigman.group/api/randomquote/");
    }

    public String getRandomQuote(){
        JSONObject response = this.sendRequest();
        if(response == null) return null;
        else return ChatColor.ITALIC + "A wise person that goes by the name of " + response.get("nickname") + " once said: " + ChatColor.BLUE + response.get("text");
    }
}
