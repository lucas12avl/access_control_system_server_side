
package baseNoStates.AreaSpaces;

import baseNoStates.Door;

import java.util.ArrayList;



public class Space extends Area {

  private final ArrayList<Door> doors = new ArrayList<>();
  // id already defined in abstract class


  public Space(String nameSpace) {
    super(nameSpace);

  }


  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }


  public Area findAreaById(String id) {
    // if the id matches the name of the current space, we have to return this space
    if (this.AreaID.equals(id)) {
      return this;
    }
    // if not, return null
    return null;
  }



  public void addDoorsToSpace(Door puerta){
    doors.add(puerta);
  }



}