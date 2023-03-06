package StaffSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Main.Main;

public class Listeners implements Listener {

	private final Main main;
	public Listeners(Main main) {
		this.main = main;
	}
	  
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (main.vanish.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (main.vanish.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (main.vanish.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInteractAtEtntity(PlayerInteractAtEntityEvent e) {
		if (main.vanish.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if (main.vanish.contains(e.getEntity().getName())) {
			e.setCancelled(true);
		}
		Player damager = (Player)e.getDamager();
		if (main.vanish.contains(damager.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
		if (main.vanish.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerPickup(PlayerPickupItemEvent e) {
		if (main.vanish.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if (!(main.build.contains(e.getPlayer().getName()))) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if (!(main.build.contains(e.getPlayer().getName()))) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if (main.build.contains(e.getPlayer().getName())) {
			main.build.remove(e.getPlayer().getName());
		}
		
		if (main.vanish.contains(e.getPlayer().getName())) {
			main.vanish.remove(e.getPlayer().getName());
		}
	}
	
}



