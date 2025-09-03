package fr.byswiizen.templatemaven.command.subcommands;

import fr.byswiizen.templatemaven.TemplateMaven;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.bukkit.BukkitCommandActor;
import net.kyori.adventure.text.minimessage.MiniMessage;


@Command("templatemaven")
public class ReloadSubCommand {

	public TemplateMaven plugin;
    public ReloadSubCommand(TemplateMaven instance) {
        this.plugin = instance;
    }


    @Subcommand("reload")
    @CommandPermission("templatemaven.reload")
    public void reload(BukkitCommandActor sender) {
        try {
            TemplateMaven.configfile.reload();
            TemplateMaven.messagesfile.reload();
            sender.reply(MiniMessage.miniMessage().deserialize(TemplateMaven.messagesfile.getString("command.prefix") + " " + TemplateMaven.messagesfile.getString("command.reload-success")));
        } catch (Exception error) {
            sender.reply(MiniMessage.miniMessage().deserialize("<red>Error loading files."));
            error.printStackTrace();
        }
    }
} 