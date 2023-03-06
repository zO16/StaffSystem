package StaffSystem.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;

public class FlyCMDs implements CommandExecutor {

	private final Main main;
	public FlyCMDs(Main main) {
		this.main = main;
	}
	

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String prefix = main.getConfig().getString("prefix").replaceAll("&", "§");
		 
	if (label.equalsIgnoreCase("fly")) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("staff.invsee")) {
				p.sendMessage(main.getConfig().getString("noperm").replace("%prefix%", main.getConfig().getString("prefix")).replaceAll("&", "§"));
			
		}else {
			if (args.length == 1) {
				if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
					if (!(main.flight.contains(main.getServer().getPlayer(args[0]).getName()))) {
						if (!(main.getServer().getPlayer(args[0]).getGameMode() == GameMode.CREATIVE)){
							main.flight.add(main.getServer().getPlayer(args[0]).getName());
							main.getServer().getPlayer(args[0]).setAllowFlight(true);
							main.getServer().getPlayer(args[0]).sendMessage("%prefix% §aYour fly mode has been enabled by §b".replace("%prefix%", prefix)+sender.getName());
							sender.sendMessage("%prefix% §aYou have enabled fly mode for §b".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName());
								
						}
					}else {
						if (main.flight.contains(main.getServer().getPlayer(args[0]).getName())) {
							if (!(main.getServer().getPlayer(args[0]).getGameMode() == GameMode.CREATIVE)) {
								main.flight.remove(main.getServer().getPlayer(args[0]).getName());
								main.getServer().getPlayer(args[0]).setAllowFlight(false);
								main.getServer().getPlayer(args[0]).sendMessage("%prefix% §cYour fly mode has been disabled by §b".replace("%prefix%", prefix)+sender.getName());
								sender.sendMessage("%prefix% §cYou have disabled fly mode for §b".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName());
									
							}
						}
					}
				}else {
					sender.sendMessage("§4Error: §cPlayer not found.");
				}
				
			}else {
				if (args.length == 0) {
					if (!(main.flight.contains(p.getName()))) {
						if (!(p.getGameMode() == GameMode.CREATIVE)){
							main.flight.add(p.getName());
							p.setAllowFlight(true);
							p.sendMessage("%prefix% §aYour fly mode has been enabled!".replace("%prefix%", prefix));
								
						}
					}else {
						if (main.flight.contains(p.getName())) {
							if (!(p.getGameMode() == GameMode.CREATIVE)){
								main.flight.remove(p.getName());
								p.setAllowFlight(false);
								p.sendMessage("%prefix% §cYour fly mode has been disabled!".replace("%prefix%", prefix));
									
							}
						}
					}
				}else {
					sender.sendMessage("§4Error: §cInvaild command usage.");
				}
			}
		}
		}else {
			sender.sendMessage("§4Error: §cOnly players can execute this command.");
		}
	}
	return true;
	}
}
