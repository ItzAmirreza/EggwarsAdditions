package ir.deadlight.ea2;

import org.bukkit.ChatColor;

public class Utils {


    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static String lobby;
    public static String matchFound;
    public static String noMatch;
    public static boolean startingAlert;
    public static String startingAlertMessage;

    public static void reloadConfig() {

        lobby = EA2.getInstance().getConfig().getString("lobby");
        matchFound = EA2.getInstance().getConfig().getString("matchFound");
        noMatch = EA2.getInstance().getConfig().getString("noMatch");
        startingAlert = EA2.getInstance().getConfig().getBoolean("starting-alert");
        startingAlertMessage = EA2.getInstance().getConfig().getString("starting-alert-message");

    }
}
