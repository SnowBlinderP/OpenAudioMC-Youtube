package de.snowdns.openaudiomc.yt;

import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.generic.objects.OpenAudioApi;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class PluginLoader extends JavaPlugin {
    @Override
    public void onEnable() {
        OpenAudioApi api = OpenAudioMc.getApi();
        this.getLogger().log(Level.INFO,"Enabling YT Support for OpenAudioMC");
        this.getLogger().log(Level.INFO,"Registering URL Mutations");
        URLValidator mutation = new URLValidator(this);
        api.registerMutation("https://youtu.be", mutation);
        api.registerMutation("http://youtu.be", mutation);
        api.registerMutation("https://youtube.com", mutation);
        api.registerMutation("http://youtube.com", mutation);
        api.registerMutation("https://www.youtu.be", mutation);
        api.registerMutation("http://www.youtu.be", mutation);
        api.registerMutation("https://www.youtube.com", mutation);
        api.registerMutation("http://www.youtube.com", mutation);
        this.getLogger().log(Level.INFO,"Done Registering URL Mutations");
        this.getLogger().log(Level.INFO,"SnowDNS OpenAudioMC Addon Ready for Rumble!!!");
    }
}
