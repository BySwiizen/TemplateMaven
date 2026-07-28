package fr.byswiizen.templatemaven.command.subcommands;

import fr.byswiizen.templatemaven.TemplateMaven;
import fr.byswiizen.templatemaven.util.ColorUtil;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;


@Command("templatemaven")
public class HelpSubCommand {

	public TemplateMaven plugin;
    public HelpSubCommand(TemplateMaven instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(CommandSender sender) {
		for (String line : TemplateMaven.messagesfile.getStringList("command.help")) {
            sender.sendMessage(ColorUtil.translate(TemplateMaven.messagesfile.getString("command.prefix") + " " + line));
        }
	}
} 