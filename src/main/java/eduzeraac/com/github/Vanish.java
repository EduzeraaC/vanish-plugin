package eduzeraac.com.github;

import co.aikar.commands.BukkitCommandManager;
import eduzeraac.com.github.commands.OffCommand;
import eduzeraac.com.github.commands.OnCommand;
import eduzeraac.com.github.commands.VanishCommand;
import eduzeraac.com.github.listeners.VanishListeners;
import eduzeraac.com.github.service.Service;
import org.bukkit.plugin.java.JavaPlugin;

public class Vanish extends JavaPlugin {

    @Override
    public void onEnable() {
        final Service service = new Service();
        getServer().getPluginManager().registerEvents(new VanishListeners(service), this);
        final BukkitCommandManager commandManager = new BukkitCommandManager(this);
        commandManager.registerCommand(new VanishCommand(service));
        commandManager.registerCommand(new OnCommand(service));
        commandManager.registerCommand(new OffCommand(service));
    }
}
