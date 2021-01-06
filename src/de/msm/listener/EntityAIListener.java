package de.msm.listener;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.io.File;
import java.io.IOException;

public class EntityAIListener implements Listener {

    File file = new File("plugins//EntitySpawnHandler//EntityAI.yml");
    YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void onAI(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();

        if(yaml.contains(event.getEntityType().toString())) {
            if(!yaml.getBoolean(event.getEntityType().toString())) {
                entity.setAI(false);
            }
            return;
        }

        if(event.getEntityType().equals(EntityType.PLAYER)) {
            return;
        }

        yaml.set(event.getEntityType().toString(), true);
        try { yaml.save(file); }catch (IOException e) {
        }
    }
}
