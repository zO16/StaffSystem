package Main;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import StaffSystem.Listeners;
import StaffSystem.Commands.BuildCMDs;
import StaffSystem.Commands.FlyCMDs;
import StaffSystem.Commands.GamemodeCMDs;
import StaffSystem.Commands.InvseeCMDs;
import StaffSystem.Commands.StaffChatCMDs;
import StaffSystem.Commands.VanishCMDs;

public class Main extends JavaPlugin {

	public ArrayList<String> flight = new ArrayList<>();
	public ArrayList<String> build = new ArrayList<>();
	public ArrayList<String> vanish = new ArrayList<>();
	
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§8§l┃ §4§lStaff §8§l┃§a plugin has been enabled!");
		getServer().getConsoleSender().sendMessage("§8§l┃ §4§lStaff §8§l┃§a by [VenixCoding - Devo] https://discord.gg/CnKJNpAab9");
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getCommand("gmc").setExecutor(new GamemodeCMDs(this));
		getCommand("gms").setExecutor(new GamemodeCMDs(this));
		getCommand("invsee").setExecutor(new InvseeCMDs(this));
		getCommand("vanish").setExecutor(new VanishCMDs(this));
		getCommand("v").setExecutor(new VanishCMDs(this));
		getCommand("build").setExecutor(new BuildCMDs(this));
		getCommand("fly").setExecutor(new FlyCMDs(this));
		getCommand("sc").setExecutor(new StaffChatCMDs(this));
		getCommand("staffchat").setExecutor(new StaffChatCMDs(this));
		
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§8§l┃ §4§lStaff §8§l┃§c plugin has been disabled!");
		getServer().getConsoleSender().sendMessage("§8§l┃ §4§lStaff §8§l┃§c by [VenixCoding - Devo] https://discord.gg/CnKJNpAab9");
		
	}
	
}
