package com.shubham.InventoryJpa.Controller;


import com.shubham.InventoryJpa.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class InventoryController
{
  @Autowired
  InventoryService inventoryService;


  @PostMapping(value = "/addInventory")
  public String addinventory( @RequestParam("itemid") String inventoryId )
  {
    System.out.println(
      "here add"
    );
        return this.inventoryService.addInventory( inventoryId );
  }
  @DeleteMapping(value = "/removeInventory")
  public String removeInventory( @RequestParam("itemid") String inventoryId )
  {
    System.out.println(
      "here delete"
    );
    return this.inventoryService.removeInventory( inventoryId );
  }
  @GetMapping(value = "/getInventory")
  public String getInventory( @RequestParam("itemid") String inventoryId )
  {

    System.out.println("inventoryId in contoller:- "+ inventoryId);
    return this.inventoryService.getInventory( inventoryId );
  }
}
