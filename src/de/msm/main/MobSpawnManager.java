package de.msm.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.msm.listener.JoinListener;
import de.msm.cmd.ManagerGUI;
import de.msm.listener.ChatListener;
import de.msm.listener.EntityAIListener;
import de.msm.listener.EntitySpawnListener;

public class MobSpawnManager extends JavaPlugin {

	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(), this);
		Bukkit.getPluginManager().registerEvents(new ManagerGUI(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityAIListener(), this);
		
		getCommand("managegui").setExecutor(new ManagerGUI());

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

}