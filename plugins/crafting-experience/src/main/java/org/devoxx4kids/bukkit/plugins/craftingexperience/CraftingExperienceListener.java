package org.devoxx4kids.bukkit.plugins.craftingexperience;

import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

/**
 * @author Aditya Gupta
 */
class CraftingExperienceListener implements Listener {

    @EventHandler
    public void giveExperience(CraftItemEvent event) {
        HumanEntity player = event.getWhoClicked();
        World world = player.getWorld();
        world.spawn(player.getLocation(), ThrownExpBottle.class);
    }

}
