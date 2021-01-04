package com.shubham.InventoryJpa.Service;

import com.shubham.InventoryJpa.Entity.Inventory;
import com.shubham.InventoryJpa.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Service
public class InventoryService
{
  @Autowired
  private InventoryRepository inventoryRepository;


  @Transactional(
    dontRollbackOn = {EntityNotFoundException.class}
  )
  public String addInventory( String inventoryId)
  {
    System.out.println("here in add service");
    System.out.println("Inventory value in service:- " + inventoryId );
    Inventory inv ;
      if(inventoryId == null || inventoryId.isEmpty())
      {
        return "inventoryCount for" + " " + "is" + 0;
      }
      else
      {

          inventoryRepository.setInventoryCountById( inventoryId );
          inv = inventoryRepository.findById( inventoryId ).orElse( new Inventory() );
        return "inventoryCount for " + inv.getInventoryId() + " is:-" + inv.getInventoryCount();
      }
  }

  @Transactional(
    dontRollbackOn = {EntityNotFoundException.class}
  )
  public String removeInventory( String inventoryId)
  {
    System.out.println("here in delete service");
    System.out.println("Inventory value in service:- " + inventoryId );
    Inventory inv ;
    if(inventoryId == null || inventoryId.isEmpty())
    {
      return "inventoryCount for" + " "+ "is" + 0;
    }
    else
    {
      inventoryRepository.deleteInventoryCountById( inventoryId );
      inv = inventoryRepository.findById( inventoryId ).orElse( new Inventory() );
      return "inventoryCount for " + inv.getInventoryId() + " is:-" + inv.getInventoryCount();
    }
  }


  public String getInventory( String inventoryId)
  {

    System.out.println("here in get service");
    System.out.println("Inventory value in service:- " + inventoryId );
    System.out.println("inventoryId :- " +inventoryId);
    Inventory inv ;
    if(inventoryId == null || inventoryId.isEmpty())
    {
      return "inventoryCount for " + " "+ "is:-" + 0;
    }
    else
    {
      inv = inventoryRepository.findById( inventoryId ).orElse( new Inventory() );
      System.out.println(inv);
      return "inventoryCount for " + inv.getInventoryId() + " is:-" + inv.getInventoryCount();
    }
  }
}
