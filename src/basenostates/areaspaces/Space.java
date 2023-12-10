
package basenostates.areaspaces;

import basenostates.Door;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Space extends Area {

  private final ArrayList<Door> doors = new ArrayList<>();
  // id already defined in abstract class

  public Space(final String nameSpace) {
    super(nameSpace);

  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }

  public Area findAreaById(final String id) {
    // if the id matches the name of the current space, we have to return this
    //  space
    if (this.areaId.equals(id)) {
      return this;
    }
    // if not, return null
    return null;
  }

  public void addDoorsToSpace(final Door puerta) {
    doors.add(puerta);
  }

  public JSONObject toJson(int depth) { // depth not used here
    JSONObject json = new JSONObject();
    json.put("class", "space");
    json.put("id", areaId);
    JSONArray jsonDoors = new JSONArray();
    for (Door d : doors) { //this doors are the unic that gives acces to the space
      jsonDoors.put(d.toJson());
    }
    json.put("access_doors", jsonDoors);
    return json;
  }
}
