package ir.deadlight.ea2;

import es.minetsii.eggwars.API.EggWarsAPI;
import es.minetsii.eggwars.EggWars;
import es.minetsii.eggwars.objects.Arena;
import es.minetsii.eggwars.objects.EwPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class randomCommand implements CommandExecutor {

    public Random rand = new Random();

    public boolean isValidArena(Arena thearena) {
        boolean validity = true;
        //first check
        if (thearena.isInGame()) {
            validity = false;
        }
        if (thearena.isFull()) {
            validity = false;
        }
        if (!thearena.isSetup()) {
            validity = false;
        }

        return validity;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player){

            HashMap<Arena, Integer> map = new HashMap();

            Player player = (Player) sender;

            EwPlayer ewplayer  = EggWarsAPI.getEggWarsPlayer(player);

            if (!ewplayer.isInArena()) {
                Set<Arena> arenas = EggWars.getArenaManager().getArenas();
                ArrayList<Arena> validarenas = new ArrayList();
                for (Arena thearena : arenas) {

                    if (isValidArena(thearena)) {
                        validarenas.add(thearena);
                        map.put(thearena, thearena.getPlayers().size());
                    }
                }

                if (validarenas.size() != 0) {


                    ArrayList<Arena> lastly = new ArrayList();
                    for (Map.Entry<Arena, Integer> set : map.entrySet()) {
                        if (set.getValue() > 0) {
                            lastly.add(set.getKey());
                        }
                    }

                    Arena choosenarena;

                    if (lastly.size() != 0) {
                        int randomindex = rand.nextInt(lastly.size());
                        choosenarena = lastly.get(randomindex);
                    } else {

                        int randomindex = rand.nextInt(validarenas.size());
                        choosenarena = validarenas.get(randomindex);
                    }

                    player.sendMessage(Utils.color(Utils.matchFound.replace("%arena%", choosenarena.getName())));
                    EggWarsAPI.joinArena(choosenarena, ewplayer);

                } else {

                    player.sendMessage(Utils.color(Utils.noMatch));
                    player.performCommand("spawn");

                }
            } else {
                player.sendMessage(Utils.color("&cShoma ghader be ejraye in dastor dar hengam play game nistid."));
            }

        }

        return false;
    }
}
