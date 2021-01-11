package de.msm.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ChatListener implements Listener {
	
	@EventHandler
	public void onChat(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().toLowerCase().startsWith("/entityspawnmanager")) {
			e.setCancelled(true);
			if(e.getPlayer().hasPermission("esm.perm.gui")) {
				if(e.getMessage().toLowerCase().contains("managegui")) {
					return;
				}
				
				e.getPlayer().sendMessage("§8§m--------§c§o EntitySpawnManager §8§m--------");
				e.getPlayer().sendMessage(" ");
				e.getPlayer().sendMessage("§7Developer: §eGibMirRechte");
				e.getPlayer().sendMessage("§7Discord: §bhttps://discord.gg/yhBX6KT");
				e.getPlayer().sendMessage("§7Download: §chttps://www.spigotmc.org/resources/1-16-x-entityspawnmanager-by-gibmirrechte.87524/");
				e.getPlayer().sendMessage(" ");
				e.getPlayer().sendMessage("§8§m--------§c§o EntitySpawnManager §8§m--------");
			}else {
				e.getPlayer().sendMessage("§8§m--------§c§o EntitySpawnManager §8§m--------");
				e.getPlayer().sendMessage(" ");
				e.getPlayer().sendMessage("§7Developer: §eGibMirRechte");
				e.getPlayer().sendMessage("§7Discord: §bhttps://discord.gg/yhBX6KT");
				e.getPlayer().sendMessage("§7Download: §chttps://www.spigotmc.org/resources/1-16-x-entityspawnmanager-by-gibmirrechte.87524/");
				e.getPlayer().sendMessage(" ");
				e.getPlayer().sendMessage("§8§m--------§c§o EntitySpawnManager §8§m--------");
			}
		}
	}

}
