package fr.byswiizen.templatemaven.listener;

import fr.byswiizen.templatemaven.TemplateMaven;
import fr.byswiizen.templatemaven.util.ColorUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

	public TemplateMaven plugin;
	public JoinListener(TemplateMaven instance) {
		this.plugin = instance;
	}


	@EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (TemplateMaven.configfile.getBoolean("join.enabled")) {
			event.setJoinMessage(ColorUtil.translate(TemplateMaven.messagesfile.getString("join")));
        }
    }
}