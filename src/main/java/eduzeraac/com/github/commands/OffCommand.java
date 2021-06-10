package eduzeraac.com.github.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import eduzeraac.com.github.manager.Manager;
import org.bukkit.entity.Player;

@CommandAlias("off")
public class OffCommand extends BaseCommand {

    private final Manager manager;

    public OffCommand(Manager manager) {
        this.manager = manager;
    }

    @Default
    private void onDesactivePlayers(Player player) {
        if (!manager.playerHidingPlayers(player)) {
            player.sendMessage("§cVocê já está vendo todos os jogadores.");
            return;
        }
        manager.removePlayerToHidingPlayers(player);
    }
}
