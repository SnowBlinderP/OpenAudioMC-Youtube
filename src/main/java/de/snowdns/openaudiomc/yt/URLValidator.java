package de.snowdns.openaudiomc.yt;

import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.modules.media.interfaces.UrlMutation;

import static java.util.logging.Level.INFO;

public class URLValidator implements UrlMutation {

    private PluginLoader main;

    public URLValidator(PluginLoader main){
        this.main = main;
    }
    @Override
    public String onRequest(OpenAudioMc openAudioMc, String s) {
        String videoid = s;
        videoid = videoid.replace("https://","").replace("http://","");
        videoid = videoid.replace("www","").replace("youtube.com","").replace("youtu.be","");
        videoid = videoid.replace("/","").replace("?v=","").replace("watch","").replace(".","");
        if (videoid.contains("&")){
            this.main.getLogger().log(INFO,"URL Mutation Contains More than 1 Argument - Cutting -> " + videoid);
            String[] args = videoid.split("&");
            videoid = args[0];
            this.main.getLogger().log(INFO,"Final VID: " + videoid);
        } else {
            this.main.getLogger().log(INFO,"Final VID: " + videoid);
        }
        this.main.getLogger().log(INFO,"Loading the Ressource might take up to a Minute when its loaded for the First Time - Please Wait!!!");
        //Removed ID and IP till I Found a Way to Stable Gather and Analyse my DataSets
        //String ServerURL = "https://oa-yt.snowdns.de/?v=" + videoid + "&serverid=" + openAudioMc.getServer().getServerId() + "&ip=" + openAudioMc.getServer().getIp();
        String ServerURL = "https://oa-yt.snowdns.de/?v=" + videoid;
    return ServerURL;
    }
}
