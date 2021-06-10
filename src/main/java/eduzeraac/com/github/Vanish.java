package eduzeraac.com.github;

import co.aikar.commands.BukkitCommandManager;
import eduzeraac.com.github.commands.OffCommand;
import eduzeraac.com.github.commands.OnCommand;
import eduzeraac.com.github.commands.VanishCommand;
import eduzeraac.com.github.listener.Listeners;
import eduzeraac.com.github.manager.Manager;
import org.bukkit.plugin.java.JavaPlugin;

public class Vanish extends JavaPlugin {

    @Override
    public void onEnable() {
        final Manager manager = new Manager();
        final BukkitCommandManager commandManager = new BukkitCommandManager(this);
        commandManager.registerCommand(new VanishCommand(manager));
        commandManager.registerCommand(new OnCommand(manager));
        commandManager.registerCommand(new OffCommand(manager));
        getServer().getPluginManager().registerEvents(new Listeners(manager), this);
    }
}
