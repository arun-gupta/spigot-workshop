package org.devoxx4kids.spigot.plugins.craftingexperience;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

class CraftingExperienceListener implements Listener {

    @EventHandler
    public void giveExperience(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        World world = player.getWorld();
        world.spawn(player.getLocation(), ThrownExpBottle.class);
    }

}
