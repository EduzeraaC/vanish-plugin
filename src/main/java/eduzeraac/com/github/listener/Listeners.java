package eduzeraac.com.github.listener;

import eduzeraac.com.github.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {

    private final Manager manager;

    public Listeners(Manager manager) {
        this.manager = manager;
    }

    @EventHandler
    private void onEnter(PlayerJoinEvent event) {
        manager.onEnter(event.getPlayer());
    }

    @EventHandler
    private void onDisable(PlayerQuitEvent event) {
        manager.onQuit(event.getPlayer());
    }
}
