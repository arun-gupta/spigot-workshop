package org.devoxx4kids.bukkit.plugins.fireextinguisher;

import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;

public class FireExtinguisher extends JavaPlugin {

    // This code is called after the server starts and after the /reload command
    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "{0}.onEnable()", this.getClass().getName());
        getServer().getPluginManager().registerEvents(new FireExtinguisherListener(), this);
    }

    // This code is called before the server stops and after the /reload command
    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "{0}.onDisable()", this.getClass().getName());
    }
}
