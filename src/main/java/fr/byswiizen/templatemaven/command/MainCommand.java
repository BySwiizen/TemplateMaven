package fr.byswiizen.templatemaven.command;

import fr.byswiizen.templatemaven.TemplateMaven;
import fr.byswiizen.templatemaven.command.subcommands.HelpSubCommand;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.CommandPlaceholder;


@Command("templatemaven")
public class MainCommand {

    public TemplateMaven plugin;
    public HelpSubCommand helpcommand;
    public MainCommand(TemplateMaven instance) {
        this.plugin = instance;
        this.helpcommand = new HelpSubCommand(instance);
    }


    @CommandPlaceholder
    public void help(CommandSender sender) {
        helpcommand.help(sender);
    }
}