package baseNoStates.AreaSpaces;


import baseNoStates.Door;

import java.util.ArrayList;

public abstract class Area {
 protected String AreaID; //protected --> It is part of the derived classes, but those that are not derived must be accessed through getters and setters


 public Area(String id) {
  this.AreaID = id;
 }

 public String getAreaID() {
  return AreaID;
 }

 public abstract Area findAreaById(String id);


 public abstract ArrayList<Door> getDoorsGivingAccess();




}