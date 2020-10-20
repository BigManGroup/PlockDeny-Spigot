package group.bigman.plugin.api;

import org.bukkit.ChatColor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

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
