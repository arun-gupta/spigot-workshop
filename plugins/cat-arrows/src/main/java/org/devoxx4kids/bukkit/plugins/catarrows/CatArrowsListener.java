package org.devoxx4kids.bukkit.plugins.catarrows;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Aditya Gupta
 */
class CatArrowsListener implements Listener {

    @EventHandler
    public void makeCatArrows(EntityShootBowEvent event) {
        Entity entity = event.getEntity();
        
        if (!(entity instanceof Player)) {
            return;
        }
        
        event.setCancelled(true);
        Player player = (Player) entity;
        ItemStack bow = player.getItemInHand();
        bow.setDurability((short) (bow.getDurability() - 1));
        Snowball snowball = player.throwSnowball();
        Ocelot cat = player.getWorld().spawn(player.getEyeLocation(), Ocelot.class);
        cat.setVelocity(snowball.getVelocity());
        snowball.remove();

        if (bow.getEnchantments().containsKey(Enchantment.ARROW_DAMAGE)) {
            cat.setVelocity(cat.getVelocity().multiply(bow.getEnchantmentLevel(Enchantment.ARROW_DAMAGE) + 1));
        }

        if (bow.getEnchantments().containsKey(Enchantment.ARROW_FIRE)) {
            cat.setFireTicks(bow.getEnchantmentLevel(Enchantment.ARROW_FIRE) * 100);
        }
    }
}
