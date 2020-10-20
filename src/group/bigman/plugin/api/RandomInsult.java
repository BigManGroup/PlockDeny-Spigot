package group.bigman.plugin.api;

import org.bukkit.ChatColor;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class RandomInsult extends SendRequest {

    final String[] pWords;

    public RandomInsult() throws MalformedURLException {
        super("https://bigman.group/api/randominsult/");
        this.pWords = new String[]{"please", "plz", "pleaze", "plox", "plx", "plis", "pliz", "pls"};
    }

    public String getRandomInsult(){
        JSONObject response = this.sendRequest();
        System.out.println(response);
        if(response == null) return ChatColor.RED + "I used the p-word because I am faggot.  This is not allowed in the BigMan Realms";
        else return ChatColor.RED + "I used the p-word because I am " + response.get("insult") + ".  This is not allowed in the BigMan Realms";
    }

    public boolean hasPWord(String message){
        for (int i = 0; i != pWords.length ; i++) if(message.contains(pWords[i])) return true;
        return false;
    }
}
