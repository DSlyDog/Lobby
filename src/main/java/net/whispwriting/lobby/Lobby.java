package net.whispwriting.lobby;

import net.md_5.bungee.api.plugin.Plugin;
import net.whispwriting.lobby.commands.LobbyCommand;
import net.whispwriting.lobby.files.ConfigFile;

public final class Lobby extends Plugin {

    public ConfigFile config = new ConfigFile(this);

    @Override
    public void onEnable() {
        config.createConfig();
        getProxy().getPluginManager().registerCommand(this, new LobbyCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
