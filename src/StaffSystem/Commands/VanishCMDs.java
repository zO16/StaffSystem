package StaffSystem.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import Main.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

public class VanishCMDs implements CommandExecutor {

	private final Main main;
	public VanishCMDs(Main main) {
		this.main = main;
	}
	
	 @SuppressWarnings("rawtypes")
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		 String prefix = main.getConfig().getString("prefix").replaceAll("&", "§");
		 if (command.equalsIgnoreCase("v") || command.equalsIgnoreCase("vanish")) {
			 if (sender instanceof Player) {
				 if (!(sender.hasPermission("staff.vanish"))) {
					 sender.sendMessage(main.getConfig().getString("noperm").replace("%prefix%", main.getConfig().getString("prefix")).replaceAll("&", "§"));
					 
			}else {
				if (args.length == 1) {
					if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
						if (!(main.vanish.contains(main.getServer().getPlayer(args[0]).getName()))) {
							main.vanish.add(main.getServer().getPlayer(args[0]).getName());
							PacketPlayOutTitle vanish = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent)IChatBaseComponent.ChatSerializer.a(""), 0, 999999999,0);
							sender.sendMessage("%prefix% §aYou have enabled vanish mode for".replace("%prefix%", prefix)+ " §b"+main.getServer().getPlayer(args[0]).getName());
							main.getServer().getPlayer(args[0]).sendMessage("%prefix% §aYour vanish has been enabled by".replace("%prefix%", prefix)+ " §b"+sender.getName());
							main.getServer().getPlayer(args[0]).setGameMode(GameMode.ADVENTURE);
							main.getServer().getPlayer(args[0]).setAllowFlight(true);
							if (main.getConfig().getBoolean("vanish.teleport-to-spawn", true)) {
								main.getServer().getPlayer(args[0]).teleport(main.getServer().getPlayer(args[0]).getWorld().getSpawnLocation());
							}
							(((CraftPlayer) main.getServer().getPlayer(args[0])).getHandle()).playerConnection.sendPacket((Packet) vanish);
							for (Player online : main.getServer().getOnlinePlayers()) {
								online.hidePlayer(main.getServer().getPlayer(args[0]));
							}
							
						}else {
							main.vanish.remove(main.getServer().getPlayer(args[0]).getName());
							PacketPlayOutTitle visible = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent) IChatBaseComponent.ChatSerializer.a("{\"text\":\"Have Become Visible\"}"), 20, 30,20);
							sender.sendMessage("%prefix% §cYou have disabled vanish mode for".replace("%prefix%", prefix)+ " §b"+main.getServer().getPlayer(args[0]).getName());
							main.getServer().getPlayer(args[0]).sendMessage("%prefix% §cYour vanish has been disabled by".replace("%prefix%", prefix)+ " §b"+sender.getName());
							main.getServer().getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
							main.getServer().getPlayer(args[0]).setAllowFlight(false);
							if (main.getConfig().getBoolean("vanish.teleport-to-spawn", true)) {
								main.getServer().getPlayer(args[0]).teleport(main.getServer().getPlayer(args[0]).getWorld().getSpawnLocation());
							}
							(((CraftPlayer) main.getServer().getPlayer(args[0])).getHandle()).playerConnection.sendPacket((Packet) visible);
							for (Player online : main.getServer().getOnlinePlayers()) {
								online.showPlayer(main.getServer().getPlayer(args[0]));
							}
							
						}
						
					}else {
						sender.sendMessage("§4Error: §cPlayer not found.");
					}
					
				}else {
					if (args.length == 0) {
						Player p = (Player)sender;
						if (!(main.vanish.contains(p.getName()))) {
							main.vanish.add(p.getName());
							PacketPlayOutTitle vanish = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent)IChatBaseComponent.ChatSerializer.a(""), 0, 999999999,0);
							p.sendMessage("%prefix% §aYour vanish mode has been enabled!".replace("%prefix%", prefix));
							p.setGameMode(GameMode.ADVENTURE);
							p.setAllowFlight(true);
							if (main.getConfig().getBoolean("vanish.teleport-to-spawn", true)) {
								p.teleport(p.getWorld().getSpawnLocation());
							}
							
							(((CraftPlayer)(p)).getHandle()).playerConnection.sendPacket((Packet) vanish);
							for (Player online : main.getServer().getOnlinePlayers()) {
								online.hidePlayer(p);
							}
							
						}else {
							if (main.vanish.contains(p.getName())) {
								main.vanish.remove(p.getName());
								PacketPlayOutTitle visible = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent) IChatBaseComponent.ChatSerializer.a("{\"text\":\"Have Become Visible\"}"), 20, 30,20);
								p.sendMessage("%prefix% §CYour vanish mode has been disabled!".replace("%prefix%", prefix));
								p.setGameMode(GameMode.SURVIVAL);
								p.setAllowFlight(false);
								if (main.getConfig().getBoolean("vanish.teleport-to-spawn", true)) {
									p.teleport(p.getWorld().getSpawnLocation());
								}
							
								(((CraftPlayer)(p)).getHandle()).playerConnection.sendPacket((Packet) visible);
								for (Player online : main.getServer().getOnlinePlayers()) {
									online.showPlayer(p);
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
