package de.snowdns.openaudio.yt;

import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.modules.media.interfaces.UrlMutation;

import static java.util.logging.Level.INFO;

public class UrlGayNess implements UrlMutation {

    private MainClassLoader main;

    public UrlGayNess(MainClassLoader main){
        this.main = main;
    }
    @Override
    public String onRequest(OpenAudioMc openAudioMc, String s) {
        String videoid = s;
        videoid = videoid.replace("https://","").replace("http://","");
        videoid = videoid.replace("www","").replace("youtube.com","").replace("youtu.be","");
        videoid = videoid.replace("/","").replace("?v=","");
        if (videoid.contains("&")){
            this.main.getLogger().log(INFO,"URL Mutation Contains More than 1 Argument - Cutting -> " + videoid);
            String[] args = videoid.split("&");
            videoid = args[0];
            this.main.getLogger().log(INFO,"Final VID: " + videoid);
        } else {
            this.main.getLogger().log(INFO,"Final VID: " + videoid);
        }
        String ServerURL = "https://oa-yt.snowdns.de/?v=" + videoid + "&serverid=" + openAudioMc.getServer().getServerId() + "&ip=" + openAudioMc.getServer().getIp();
    return ServerURL;
    }
}
