package baseNoStates.AreaSpaces;

import baseNoStates.Door;

import java.util.ArrayList;

class Partition extends Area {
 private final ArrayList<Area> areas;

 public Partition(String namePartitionon, ArrayList<Area> areas){

  super(namePartitionon);
  this.areas = areas;

 }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() { // ir espacio por espacio obteniendo todas las puertas a las que da acceso

    ArrayList<Door> inside_part_doors = new ArrayList<>(); //aqui guardamos todas las puertas encontradas dentro de la particion
    for (Area area : areas) {  //recorremos todas las areas que tiene la particion, estas areas pueden ser otrs particiones en si mismas, o areas que ya contienen puertas

      inside_part_doors.addAll(area.getDoorsGivingAccess());
    }
    return inside_part_doors;
  }



  public Area findAreaById(String id) {
    // Si el id coincide con el de esta partición, la devolvemos
    if (this.AreaID.equals(id)) {
      return this;
    }
    // Si no, recorremos las áreas hijas y buscamos recursivamente
    for (Area area : areas) {
      Area result = area.findAreaById(id);
      // Si encontramos el área, la devolvemos
      if (result != null) {
        return result;
      }
    }
    // Si no encontramos el área, devolvemos null
    return null;
  }




}
