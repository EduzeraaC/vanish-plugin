package eduzeraac.com.github.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import eduzeraac.com.github.manager.Manager;
import org.bukkit.entity.Player;

@CommandAlias("on")
public class OnCommand extends BaseCommand {

    private final Manager manager;

    public OnCommand(Manager manager) {
        this.manager = manager;
    }

    @Default
    private void onActivePlayers(Player player) {
        if (manager.playerHidingPlayers(player)) {
            player.sendMessage("§cVocê já escondeu todos os jogadores.");
            return;
        }
        manager.addPlayerToHidingPlayers(player);
    }
}
