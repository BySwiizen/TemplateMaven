package fr.byswiizen.templatemaven.util;

import fr.byswiizen.templatemaven.TemplateMaven;
import org.bukkit.Bukkit;
import java.util.regex.PatternSyntaxException;


public class VersionCheckerUtil {

    private String serverPackage;
    private int version;
    private boolean versionCheckedSuccessfully = false;


    public VersionCheckerUtil() {
        try {
            serverPackage = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        } catch (ArrayIndexOutOfBoundsException error) {
            serverPackage = null;
        }
    }

    public void setVersion() {
        try {
            version = TemplateMaven.getServerVersion().getServerMajorVersionNumber();
            versionCheckedSuccessfully = true;
        } catch (NumberFormatException | PatternSyntaxException error) {
            versionCheckedSuccessfully = false;
			Bukkit.getLogger().warning("--------------------------------------");
            Bukkit.getLogger().warning("Unable to process server version.");
            Bukkit.getLogger().warning("Some features may break unexpectedly.");
            Bukkit.getLogger().warning("Report any issues to the developer.");
            Bukkit.getLogger().warning("--------------------------------------");
        }
    }

    public String getServerPackage() {
        return serverPackage != null ? serverPackage : "Unknown";
    }

    public int getVersion() {
        return version;
    }

    public boolean isVersionCheckedSuccessfully() {
        return versionCheckedSuccessfully;
    }
}