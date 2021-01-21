package de.msm.listener;

import de.msm.main.MobSpawnManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.io.File;
import java.io.IOException;

/**
 * The type Entity AI listener.
 */
public class EntityAIListener implements Listener {

    public EntityAIListener(final MobSpawnManager plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /**
     * Initiates config file for entity ai (movement).
     * @param file
     */
    private final File file = new File("plugins//EntitySpawnHandler//EntityAI.yml");
    /**
     * Initiates YAML for entity ai (movement).
     * @param yaml
     */
    private final YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

    /**
     * On Mob AI.
     * Supported versions: Spigot/Paper | 1.9+
     *
     * @param event the event
     */
    @EventHandler
    public void onAI(final CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();

        if (yaml.contains(event.getEntityType().toString())) {
            if (!yaml.getBoolean(event.getEntityType().toString())) {
                entity.setAI(false);
            }
            return;
        }

        if (event.getEntityType().equals(EntityType.PLAYER)) {
            return;
        }

        yaml.set(event.getEntityType().toString(), true);
        try {
            yaml.save(file);
        } catch (IOException e) {
            entity.setAI(true);
        }
    }
}
