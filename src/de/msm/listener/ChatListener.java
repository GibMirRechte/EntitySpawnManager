package de.msm.listener;

import de.msm.main.MobSpawnManager;
import de.msm.utils.ColorUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * The type Chat listener.
 */
public class ChatListener implements Listener {

	/**
	 * Instantiates a new Chat listener.
	 *
	 * @param plugin the plugin
	 */
	public ChatListener(final MobSpawnManager plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	/**
	 * On chat.
	 *
	 * @param e the e
	 */
	@EventHandler
	public void onChat(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().toLowerCase().startsWith("/entityspawnmanager")) {
			e.setCancelled(true);
			if(e.getPlayer().hasPermission("esm.perm.gui")) {
				if(e.getMessage().toLowerCase().contains("managegui")) {
					return;
				}
				
				e.getPlayer().sendMessage(ColorUtil.color("&8&m--------&c&o EntitySpawnManager &8&m--------"));
				e.getPlayer().sendMessage(ColorUtil.color(" "));
				e.getPlayer().sendMessage(ColorUtil.color("&7Developer: &eGibMirRechte"));
				e.getPlayer().sendMessage(ColorUtil.color("&7Discord: &bhttps://discord.gg/yhBX6KT"));
				e.getPlayer().sendMessage(ColorUtil.color("&7Download: &chttps://www.spigotmc.org/resources/1-16-x-entityspawnmanager-by-gibmirrechte.87524/"));
				e.getPlayer().sendMessage(ColorUtil.color(" "));
				e.getPlayer().sendMessage(ColorUtil.color("&8&m--------&c&o EntitySpawnManager &8&m--------"));
			}else {
				e.getPlayer().sendMessage(ColorUtil.color("&8&m--------&c&o EntitySpawnManager &8&m--------"));
				e.getPlayer().sendMessage(ColorUtil.color(" "));
				e.getPlayer().sendMessage(ColorUtil.color("&7Developer: &eGibMirRechte"));
				e.getPlayer().sendMessage(ColorUtil.color("&7Discord: &bhttps://discord.gg/yhBX6KT"));
				e.getPlayer().sendMessage(ColorUtil.color("&7Download: &chttps://www.spigotmc.org/resources/1-16-x-entityspawnmanager-by-gibmirrechte.87524/"));
				e.getPlayer().sendMessage(ColorUtil.color(" "));
				e.getPlayer().sendMessage(ColorUtil.color("&8&m--------&c&o EntitySpawnManager &8&m--------"));
			}
		}
	}

}
