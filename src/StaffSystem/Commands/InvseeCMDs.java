package StaffSystem.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import Main.Main;

public class InvseeCMDs implements CommandExecutor {

	private final Main main;
	public InvseeCMDs(Main main) {
		this.main = main;
	}
	

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
	if (label.equalsIgnoreCase("invsee")) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("staff.invsee")) {
				p.sendMessage(main.getConfig().getString("noperm").replace("%prefix%", main.getConfig().getString("prefix")).replaceAll("&", "§"));
			
		}else {
			if (args.length == 1) {
				if (!(args[0].equals(p.getName()))) {
					if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
						p.openInventory((Inventory) main.getServer().getPlayer(args[0]).getInventory());
						
			}else {
				p.sendMessage("§4Error: §cPlayer not found.");
			}

			}else {
				p.sendMessage("§4Error: §cYou can't use this command on Yourself.");
			}
				
			}else {
				p.sendMessage("§4Error: §cInvaild command usage.");
			}
	}
			}else {
				sender.sendMessage("§4Error: §cOnly players can execute this command.");
			}
		
	return true;
	}
	return true;
	}
}
