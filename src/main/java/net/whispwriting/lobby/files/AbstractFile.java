package net.whispwriting.lobby.files;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.whispwriting.lobby.Lobby;

import java.io.File;
import java.io.IOException;

public class AbstractFile {

    protected Lobby plugin;
    private File file;
    protected Configuration config;

    public AbstractFile(Lobby pl, String filename, String dir){
        plugin = pl;
        File path = new File(ProxyServer.getInstance().getPluginsFolder().toString() + dir);
        if (!path.exists()){
            path.mkdir();
        }
        file = new File(path, filename);
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Configuration get(){
        return config;
    }

    public void reload(){
        try{
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void save(){
        try{
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
