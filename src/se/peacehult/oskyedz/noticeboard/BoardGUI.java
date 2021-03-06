package se.peacehult.oskyedz.noticeboard;

import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;

public class BoardGUI implements InventoryHolder, Listener {
    // Create a new inventory, with "this" owner for comparison with other inventories, a size , called
    private final Inventory inv;

    public BoardGUI() {
        inv = Bukkit.createInventory(this, 54, "Notice Board"); //Replace this with language variable.
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        return inv;
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.addItem(createGuiItem("Example Notice", "§aFirst line of notice", "§bPut up anything for sale!"));
        inv.addItem(createGuiItem("Example Notice #2", "§cMaybe you need something? Put it up!"));
    }

    // Nice little method to create a gui item with a custom name, and description
    public ItemStack createGuiItem(String name, String...lore) {
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);  //Cannot be NULL solution?
        ArrayList<String> metaLore = new ArrayList<String>();

        Collections.addAll(metaLore, lore);

        meta.setLore(metaLore);
        item.setItemMeta(meta);
        return item;
    }

    // You can open the inventory with this
    public void openInventory(Player p) {
        p.openInventory(inv);
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() != this) {
            return;
        }
        if (e.getClick().equals(ClickType.NUMBER_KEY)){
            e.setCancelled(true);
        }
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        // Using slots click is a best option for your inventory click's
        if (e.getRawSlot() == 10) p.sendMessage("You clicked at slot " + 10);
    }
}
