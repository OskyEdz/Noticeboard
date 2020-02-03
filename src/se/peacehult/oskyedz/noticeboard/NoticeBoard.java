package se.peacehult.oskyedz.noticeboard;

import org.bukkit.plugin.java.JavaPlugin;

public class NoticeBoard extends JavaPlugin {

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        System.out.println("Loading notices...");

        // Register our command (set an instance of your command class as executor)
        this.getCommand("noticeboard").setExecutor(new BoardCommand());
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }
}