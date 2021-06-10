package eduzeraac.com.github.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import eduzeraac.com.github.manager.Manager;
import org.bukkit.entity.Player;

@CommandAlias("vanish|v")
@CommandPermission("vanish.vanish")
public class VanishCommand extends BaseCommand {

    private final Manager manager;

    public VanishCommand(Manager manager) {
        this.manager = manager;
    }

    @Default
    private void onVanish(Player player) {
        if (manager.playerVanished(player)) {
            manager.removeVanishPlayer(player);
            return;
        }
        manager.addVanishPlayer(player);
    }

    @Subcommand("on")
    private void onActive(Player player) {
        if (manager.playerVanished(player)) {
            player.sendMessage("§cSeu vanish já está ativo.");
            return;
        }
        manager.addVanishPlayer(player);
    }

    @Subcommand("off")
    private void onDesactive(Player player) {
        if (!manager.playerVanished(player)) {
            player.sendMessage("§cSeu vanish já está desativado.");
            return;
        }
        manager.removeVanishPlayer(player);
    }
}
