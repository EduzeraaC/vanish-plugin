package eduzeraac.com.github.listeners;

import eduzeraac.com.github.service.Service;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class VanishListeners implements Listener {

    private final Service service;

    public VanishListeners(Service service) {
        this.service = service;
    }

    @EventHandler
    private void onEnter(PlayerJoinEvent event) {
        service.onEnter(event.getPlayer());
    }

    @EventHandler
    private void onDisable(PlayerQuitEvent event) {
        service.onQuit(event.getPlayer());
    }
}
