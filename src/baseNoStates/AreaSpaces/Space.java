
package baseNoStates.AreaSpaces;

import baseNoStates.Door;

import java.util.ArrayList;



class Space extends Area {

  private final ArrayList<Door> doors;
  //the id is defined in the abstract class


  public Space(String nameSpace, ArrayList<Door> doors) {
    super(nameSpace);
    this.doors = doors;


  }


  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }


  public Area findAreaById(String id) {
    // if the id matches the name, we return the area
    if (this.AreaID.equals(id)) {
      return this;
    }
    // if not, return null
    return null;
  }
}






