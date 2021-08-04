package eduzeraac.com.github.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import eduzeraac.com.github.service.Service;
import org.bukkit.entity.Player;

@CommandAlias("vanish|v")
@CommandPermission("vanish.vanish")
public class VanishCommand extends BaseCommand {

    private final Service service;

    public VanishCommand(Service service) {
        this.service = service;
    }

    @Default
    private void onVanish(Player player) {
        if (service.playerVanished(player)) {
            service.removeVanishPlayer(player);
            return;
        }
        service.addVanishPlayer(player);
    }

    @Subcommand("on")
    private void onActive(Player player) {
        if (service.playerVanished(player)) {
            player.sendMessage("§cSeu vanish já está ativo.");
            return;
        }
        service.addVanishPlayer(player);
    }

    @Subcommand("off")
    private void onDesactive(Player player) {
        if (!service.playerVanished(player)) {
            player.sendMessage("§cSeu vanish já está desativado.");
            return;
        }
        service.removeVanishPlayer(player);
    }
}
