package eduzeraac.com.github.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import eduzeraac.com.github.service.Service;
import org.bukkit.entity.Player;

@CommandAlias("off")
public class OffCommand extends BaseCommand {

    private final Service service;

    public OffCommand(Service service) {
        this.service = service;
    }

    @Default
    private void onDesactivePlayers(Player player) {
        if (!service.playerHidingPlayers(player)) {
            player.sendMessage("§cVocê já está vendo todos os jogadores.");
            return;
        }
        service.removePlayerToHidingPlayers(player);
    }
}
