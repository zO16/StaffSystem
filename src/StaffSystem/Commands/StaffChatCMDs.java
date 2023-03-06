package StaffSystem.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;

public class StaffChatCMDs implements CommandExecutor {

	private final Main main;
	public StaffChatCMDs(Main main) {
		this.main = main;
	}
	

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 
	if (label.equalsIgnoreCase("sc") || label.equalsIgnoreCase("staffchat")) {
		if (!(sender.hasPermission("staffchat.use"))) {
			sender.sendMessage(main.getConfig().getString("noperm").replace("%prefix%", main.getConfig().getString("prefix")).replaceAll("&", "§"));
			
		}else {
			if (args.length != 0) {
				String message = String.join(" ", (CharSequence[])args);
					for (Player Staff : main.getServer().getOnlinePlayers()) {
						if (Staff.hasPermission("staffchat.show")) {
							Staff.sendMessage(main.getConfig().getString("staffchat.formate").replace("%player%", sender.getName()).replace("%message%", message).replaceAll("&", "§"));
						}
				}

			}else {
				sender.sendMessage("§4Error: §cInvaild command usage.");
			}
		}
	}
	
	return true;
	}
}
