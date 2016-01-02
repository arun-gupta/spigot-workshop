package org.devoxx4kids.bukkit.plugins.fireextinguisher;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

/**
 * @author Aditya Gupta
 */
class FireExtinguisherListener implements Listener {

    @EventHandler
    public void spawnWater(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Player player = event.getPlayer();

        if (event.getMaterial() != Material.IRON_BARDING) { // IRON_BARDING is Iron Horse Armor
            return;
        }

        Random random = new Random();
        
        for (int snow = 0 ; snow < 25 ; snow++) {
            Vector vector = new Vector(0.5 - random.nextDouble(), 0.5 - random.nextDouble(), 0.5 - random.nextDouble());
            Snowball snowball = player.getWorld().spawn(player.getEyeLocation(), Snowball.class);
            snowball.setVelocity(player.getLocation().getDirection().multiply(3).add(vector));
            snowball.setShooter(player);
        }
    }

    @EventHandler
    public void extinguishFire(ProjectileHitEvent event) {
        Entity snowball = event.getEntity();
        Block fire = snowball.getWorld().getBlockAt(snowball.getLocation());

        if (!(snowball instanceof Snowball) || fire.getType() != Material.FIRE) {
            return;
        }

        fire.setType(Material.AIR);
    }

}
