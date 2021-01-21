package de.msm.listener;

import java.io.File;
import java.io.IOException;

import de.msm.main.MobSpawnManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

/**
 * The type Entity spawn listener.
 */
public class EntitySpawnListener implements Listener {

	/**
	 * Instantiates a new Entity spawn listener.
	 *
	 * @param plugin the plugin
	 */
	public EntitySpawnListener(final MobSpawnManager plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	/**
	 * Initiates config file for entity spawn list.
	 * @param file
	 */
	private final File file = new File("plugins//EntitySpawnHandler//EntityList.yml");
	/**
	 * Initiates YAML for entity spawn config.
	 * @param yaml
	 */
	private final YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

	/**
	 * On Mob Spawn.
	 * Supported versions: Spigot/Paper | 1.8+
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onSpawn(final EntitySpawnEvent event) {
		if (yaml.contains(event.getEntityType().toString())) {
			if (!yaml.getBoolean(event.getEntityType().toString())) {
				event.setCancelled(true);
			}
			return;
		}
		
		if (event.getEntityType().equals(EntityType.PLAYER) || event.getEntityType().equals(EntityType.DROPPED_ITEM) ||
				event.getEntityType().equals(EntityType.SPECTRAL_ARROW) || event.getEntityType().equals(EntityType.DRAGON_FIREBALL)) {
			return;
		}
		
		yaml.set(event.getEntityType().toString(), true);
		try {
			yaml.save(file);
		}catch (IOException e) {
			event.setCancelled(false);
		}
	}

}
