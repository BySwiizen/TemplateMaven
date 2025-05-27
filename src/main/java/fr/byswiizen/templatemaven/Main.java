package fr.byswiizen.templatemaven;

import dev.dejvokep.boostedyaml.YamlDocument;
import fr.byswiizen.templatemaven.event.JoinListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;


public class Main extends JavaPlugin {

    private YamlDocument configfile;


    @Override
    public void onEnable() {
        registerMetrics();
        registerEvent();
        registerFile();
        getLogger().info("-----------------------");
        getLogger().info(this.getName() + " v" + this.getDescription().getVersion());
        getLogger().info("The plugin is enabled.");
        getLogger().info("-----------------------");
    }

    @Override
    public void onDisable() {
        getLogger().info("------------------------");
        getLogger().info(this.getName() + " v" + this.getDescription().getVersion());
        getLogger().info("The plugin is disabled.");
        getLogger().info("------------------------");
    }

    private void registerMetrics() {
        Metrics metrics = new Metrics(this, 11111);
    }

    private void registerEvent() {
        PluginManager pluginmanager = Bukkit.getServer().getPluginManager();
        pluginmanager.registerEvents(new JoinListener(this), this);
    }

    private void registerFile() {
        configfile = loadFile("config.yml");
    }

    private YamlDocument loadFile(String fileName) {
        try {
            return YamlDocument.create(new File(getDataFolder(), fileName), getResource(fileName));
        } catch (IOException error) {
            throw new RuntimeException(error);
        }
    }

    public YamlDocument getConfigfile() {
        return configfile;
    }
}