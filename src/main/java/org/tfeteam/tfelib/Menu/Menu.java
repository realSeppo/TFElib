package org.tfeteam.tfelib.Menu;

import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import dev.lone.itemsadder.api.FontImages.TexturedInventoryWrapper;
import dev.lone.itemsadder.api.ItemsAdder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


public abstract class Menu implements InventoryHolder {
    Inventory inventory;
    TexturedInventoryWrapper texturedInventory;

    public Menu(int slots, String name){
        inventory = Bukkit.createInventory(this, slots, name);
    }
    public Menu(int slots, String name, String texture, int titleOffset, int textureOffset){
        texturedInventory = new TexturedInventoryWrapper(this, 27, name, titleOffset, textureOffset, new FontImageWrapper(texture));
        inventory = texturedInventory.getInternal();
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

    public void openInventory(Player player){
        if(texturedInventory != null) texturedInventory.showInventory(player);
        else player.openInventory(inventory);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
