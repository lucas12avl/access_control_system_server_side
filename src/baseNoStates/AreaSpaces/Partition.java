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
  public ArrayList<Door> getDoorsGivingAccess() { // it search space by space all the doors that are givin access to the selected space

    ArrayList<Door> inside_part_doors = new ArrayList<>(); //we need to save all the doors that we found
    for (Area area : areas) {  //we need to search all the areas that the partition contains, these other areas would be partitions or spaces (spaces only contains doors)

      inside_part_doors.addAll(area.getDoorsGivingAccess());
    }
    return inside_part_doors;
  }



  public Area findAreaById(String id) {
    // If the id matches the name of the partition we are in, we return it
    if (this.AreaID.equals(id)) {
      return this;
    }
    // If not, we go through the child areas and search recursively
    for (Area area : areas) {
      Area result = area.findAreaById(id);
      // if we find the area, we returned it
      if (result != null) {
        return result;
      }
    }
    // If we don't find the area, we return null
    return null;
  }




}
