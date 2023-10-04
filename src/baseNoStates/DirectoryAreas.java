package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

// se encarga de crear las diferentes areas
// tambien hay uq ehacer las partitions que son lugares que incluyen mucas areas
public final class DirectoryAreas {

  private static ArrayList<Area> allAreas;

  public static void makeAreas() {

    allAreas = new ArrayList<Area>();
    ArrayList<Door> doors = DirectoryDoors.getAllDoors();

    //creamos todas las areas
    Area parking = new Area("parking", doors );
    Area exterior = new Area("exterior", doors );
    Area stairs = new Area("stairs", doors );
    Area hall = new Area("hall", doors );
    Area room1 = new Area("room1", doors );
    Area room2 = new Area("room2", doors );
    Area room3 = new Area("room3", doors );
    Area corridor = new Area("corridor", doors );
    Area IT = new Area("IT", doors );


    allAreas = new ArrayList<Area>(Arrays.asList(parking, exterior, stairs, hall, room1, room2, room3, corridor, IT));
  }


  public static Area findAreaById(String id) {
    for (Area area : allAreas) {
      if (area.getAreaId().equals(id)) {
        return area;
      }
    }
    System.out.println("area with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  // this is needed by RequestRefresh
  public static ArrayList<Area> getAllAreas() {
    System.out.println(allAreas);
    return allAreas;
  }

}



