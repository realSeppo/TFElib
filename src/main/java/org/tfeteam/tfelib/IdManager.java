package org.tfeteam.tfelib;

import dev.lone.itemsadder.api.ItemsAdder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IdManager {
    public static String getId(ItemStack itemStack){
        if(ItemsAdder.isCustomItem(itemStack)){
            return  ItemsAdder.getCustomItemName(itemStack);
        }
        else return itemStack.getType().name();
    }

    public static ItemStack getItem(String id){
        if(ItemsAdder.isCustomItem(id)) return  ItemsAdder.getCustomItem(id);
        else return new ItemStack(Material.valueOf(id));
    }
}
