package adhdhmc.chorusdrops;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ChorusFlowerDestructionListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void flowersBreak(BlockDestroyEvent event){
        if(event.getBlock().getType() != Material.CHORUS_FLOWER){
            return;
        }
        Location flowerLocation = event.getBlock().getLocation();
        Material blockMaterial = event.getBlock().getType();
        flowerLocation.getWorld().dropItem(flowerLocation, new ItemStack(blockMaterial));
    }
}
