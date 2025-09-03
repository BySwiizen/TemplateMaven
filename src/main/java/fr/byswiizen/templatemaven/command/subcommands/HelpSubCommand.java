package fr.byswiizen.templatemaven.command.subcommands;

import fr.byswiizen.templatemaven.TemplateMaven;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.BukkitCommandActor;
import net.kyori.adventure.text.minimessage.MiniMessage;


@Command("templatemaven")
public class HelpSubCommand {

	public TemplateMaven plugin;
    public HelpSubCommand(TemplateMaven instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(BukkitCommandActor sender) {
		for (String line : TemplateMaven.messagesfile.getStringList("command.help")) {
            sender.reply(MiniMessage.miniMessage().deserialize(TemplateMaven.messagesfile.getString("command.prefix") + " " + line));
        }
	}
} 