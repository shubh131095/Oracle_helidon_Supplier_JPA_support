package com.shubham.InventoryJpa.Repository;

import com.shubham.InventoryJpa.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,String>
{

  @Modifying
  @Query("update inventory set inventoryCount = inventoryCount+1 where inventoryId = ?1")
  void setInventoryCountById(String inventoryId);

  @Modifying
  @Query("update inventory set inventoryCount = inventoryCount - 1 where inventoryId = ?1 and inventoryCount >0")
  void deleteInventoryCountById(String inventoryId);
}
