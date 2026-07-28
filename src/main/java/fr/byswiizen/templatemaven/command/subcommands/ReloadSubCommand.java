package fr.byswiizen.templatemaven.command.subcommands;

import fr.byswiizen.templatemaven.TemplateMaven;
import fr.byswiizen.templatemaven.util.ColorUtil;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;


@Command("templatemaven")
public class ReloadSubCommand {

	public TemplateMaven plugin;
    public ReloadSubCommand(TemplateMaven instance) {
        this.plugin = instance;
    }


    @Subcommand("reload")
    @CommandPermission("templatemaven.reload")
    public void reload(CommandSender sender) {
        try {
            TemplateMaven.configfile.reload();
            TemplateMaven.messagesfile.reload();
            sender.sendMessage(ColorUtil.translate(TemplateMaven.messagesfile.getString("command.prefix") + " " + ColorUtil.translate(TemplateMaven.messagesfile.getString("command.reload-success"))));
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
} 