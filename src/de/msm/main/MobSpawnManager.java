package de.msm.main;

import de.msm.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.msm.listener.JoinListener;
import de.msm.cmd.ManagerGUI;
import de.msm.listener.ChatListener;
import de.msm.listener.EntityAIListener;
import de.msm.listener.EntitySpawnListener;

/**
 * The type Mob spawn manager.
 */
public class MobSpawnManager extends JavaPlugin {

	public void onEnable() {
		onListeners();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("========== EntitySpawnManager ==========");
		System.out.println(" ");
		System.out.println("Author: GibMirRechte");
		System.out.println("Version: " + Bukkit.getPluginManager().getPlugin("EntitySpawnManager").getDescription().getVersion());
		System.out.println("Discord: yhBX6KT");
		System.out.println(" ");
		System.out.println("========== EntitySpawnManager ==========");
	}

	/**
	 * On listeners.
	 */
	public void onListeners() {
		getServer().getLogger().info(ColorUtil.color("&6&l EntitySpawnManager &8| &7Loading the plugin listeners.."));
		new EntitySpawnListener(this);
		new ManagerGUI(this);
		new JoinListener(this);
		new ChatListener(this);
		new EntityAIListener(this);
		getCommand("managegui").setExecutor(new ManagerGUI(this));
		getServer().getLogger().info(ColorUtil.color("&6&l EntitySpawnManager &8| &aSuccessfully loaded the plugin listeners!"));
	}

}
