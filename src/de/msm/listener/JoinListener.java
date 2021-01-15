package de.msm.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

	   private String url = "https://api.spigotmc.org/legacy/update.php?resource=";
	    private String id = "87524";

	    private boolean isAvailable;

	    @EventHandler
	    public void on(PlayerJoinEvent event) {
	    	check();
	        if(event.getPlayer().hasPermission("esm.perm.notification")) {
	            if(isAvailable) {
	            	event.getPlayer().sendMessage(" ");
	                event.getPlayer().sendMessage("§7[§cEntitySpawnManager§7] §aA NEW UPDATE IS AVAILABLE!");
	                event.getPlayer().sendMessage("§7[§cEntitySpawnManager§7] §cDownload: §bhttps://www.spigotmc.org/resources/1-16-x-entityspawnmanager-by-gibmirrechte.87524/");
	            }
	            }
	        }

	    public void check() {
	        isAvailable = checkUpdate();
	    }

	    private boolean checkUpdate() {
	        System.out.println("§7[§cEntitySpawnManager§7] §aChecking for updates...");
	        try {
	            String localVersion = Bukkit.getPluginManager().getPlugin("EntitySpawnManager").getDescription().getVersion();
	            HttpsURLConnection connection = (HttpsURLConnection) new URL(url + id).openConnection();
	            connection.setRequestMethod("GET");
	            String raw = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();

	            String remoteVersion;
	            if(raw.contains("-")) {
	                remoteVersion = raw.split("-")[0].trim();
	            } else {
	                remoteVersion = raw;
	            }

	            if(!localVersion.equalsIgnoreCase(remoteVersion))
	                return true;

	        } catch (IOException e) {
	            return false;
	        }
	        return false;
	    }

}