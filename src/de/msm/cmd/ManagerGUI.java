package de.msm.cmd;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import de.msm.main.MobSpawnManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The type Manager gui.
 */
public class ManagerGUI implements Listener, CommandExecutor {

	/**
	 * Instantiates a new Manager gui.
	 *
	 * @param plugin the plugin
	 */
	public ManagerGUI(final MobSpawnManager plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	/**
	 * The File.
	 */
	File file = new File("plugins//EntitySpawnHandler//EntityList.yml");
	/**
	 * The Yaml.
	 */
	YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

	/**
	 * The File 1.
	 */
	File file1 = new File("plugins//EntitySpawnHandler//EntityAI.yml");
	/**
	 * The Yaml 1.
	 */
	YamlConfiguration yaml1 = YamlConfiguration.loadConfiguration(file1);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§7[§cEntitySpawnManager§7] §cYou must be a player to use this command!");
			return true;
		}
		
		if(!sender.hasPermission("esm.perm.gui")) {
			sender.sendMessage("§7[§cEntitySpawnManager§7] §cYou don't have the permissions to use this command!");
			return true;
		}
		
		if(args.length != 1) {
			sender.sendMessage("§7[§cEntitySpawnManager§7] §cPlease use /managegui <AI/Spawning>");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("ai")) {
			setGui_AI((Player) sender);
		}else if(args[0].equalsIgnoreCase("spawning")) {
			setGui_Spawning((Player) sender);
		}else {
			sender.sendMessage("§7[§cEntitySpawnManager§7] §cPlease use /managegui <AI/Spawning>");
		}
		
		return false;
	}

	/**
	 * On close.
	 *
	 * @param e the e
	 */
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		if(e.getPlayer().getOpenInventory().getTitle().startsWith("§cEntitySpawnManager - GUI")) {
			e.getPlayer().sendMessage("§7[§cEntitySpawnManager§7] §4To update the config you must reload or restart the server!");
		}
	}

	/**
	 * On click.
	 *
	 * @param e the e
	 */
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase("§cEntitySpawnManager - GUI (Spawning)")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getType().equals(Material.LIME_WOOL)) {
					ItemStack item = new ItemStack(Material.RED_WOOL);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(e.getCurrentItem().getItemMeta().getDisplayName());
					itemmeta.setLore(Arrays.asList("§7Status: §cDISABLED"));
					item.setItemMeta(itemmeta);
					e.setCurrentItem(item);
					yaml.set(e.getCurrentItem().getItemMeta().getDisplayName(), false);
					try { yaml.save(file); } catch(IOException e1) {
				}
			}else if(e.getCurrentItem().getType().equals(Material.RED_WOOL)) {
					ItemStack item = new ItemStack(Material.LIME_WOOL);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(e.getCurrentItem().getItemMeta().getDisplayName());
					itemmeta.setLore(Arrays.asList("§7Status: §aENABLED"));
					item.setItemMeta(itemmeta);
					e.setCurrentItem(item);
					yaml.set(e.getCurrentItem().getItemMeta().getDisplayName(), true);
					try { yaml.save(file); } catch(IOException e1) {
			}
		}
	}else if(e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase("§cEntitySpawnManager - GUI (AI)")) {
		e.setCancelled(true);
		if(e.getCurrentItem().getType().equals(Material.LIME_WOOL)) {
				ItemStack item = new ItemStack(Material.RED_WOOL);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(e.getCurrentItem().getItemMeta().getDisplayName());
				itemmeta.setLore(Arrays.asList("§7AI: §cDISABLED"));
				item.setItemMeta(itemmeta);
				e.setCurrentItem(item);
				yaml1.set(e.getCurrentItem().getItemMeta().getDisplayName(), false);
				try { yaml1.save(file1); } catch(IOException e1) {
			}
		}else if(e.getCurrentItem().getType().equals(Material.RED_WOOL)) {
				ItemStack item = new ItemStack(Material.LIME_WOOL);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(e.getCurrentItem().getItemMeta().getDisplayName());
				itemmeta.setLore(Arrays.asList("§7AI: §aENABLED"));
				item.setItemMeta(itemmeta);
				e.setCurrentItem(item);
				yaml1.set(e.getCurrentItem().getItemMeta().getDisplayName(), true);
				try { yaml1.save(file1); } catch(IOException e1) {
		}
	}
}
}

	/**
	 * Sets gui ai.
	 *
	 * @param p the p
	 */
	public void setGui_AI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9*6, "§cEntitySpawnManager - GUI (AI)");
		
		int slot = -1;
		for(String entry : yaml1.getKeys(false)) {
			slot++;
			
			if(yaml1.getBoolean(entry)) {
				ItemStack item = new ItemStack(Material.LIME_WOOL);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(entry);
				itemmeta.setLore(Arrays.asList("§7AI: §aENABLED"));
				item.setItemMeta(itemmeta);
				item.setAmount(1);
				inv.setItem(slot, item);
			}else {
				ItemStack item = new ItemStack(Material.RED_WOOL);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(entry);
				itemmeta.setLore(Arrays.asList("§7AI: §cDISABLED"));
				item.setItemMeta(itemmeta);
				item.setAmount(1);
				inv.setItem(slot, item);
			}
		}
		p.openInventory(inv);
	}

	/**
	 * Sets gui spawning.
	 *
	 * @param p the p
	 */
	public void setGui_Spawning(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9*6, "§cEntitySpawnManager - GUI (Spawning)");
		
		int slot = -1;
		for(String entry : yaml.getKeys(false)) {
			slot++;
			
			if(yaml.getBoolean(entry)) {
				ItemStack item = new ItemStack(Material.LIME_WOOL);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(entry);
				itemmeta.setLore(Arrays.asList("§7Status: §aENABLED"));
				item.setItemMeta(itemmeta);
				item.setAmount(1);
				inv.setItem(slot, item);
			}else {
				ItemStack item = new ItemStack(Material.RED_WOOL);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(entry);
				itemmeta.setLore(Arrays.asList("§7Status: §cDISABLED"));
				item.setItemMeta(itemmeta);
				item.setAmount(1);
				inv.setItem(slot, item);
			}
		}
		p.openInventory(inv);
	}

}
