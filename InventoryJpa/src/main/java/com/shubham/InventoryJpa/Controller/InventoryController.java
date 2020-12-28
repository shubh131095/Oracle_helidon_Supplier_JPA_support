package com.shubham.InventoryJpa.Controller;

import com.shubham.InventoryJpa.Entity.Inventory;
import com.shubham.InventoryJpa.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{
  @Autowired
  InventoryService inventoryService;

  @PostMapping(value = "/{inventoryId}")
  public Inventory addinventory( @PathVariable ("inventoryId") String inventoryId )
  {
    System.out.println(
      "here add"
    );
        return this.inventoryService.addinventory( inventoryId );
  }
  @DeleteMapping(value = "/{inventoryId}")
  public Inventory deleteInventory( @PathVariable ("inventoryId") String inventoryId )
  {
    System.out.println(
      "here delete"
    );
    return this.inventoryService.deleteInventory( inventoryId );
  }
  @GetMapping(value = "/{inventoryId}")
  public Inventory getInventory( @PathVariable ("inventoryId") String inventoryId )
  {
    System.out.println(
      "here get"
    );
    return this.inventoryService.getInventory( inventoryId );
  }
}
