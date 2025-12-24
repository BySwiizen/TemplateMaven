package fr.byswiizen.templatemaven.command.subcommands;

import fr.byswiizen.templatemaven.TemplateMaven;
import fr.byswiizen.templatemaven.util.ColorUtil;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.BukkitCommandActor;


@Command("templatemaven")
public class HelpSubCommand {

	public TemplateMaven plugin;
    public HelpSubCommand(TemplateMaven instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(BukkitCommandActor sender) {
		for (String line : TemplateMaven.messagesfile.getStringList("command.help")) {
            sender.reply(ColorUtil.translate(TemplateMaven.messagesfile.getString("command.prefix") + " " + line));
        }
	}
} 