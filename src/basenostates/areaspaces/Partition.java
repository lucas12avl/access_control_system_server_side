package basenostates.areaspaces;

import basenostates.Door;

import java.util.ArrayList;

public class Partition extends Area {
  private final ArrayList<Area> areas;

  public Partition(final String namePartition, final ArrayList<Area> areas) {

    super(namePartition);
    this.areas = areas;

  }
  // go space by space obtaining all the doors it gives access to
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    //here we keep all the doors found within the partition
    ArrayList<Door> insidePartDoors = new ArrayList<>();
    /*
      We go through all the areas that the partition has, these areas can be
        other partitions themselves, or areas that already contain doors
     */
    for (Area area : areas) {

      insidePartDoors.addAll(area.getDoorsGivingAccess());
    }
    return insidePartDoors;
  }

  public Area findAreaById(final String id) {
    // if the id matches the name on the area, we have to return the area
    if (this.areaId.equals(id)) {
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
