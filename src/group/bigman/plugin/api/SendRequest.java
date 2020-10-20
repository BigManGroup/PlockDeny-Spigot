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

abstract class SendRequest {
    URL url;
    public SendRequest(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    JSONObject sendRequest(){
        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder output = new StringBuilder();

            while ((inputLine = br.readLine()) != null){
                output.append(inputLine);
            }

            return (JSONObject) new JSONParser().parse(output.toString());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
