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
  public Inventory addinventory( String inventoryId)
  {
    Inventory inv = null;
      if(inventoryId == null || inventoryId.isEmpty())
      {
        return new Inventory("",null,0);
      }
      else
      {

          inventoryRepository.setInventoryCountById( inventoryId );
          inv = inventoryRepository.findById( inventoryId ).orElse( new Inventory() );
          return inv;
      }
  }

  @Transactional(
    dontRollbackOn = {EntityNotFoundException.class}
  )
  public Inventory deleteInventory( String inventoryId)
  {
    Inventory inv = null;
    if(inventoryId == null || inventoryId.isEmpty())
    {
      return new Inventory("",null,0);
    }
    else
    {
      inventoryRepository.deleteInventoryCountById( inventoryId );
      inv = inventoryRepository.findById( inventoryId ).orElse( new Inventory() );
      return inv;
    }
  }


  public Inventory getInventory( String inventoryId)
  {
    Inventory inv = null;
    if(inventoryId == null || inventoryId.isEmpty())
    {
      return new Inventory("",null,0);
    }
    else
    {
      inv = inventoryRepository.findById( inventoryId ).orElse( new Inventory() );
      return inv;
    }
  }
}
