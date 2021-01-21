package de.msm.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Color util.
 */
public class ColorUtil {

    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    /**
     * Color string.
     *
     * @param msg the msg
     * @return the string
     */
    public static String color(String msg) {
        // If server version is 1.16.X use HEX COLORS.
        if (Bukkit.getServer().getVersion().contains("1.16")) {
            Matcher matcher = pattern.matcher(msg);
            while (matcher.find()) {
                String format = msg.substring(matcher.start(), matcher.end());
                msg = msg.replace(format, ChatColor.of(format) + "");
                matcher = pattern.matcher(msg);
            }
        }
        // Shortened version of chat color.
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
