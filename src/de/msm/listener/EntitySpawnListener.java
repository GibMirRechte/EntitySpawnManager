package de.msm.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnListener implements Listener {
	
	File file = new File("plugins//EntitySpawnHandler//EntityList.yml");
	YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onSpawn(EntitySpawnEvent event) {
		if(yaml.contains(event.getEntityType().toString())) {
			if(!yaml.getBoolean(event.getEntityType().toString())) {
				event.setCancelled(true);
			}
			return;
		}
		
		if(event.getEntityType().equals(EntityType.PLAYER) || event.getEntityType().equals(EntityType.DROPPED_ITEM) ||
				event.getEntityType().equals(EntityType.SPECTRAL_ARROW) || event.getEntityType().equals(EntityType.DRAGON_FIREBALL)) {
			return;
		}
		
		yaml.set(event.getEntityType().toString(), true);
		try { yaml.save(file); }catch (IOException e) {
		}
	}

}
