package eduzeraac.com.github.service;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Service {

    private final List<String> vanishPlayers;
    private final List<String> playersHidingPlayers;

    public Service() {
        this.vanishPlayers = new ArrayList<>();
        this.playersHidingPlayers = new ArrayList<>();
    }

    public void addVanishPlayer(Player player) {
        vanishPlayers.add(player.getName());
        player.sendMessage("§aVocê ativou o vanish.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) allPlayer.hidePlayer(player);
    }

    public void removeVanishPlayer(Player player) {
        vanishPlayers.remove(player.getName());
        player.sendMessage("§cVocê desativou o vanish.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) allPlayer.showPlayer(player);
    }

    public boolean playerVanished(Player player) {
        return vanishPlayers.contains(player.getName());
    }

    public void addPlayerToHidingPlayers(Player player) {
        playersHidingPlayers.add(player.getName());
        player.sendMessage("§eVocê escondeu todos os jogadores.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) player.hidePlayer(allPlayer);
    }

    public void removePlayerToHidingPlayers(Player player) {
        playersHidingPlayers.remove(player.getName());
        player.sendMessage("§aVocê está vendo todos os jogadores.");
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            if (!playerVanished(allPlayer)) player.showPlayer(allPlayer);
        }
    }

    public boolean playerHidingPlayers(Player player) {
        return playersHidingPlayers.contains(player.getName());
    }

    public void onEnter(Player player) {
        if (getVanishPlayers().isEmpty()) return;
        for (String vanishedName : getVanishPlayers()) player.hidePlayer(Bukkit.getPlayerExact(vanishedName));
    }

    public void onQuit(Player player) {
        if (playerVanished(player)) removeVanishPlayer(player);
        if (playerHidingPlayers(player)) removePlayerToHidingPlayers(player);
    }
}
