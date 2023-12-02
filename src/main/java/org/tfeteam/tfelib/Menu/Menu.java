package org.tfeteam.tfelib.Menu;

import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import dev.lone.itemsadder.api.FontImages.TexturedInventoryWrapper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


public abstract class Menu implements InventoryHolder {
    Inventory inventory;

    public Menu(int slots, String name, String texture){
        if(texture == null) {
            inventory = Bukkit.createInventory(this, slots, name);
        }
        else{
            inventory = new TexturedInventoryWrapper(this, slots, name, new FontImageWrapper(texture)).getInternal();
        }
    }

    protected void fill(ItemStack item){
        ItemStack filler = item;
        ItemMeta meta = filler.getItemMeta();
        meta.setDisplayName(" ");
        filler.setItemMeta(meta);
        for (int i = 0; i < inventory.getSize(); i++) inventory.setItem(i, filler);
    }

    public void setItem(ItemStack item, int slot){
        inventory.setItem(slot, item);
    }
    public ItemStack getItem(int slot) {return inventory.getItem(slot);}

    public abstract boolean interact(int slot, Player player);

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
