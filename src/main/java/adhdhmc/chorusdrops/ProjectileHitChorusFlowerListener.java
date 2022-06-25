package adhdhmc.chorusdrops;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class ProjectileHitChorusFlowerListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void entityHitFlower(ProjectileHitEvent event){
        if( event.getHitBlock() == null){
            return;
        }
        Block chorusFlower = event.getHitBlock();
        if (event.getHitBlock().getType().equals(Material.CHORUS_FLOWER)){
        event.setCancelled(true);
        chorusFlower.breakNaturally();
        chorusFlower.getWorld().dropItem(chorusFlower.getLocation(), new ItemStack(Material.CHORUS_FLOWER));
        }
    }
}
