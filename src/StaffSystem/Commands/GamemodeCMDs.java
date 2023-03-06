package StaffSystem.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import Main.Main;

public class GamemodeCMDs implements CommandExecutor {

	private final Main main;
	public GamemodeCMDs(Main main) {
		this.main = main;
	}
	

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 String prefix = main.getConfig().getString("prefix").replaceAll("&", "§");
		 
		if (label.equalsIgnoreCase("gmc")) {
			if (!(sender instanceof ConsoleCommandSender)) {
				Player p = (Player) sender;
				if (!p.hasPermission("staff.gamemode")) {
					p.sendMessage(main.getConfig().getString("noperm").replace("%prefix%", main.getConfig().getString("prefix")).replaceAll("&", "§"));

			}else {
				if (args.length == 1) {
					if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
						main.getServer().getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
						main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bSet your gamemode to §aCreative §bby §2".replace("%prefix%", prefix)+sender.getName());
						sender.sendMessage("%prefix% §bSet ".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s gamemode to §aCreative");
			
					}else {
						p.sendMessage("§4Error: §cPlayer not found.");
					}
					
				}else {
					if (args.length == 0) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("%prefix% §bSet your gamemode to §aCreative".replace("%prefix%", prefix));
						
					}else {
						p.sendMessage("§4Error: §cInvaild command usage.");
					}
				}
					
			}
			
		}else {
			if (args.length == 1) {
				if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
					main.getServer().getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
					main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bSet your gamemode to §aCreative §bby §2".replace("%prefix%", prefix)+sender.getName());
					sender.sendMessage("%prefix% §bSet ".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s gamemode to §aCreative");
		
				}else {
					sender.sendMessage("§4Error: §cPlayer not found.");
				}
			}else {
				sender.sendMessage("§4Error: §cInvalid command usage.");
				sender.sendMessage("§4Error: §cUsage: /gmc <username>");
			}
		}
			
		}
		
		
		if (label.equalsIgnoreCase("gms")) {
			if (!(sender instanceof ConsoleCommandSender)) {
				Player p = (Player) sender;
				if (!p.hasPermission("staff.gamemode")) {
					p.sendMessage(main.getConfig().getString("noperm").replace("%prefix%", main.getConfig().getString("prefix")).replaceAll("&", "§"));

			}else {
				if (args.length == 1) {
					if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
						main.getServer().getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
						main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bSet your gamemode to §aSurvival §bby §2".replace("%prefix%", prefix)+sender.getName());
						sender.sendMessage("%prefix% §bSet ".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s gamemode to §aSurvival");
			
					}else {
						p.sendMessage("§4Error: §cPlayer not found.");
					}
					
				}else {
					if (args.length == 0) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("%prefix% §bSet your gamemode to §aSurvival".replace("%prefix%", prefix));
						
					}else {
						p.sendMessage("§4Error: §cInvaild command usage.");
					}
				}
					
			}
			
		}else {
			if (args.length == 1) {
				if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
					main.getServer().getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
					main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bSet your gamemode to §aSurvival §bby §2".replace("%prefix%", prefix)+sender.getName());
					sender.sendMessage("%prefix% §bSet ".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s gamemode to §aSurvival");
		
				}else {
					sender.sendMessage("§4Error: §cPlayer not found.");
				}
			}else {
				sender.sendMessage("§4Error: §cInvalid command usage.");
				sender.sendMessage("§4Error: §cUsage: /gms <username>");
			}
		}
			
		}
		
		return true;
	}
}
