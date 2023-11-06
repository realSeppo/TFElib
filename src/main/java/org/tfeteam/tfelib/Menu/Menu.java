package org.tfeteam.tfelib.Menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.tfeteam.tfelib.Items.SimpleItem;


public abstract class Menu implements InventoryHolder {
    Inventory inventory;

    public Menu(int slots, String name){
        inventory = Bukkit.createInventory(this, slots, name);
    }

    protected void fill(SimpleItem item){
        ItemStack filler = item;
        ItemMeta meta = filler.getItemMeta();
        meta.setDisplayName(" ");
        filler.setItemMeta(meta);
        for (int i = 0; i < inventory.getSize(); i++) inventory.setItem(i, filler);
    }

    protected void setItem(SimpleItem item, int slot){
        inventory.setItem(slot, item);
    }

    public abstract void interact(int slot, Player player);

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
