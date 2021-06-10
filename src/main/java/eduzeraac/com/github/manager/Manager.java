package eduzeraac.com.github.manager;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Manager {

    private final List<Player> vanishPlayers;
    private final List<Player> playersHidingPlayers;

    public Manager() {
        this.vanishPlayers = new ArrayList<>();
        this.playersHidingPlayers = new ArrayList<>();
    }

    public void addVanishPlayer(Player player) {
        vanishPlayers.add(player);
        player.sendMessage("§aVocê ativou o vanish.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            allPlayer.hidePlayer(player);
        }
    }

    public void removeVanishPlayer(Player player) {
        vanishPlayers.remove(player);
        player.sendMessage("§cVocê desativou o vanish.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            allPlayer.showPlayer(player);
        }
    }

    public boolean playerVanished(Player player) {
        return vanishPlayers.contains(player);
    }

    public void addPlayerToHidingPlayers(Player player) {
        playersHidingPlayers.add(player);
        player.sendMessage("§eVocê escondeu todos os jogadores.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            player.hidePlayer(allPlayer);
        }
    }

    public void removePlayerToHidingPlayers(Player player) {
        playersHidingPlayers.remove(player);
        player.sendMessage("§aVocê está vendo todos os jogadores.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            if (!playerVanished(allPlayer)) {
                player.showPlayer(allPlayer);
            }
        }
    }

    public boolean playerHidingPlayers(Player player) {
        return playersHidingPlayers.contains(player);
    }

    public void onEnter(Player player) {
        if (getVanishPlayers().isEmpty()) return;
        for (Player vanished : getVanishPlayers()) {
            player.hidePlayer(vanished);
        }
    }
}
