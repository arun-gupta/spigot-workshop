package org.devoxx4kids.spigot.plugins.oreshrooms;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

/**
 * @author Aditya Gupta
 */
class OreShroomsListener implements Listener {

    @EventHandler
    public void makeOreBlocks(StructureGrowEvent event) {
        Material ore = Material.AIR;
        
        if (event.getSpecies() != TreeType.BROWN_MUSHROOM && event.getSpecies() != TreeType.RED_MUSHROOM) {
            return;
        }

        Random random = new Random();

        for (int block = 0; block < event.getBlocks().size(); block++) {
            switch (random.nextInt(5)) {
                case 0:
                    ore = Material.DIAMOND_BLOCK;
                    break;
                case 1:
                    ore = Material.EMERALD_BLOCK;
                    break;
                case 2:
                    ore = Material.IRON_BLOCK;
                    break;
                case 3:
                    ore = Material.GOLD_BLOCK;
                    break;
                case 4:
                    if (event.getSpecies() == TreeType.BROWN_MUSHROOM) {
                        ore = Material.HUGE_MUSHROOM_1;
                    } else if (event.getSpecies() == TreeType.RED_MUSHROOM) {
                        ore = Material.HUGE_MUSHROOM_2;
                    }
                    break;
            }

            event.getBlocks().get(block).setType(ore);
        }
    }
}
