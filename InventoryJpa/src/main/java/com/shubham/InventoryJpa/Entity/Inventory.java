package io.helidon.data.examples.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "inventory")
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory implements Serializable
{

  @Id
  @Column(
    name = "inventoryid"
  )
  String inventoryId;

  @Column(
    name = "inventorylocation"
  )
  String inventoryLocation;

  @Column(
    name = "inventorycount"
  )
    @Check(
      constraints = "postive_count check(inventorycount>=0)"
    )
  Integer inventoryCount;

  public String getInventoryId()
  {
    return inventoryId;
  }

  public void setInventoryId( String inventoryId_ )
  {
    inventoryId = inventoryId_;
  }

  public String getInventoryLocation()
  {
    return inventoryLocation;
  }

  public void setInventoryLocation( String inventoryLocation_ )
  {
    inventoryLocation = inventoryLocation_;
  }

  public Integer getInventoryCount()
  {
    return inventoryCount;
  }

  public void setInventoryCount( Integer inventoryCount_ )
  {
    inventoryCount = inventoryCount_;
  }

  public Inventory( String inventoryId_, String inventoryLocation_, Integer inventoryCount_ )
  {
    super();
    inventoryId = inventoryId_;
    inventoryLocation = inventoryLocation_;
    inventoryCount = inventoryCount_;
  }
  public Inventory()
  {
    super();
  }
}

