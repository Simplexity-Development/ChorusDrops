package adhdhmc.chorusdrops;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChorusDrops extends JavaPlugin {
    public static ChorusDrops plugin;
    @Override
    public void onEnable() {
        plugin = this;
        try {
            Class.forName("com.destroystokyo.paper.event.block.BlockDestroyEvent");
        } catch (ClassNotFoundException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "This plugin depends on a method that is not present on your server. Sorry for the inconvenience");
            getServer().getPluginManager().disablePlugin(ChorusDrops.plugin);
            return;
        }
        getServer().getPluginManager().registerEvents(new ChorusFlowerDestructionListener(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitChorusFlowerListener(), this);
    }
}
