package basenostates.areaspaces;


import basenostates.Door;

import java.util.ArrayList;

// The composite programming pattern was used here

public abstract class Area {
 /*
  protected --> It is part of the derived classes, but those that are not
  derived must be accessed through getters and setters
  */
 protected String AreaId;


 public Area(final String id) {
  this.AreaId = id;
 }

 public String getAreaId() {
  return AreaId;
 }

 public abstract Area findAreaById(String id);


 public abstract ArrayList<Door> getDoorsGivingAccess();




}
