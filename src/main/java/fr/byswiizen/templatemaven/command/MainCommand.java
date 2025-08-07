package fr.byswiizen.templatemaven.command;

import fr.byswiizen.templatemaven.TemplateMaven;
import fr.byswiizen.templatemaven.command.subcommands.HelpSubCommand;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.bukkit.BukkitCommandActor;


@Command("templatemaven")
public class MainCommand {

    public TemplateMaven plugin;
    public HelpSubCommand helpcommand;
    public MainCommand(TemplateMaven instance) {
        this.plugin = instance;
        this.helpcommand = new HelpSubCommand(instance);
    }


    @DefaultFor("templatemaven")
    public void help(BukkitCommandActor sender) {
        helpcommand.help(sender);
    }
}