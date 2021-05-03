package ir.deadlight.ea2.events;

import es.minetsii.eggwars.events.EwPlayerJoinArenaEvent;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

public class onMatchGoingToStart implements Listener {

    private HashMap<String, Instant> times = new HashMap<>();

    @EventHandler
    public void onMatch(EwPlayerJoinArenaEvent e) {

        if (e.getArena().hasEnoughtPlayers() && !e.getArena().isInGame()) {

            Instant now = Instant.now();

            if (times.containsKey(e.getArena().getName())) {

                Instant currentDate = times.get(e.getArena().getName());

                if (now.isAfter(currentDate.plusSeconds(60L))) {
                    List<Player> names = Bukkit.getWorld("world").getPlayers();
                    for (Player player : names) {

                        TextComponent message = new TextComponent(ChatColor.GOLD + e.getArena().getName() + ChatColor.AQUA + " Dar hale start shodan mibashad. " + ChatColor.GREEN + "(Click Baraye Join)");
                        message.setBold(true);
                        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ew join " + e.getArena().getName()));
                        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click konid baraye join shodan").color(ChatColor.GRAY).italic(true).create()));
                        player.spigot().sendMessage(message);
                        times.put(e.getArena().getName(), now);
                    }
                }

            } else {
                times.put(e.getArena().getName(), now);
                List<Player> names = Bukkit.getWorld("world").getPlayers();
                for (Player player : names) {

                    TextComponent message = new TextComponent(ChatColor.GOLD + e.getArena().getName() + ChatColor.AQUA + " Dar hale start shodan mibashad. " + ChatColor.GREEN + "(Click Baraye Join)");
                    message.setBold(true);
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ew join " + e.getArena().getName()));
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click konid baraye join shodan").color(ChatColor.GRAY).italic(true).create()));
                    player.spigot().sendMessage(message);
                    times.put(e.getArena().getName(), now);
                }
            }

        }


    }
    


}
