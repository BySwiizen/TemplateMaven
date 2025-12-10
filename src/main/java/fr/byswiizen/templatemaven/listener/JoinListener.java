package fr.byswiizen.templatemaven.listener;

import fr.byswiizen.templatemaven.TemplateMaven;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
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
            String message = TemplateMaven.messagesfile.getString("join");
            String legacy = LegacyComponentSerializer.legacySection().serialize(MiniMessage.miniMessage().deserialize(message));
            event.setJoinMessage(legacy);
        }
    }
}