package adhdhmc.chorusdrops;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChorusDrops extends JavaPlugin {
    public static ChorusDrops plugin;
    @Override
    public void onEnable() {
        plugin = this;
        try {
            Class.forName("com.destroystokyo.paper.event.block.BlockDestroyEvent");
        } catch (ClassNotFoundException e) {
            this.getLogger().severe("[ChorusDrops] This plugin depends on classes not present on your server. Disabling plugin");
            getServer().getPluginManager().disablePlugin(ChorusDrops.plugin);
            return;
        }
        getServer().getPluginManager().registerEvents(new ChorusFlowerDestructionListener(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitChorusFlowerListener(), this);
    }
}
