package de.msm.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.msm.cmd.ManagerGUI;
import de.msm.listener.EntitySpawnListener;

public class MobSpawnManager extends JavaPlugin {

	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(), this);
		Bukkit.getPluginManager().registerEvents(new ManagerGUI(), this);
		
		getCommand("managegui").setExecutor(new ManagerGUI());

		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("========== MobSpawn Manager ==========");
		System.out.println(" ");
		System.out.println("Author: GibMirRechte");
		System.out.println("Version: 1.0");
		System.out.println("Discord: yhBX6KT");
		System.out.println(" ");
		System.out.println("========== MobSpawn Manager ==========");
	}

}
