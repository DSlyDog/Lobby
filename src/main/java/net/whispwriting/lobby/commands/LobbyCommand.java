package net.whispwriting.lobby.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.whispwriting.lobby.Lobby;

public class LobbyCommand extends Command {

    private Lobby plugin;

    public LobbyCommand(Lobby pl) {
        super("lobby", "", "hub", "l");
        plugin = pl;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            plugin.config.reload();
            String lobbyServer = plugin.config.get().getString("lobby server");
            ServerInfo lobby = plugin.getProxy().getServerInfo(lobbyServer);
            if (!player.getServer().getInfo().equals(lobby)){
                player.sendMessage(new TextComponent(ChatColor.GREEN + "Teleporting to lobby..."));
                player.connect(lobby);
            }else{
                player.sendMessage(new TextComponent(ChatColor.RED + "You are already in the lobby."));
            }
        }
    }
}
