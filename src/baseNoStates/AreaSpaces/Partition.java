package baseNoStates.AreaSpaces;

import baseNoStates.Door;

import java.util.ArrayList;

public class Partition extends Area {
  private final ArrayList<Area> areas;

  public Partition(String namePartition, ArrayList<Area> areas){

    super(namePartition);
    this.areas = areas;

  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() { // go space by space obtaining all the doors it gives access to

    ArrayList<Door> inside_part_doors = new ArrayList<>(); //here we keep all the doors found within the partition
    for (Area area : areas) {  //We go through all the areas that the partition has, these areas can be other partitions themselves, or areas that already contain doors

      inside_part_doors.addAll(area.getDoorsGivingAccess());
    }
    return inside_part_doors;
  }



  public Area findAreaById(String id) {
    // if the id matches the name on the area, we have to return the area
    if (this.AreaID.equals(id)) {
      return this;
    }
    // If not, we go through the child areas and search recursively
    for (Area area : areas) {
      Area result = area.findAreaById(id);

      if (result != null) {
        return result;
      }
    }
    // if area not found, return null
    return null;
  }




}