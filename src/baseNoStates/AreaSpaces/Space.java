
package baseNoStates.AreaSpaces;

import baseNoStates.Door;

import java.util.ArrayList;



public class Space extends Area {

  private final ArrayList<Door> doors = new ArrayList<>();
  // la id esta definida en la abstracta area


  public Space(String nameSpace) {
    super(nameSpace);

  }


  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }


  public Area findAreaById(String id) {
    // Si el id coincide con el de este espacio, lo devolvemos
    if (this.AreaID.equals(id)) {
      return this;
    }
    // Si no, devolvemos null
    return null;
  }



  public void addDoorsToSpace(Door puerta){
    doors.add(puerta);
  }



}






