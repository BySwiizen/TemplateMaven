package fr.byswiizen.templatemaven.command.subcommands;

import fr.byswiizen.templatemaven.TemplateMaven;
import fr.byswiizen.templatemaven.util.ColorUtil;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.bukkit.BukkitCommandActor;


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
            sender.reply(ColorUtil.translate(TemplateMaven.messagesfile.getString("command.prefix") + " " + ColorUtil.translate(TemplateMaven.messagesfile.getString("command.reload-success"))));
        } catch (Exception error) {
            sender.reply(ColorUtil.translate("&4Error loading files."));
            error.printStackTrace();
        }
    }
} 