package org.tfeteam.tfelib.Menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


public abstract class Menu implements InventoryHolder {
    Inventory inventory;

    public Menu(int slots, String name){
        inventory = Bukkit.createInventory(this, slots, name);
    }

    protected abstract void init();

    void fill(){
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = filler.getItemMeta();
        meta.setDisplayName(" ");
        filler.setItemMeta(meta);
        for (int i = 0; i < inventory.getSize(); i++) inventory.setItem(i, filler);
    }

    void createItem(Material material, String name, int slot){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        inventory.setItem(slot, item);
    }

    public abstract void interact(int slot, Player player);

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
