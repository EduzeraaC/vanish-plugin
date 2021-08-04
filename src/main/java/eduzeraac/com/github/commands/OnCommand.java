package eduzeraac.com.github.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import eduzeraac.com.github.service.Service;
import org.bukkit.entity.Player;

@CommandAlias("on")
public class OnCommand extends BaseCommand {

    private final Service service;

    public OnCommand(Service service) {
        this.service = service;
    }

    @Default
    private void onActivePlayers(Player player) {
        if (service.playerHidingPlayers(player)) {
            player.sendMessage("§cVocê já escondeu todos os jogadores.");
            return;
        }
        service.addPlayerToHidingPlayers(player);
    }
}
