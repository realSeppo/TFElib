package org.tfeteam.tfelib.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SimpleItem extends ItemStack {
    public SimpleItem(Material material, String name, List<String> lore){
        super(material);

        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        this.setItemMeta(meta);
    }

    public void setName(String name){
        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(name);
        this.setItemMeta(meta);
    }
    public void setLore(List<String> lore){
        ItemMeta meta = this.getItemMeta();
        meta.setLore(lore);
        this.setItemMeta(meta);
    }
}
