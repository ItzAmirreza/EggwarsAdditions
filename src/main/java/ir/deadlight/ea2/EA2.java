package ir.deadlight.ea2;

import ir.deadlight.ea2.events.onMatchGoingToStart;
import org.bukkit.plugin.java.JavaPlugin;

public final class EA2 extends JavaPlugin {

    public static EA2 instance;
    public static EA2 getInstance() {

        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        //Commands Registrations
        logger("&bStarting to load &eEggwarsAdditions");
        saveDefaultConfig();
        registerCommand();

        Utils.reloadConfig();
        //register events
        getServer().getPluginManager().registerEvents(new onMatchGoingToStart(), this);
        logger("&bCommands Successfully loaded!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //shutdown
        logger("&cDisabling &eEggwarsAdditions");
        getServer().getPluginManager().disablePlugin(this);

    }
    public void registerCommand(){
        getServer().getPluginCommand("random").setExecutor(new randomCommand());
        getServer().getPluginCommand("eggwarsadditions").setExecutor(new pluginCommands());
    }

    public void logger(String str){
        getServer().getConsoleSender().sendMessage(Utils.color(str));
    }
}
