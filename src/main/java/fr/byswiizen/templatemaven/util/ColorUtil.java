package fr.byswiizen.templatemaven.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ColorUtil {


    public static String translate(String message) {
		if (Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.17") || Bukkit.getVersion().contains("1.18") || Bukkit.getVersion().contains("1.19") || Bukkit.getVersion().contains("1.20") || Bukkit.getVersion().contains("1.21")) {
			Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
			Matcher matcher = pattern.matcher(message);
			while (matcher.find()) {
				String color = message.substring(matcher.start(), matcher.end());
				message = message.replace(color, net.md_5.bungee.api.ChatColor.valueOf(color) + "");
				matcher = pattern.matcher(message);
			}
		}
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}