package fr.byswiizen.templatemaven.event;

import fr.byswiizen.templatemaven.Main;
import fr.byswiizen.templatemaven.util.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    public Main plugin;

    public JoinListener(Main instance) {
        this.plugin = instance;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(Color.translate(plugin.getConfigfile().getString("message.join")));
    }
}