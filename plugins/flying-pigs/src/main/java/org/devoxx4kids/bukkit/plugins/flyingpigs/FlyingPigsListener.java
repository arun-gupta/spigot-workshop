package org.devoxx4kids.bukkit.plugins.flyingpigs;

import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author Aditya Gupta
 */
class FlyingPigsListener implements Listener {

    @EventHandler
    public void makePigsFly(CreatureSpawnEvent event) {
        Entity pig = event.getEntity();

        if (!(pig instanceof Pig)) {
            return;
        }

        if (pig.getVehicle() != null) {
            return;
        }

        Bat bat = pig.getWorld().spawn(pig.getLocation(), Bat.class);
        bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20000000, 1, true, false), true);
        bat.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20000000, 100, true, false), true);
        bat.setPassenger(pig);
    }

    @EventHandler
    public void killBat(EntityDeathEvent event) {
        Entity pig = event.getEntity();
        
        if (!(pig instanceof Pig)) {
            return;
        }
        
        if (!(pig.getVehicle() instanceof Bat)) {
            return;
        }
        
        pig.getVehicle().remove();
    }
}
