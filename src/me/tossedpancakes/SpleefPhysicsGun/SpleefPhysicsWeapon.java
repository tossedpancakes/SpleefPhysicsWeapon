package me.tossedpancakes.SpleefPhysicsGun;



import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SpleefPhysicsWeapon extends JavaPlugin{

	@Override
	public void onEnable()
	{
	
	}
	
	
	@Override
	public void onDisable()
	{
		
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] arguments)
	{
		Player pl = (Player)sender;
		
		pl.sendMessage(pl.getDisplayName());
		
		if (commandLabel.equals("givecookie"))
		{
			ItemStack item = new ItemStack(Material.COOKIE);
			pl.getInventory().setItemInMainHand(item);
		}
		
		
		
		
		
		
		
		
		
		return true;
	}
	
	
	
	
	
	
	
}