package fr.byswiizen.templatemaven;

import com.tcoded.folialib.FoliaLib;
import dev.dejvokep.boostedyaml.YamlDocument;
import fr.byswiizen.templatemaven.listener.JoinListener;
import fr.byswiizen.templatemaven.subcommands.HelpSubCommand;
import fr.byswiizen.templatemaven.subcommands.ReloadSubCommand;
import fr.byswiizen.templatemaven.util.VersionCheckerUtil;
import fr.byswiizen.templatemaven.versionsystem.ServerVersion;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitCommandHandler;
import java.io.File;
import java.io.IOException;


public class TemplateMaven extends JavaPlugin {

	public static YamlDocument configfile, messagesfile;
	private static ServerVersion serverversion;
	private static VersionCheckerUtil versioncheckerutil;
	private boolean ispluginenabled = true;


	@Override
	public void onLoad() {
		registerFolia();
		registerFiles();
		setVersion();
		versioncheckerutil = new VersionCheckerUtil();
		versioncheckerutil.setVersion();
        if (versioncheckerutil.getVersion() < 13 || versioncheckerutil.getVersion() > 21 || !versioncheckerutil.isVersionCheckedSuccessfully() && !serverversion.serverVersionEqual(ServerVersion.Other)) {
			getLogger().severe("---------------------------------------------------------------------");
			getLogger().severe("Your server version is: " + Bukkit.getVersion());
			getLogger().severe(this.getName() + " only supported on the Minecraft versions listed below:");
			getLogger().severe("1.13.x");
			getLogger().severe("1.14.x");
			getLogger().severe("1.15.x");
			getLogger().severe("1.16.x");
			getLogger().severe("1.17.x");
			getLogger().severe("1.18.x");
			getLogger().severe("1.19.x");
			getLogger().severe("1.20.x");
			getLogger().severe("1.20.x");
			getLogger().severe("1.21.x");
			getLogger().severe("---------------------------------------------------------------------");
			setPluginEnabled(false);
		}
	}

	@Override
	public void onEnable() {
		registerMetrics();
		registerListener();
		registerSubCommands();
		if (!isPluginEnabled()) {
			getLogger().severe("-----------------------------------------------");
			getLogger().severe(this.getName() + " has been disabled during onLoad.");
			getLogger().severe("See above for details.");
			getLogger().severe("-----------------------------------------------");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		} else {
			getLogger().info("-----------------------");
			getLogger().info(this.getName() + " v" + this.getDescription().getVersion());
			getLogger().info("The plugin is enabled.");
			getLogger().info("-----------------------");
			setPluginEnabled(true);
		}
	}

	@Override
	public void onDisable() {
		setPluginEnabled(false);
		getLogger().info("------------------------");
		getLogger().info(this.getName() + " v" + this.getDescription().getVersion());
		getLogger().info("The plugin is disabled.");
		getLogger().info("------------------------");
	}

	private void registerFolia() {
		new FoliaLib(this);
	}

	private void registerFiles() {
		configfile = loadFile("config.yml");
		messagesfile = loadFile("messages.yml");
	}

	private YamlDocument loadFile(String fileName) {
		try {
			return YamlDocument.create(new File(getDataFolder(), fileName), getResource(fileName));
		} catch (IOException error) {
			throw new RuntimeException(error);
		}
	}

	private void setVersion() {
		try {
			String packageName = Bukkit.getServer().getClass().getPackage().getName();
			String bukkitVersion = Bukkit.getServer().getBukkitVersion();
			if (bukkitVersion.contains("1.20.5")) {
				serverversion = ServerVersion.v1_20_R5;
			} else if (bukkitVersion.contains("1.20.6")) {
				serverversion = ServerVersion.v1_20_R5;
			} else if (bukkitVersion.contains("1.21")) {
				serverversion = ServerVersion.v1_21_R1;
			} else if (bukkitVersion.contains("1.21.1")) {
				serverversion = ServerVersion.v1_21_R2;
			} else if (bukkitVersion.contains("1.21.2")) {
				serverversion = ServerVersion.v1_21_R3;
			} else if (bukkitVersion.contains("1.21.3")) {
				serverversion = ServerVersion.v1_21_R4;
			} else if (bukkitVersion.contains("1.21.4")) {
				serverversion = ServerVersion.v1_21_R5;
			} else if (bukkitVersion.contains("1.21.5")) {
				serverversion = ServerVersion.v1_21_R6;
			} else {
				serverversion = ServerVersion.valueOf(packageName.replace("org.bukkit.craftbukkit.", ""));
			}
		} catch (Exception e) {
			serverversion = ServerVersion.Other;
			getLogger().warning("Failed to detect server version, defaulting to: " + serverversion);
		}
		getLogger().warning("Set server version: " + serverversion);
	}

	public static ServerVersion getServerVersion() {
		return serverversion;
	}

	public static VersionCheckerUtil getversionCheckerUtil() {
		return versioncheckerutil;
	}

	private void registerMetrics() {
		new Metrics(this, 11111);
	}

	private void registerListener() {
		PluginManager pluginmanager = Bukkit.getServer().getPluginManager();
		pluginmanager.registerEvents(new JoinListener(this), this);
	}

	private void registerSubCommands() {
		BukkitCommandHandler handler = BukkitCommandHandler.create(this);
		handler.enableAdventure();
		handler.register(new HelpSubCommand(this));
		handler.register(new ReloadSubCommand(this));
	}

	public boolean isPluginEnabled() {
		return ispluginenabled;
	}

	public void setPluginEnabled(boolean pluginenabled) {
		ispluginenabled = pluginenabled;
	}
}