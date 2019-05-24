package net.whispwriting.lobby.files;

import net.whispwriting.lobby.Lobby;

public class ConfigFile extends AbstractFile {

    public ConfigFile(Lobby pl){
        super(pl, "config.yml", "/Lobby/");
    }

    public void createConfig(){
        String lobbyServer = config.getString("lobby server");

        if (lobbyServer.equals("")){
            config.set("lobby server", "lobby");
            save();
        }
    }

}
