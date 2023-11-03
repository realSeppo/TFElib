package org.tfeteam.tfelib;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryHolder;
import org.tfeteam.tfelib.Menu.Menu;

public class EventListener implements Listener {
    public void onItemClick(InventoryClickEvent event) {
        InventoryHolder inventoryHolder = event.getInventory().getHolder();
        if (inventoryHolder instanceof Menu) {
            ((Menu) inventoryHolder).interact(event.getSlot(), (Player) event.getWhoClicked());
        }
    }
    public void onItemDrag(InventoryDragEvent event) {
        InventoryHolder inventoryHolder = event.getInventory().getHolder();
        if (inventoryHolder instanceof Menu) {
            for (int slot : event.getNewItems().keySet()) {
                ((Menu) inventoryHolder).interact(slot, (Player) event.getWhoClicked());
            }
        }
    }
}
