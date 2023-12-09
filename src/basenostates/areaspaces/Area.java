package basenostates.areaspaces;


import basenostates.Door;
import org.json.JSONObject;
import java.util.ArrayList;

// The composite programming pattern was used here

public abstract class Area {
 /*
  protected --> It is part of the derived classes, but those that are not
  derived must be accessed through getters and setters
  */
 protected String areaId;


 public Area(final String id) {
  this.areaId = id;
 }

 public String getAreaId() {
  return areaId;
 }

 public abstract Area findAreaById(String id);


 public abstract ArrayList<Door> getDoorsGivingAccess();

 public abstract JSONObject toJson(int depth);

}
