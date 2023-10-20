package baseNoStates.AreaSpaces;

import baseNoStates.DirectoryDoors;
import baseNoStates.Door;

import java.util.ArrayList;

// se encarga de crear las diferentes areas
// tambien hay uq ehacer las partitions que son lugares que incluyen mucas areas
public final class DirectoryAreas {

 private static Area rootArea;
 private static ArrayList<Door> allDoors;



  public static void makeAreas() { // creamos areas y puertas, las puertas se autoañaden al area al q da acceso

   allDoors = DirectoryDoors.getAllDoors();

   //stairs
   ArrayList<Door> stairsToDoors;
   stairsToDoors = findDoorsToArea("stairs");
   Space stairs = new Space("stairs", stairsToDoors);

   //exterior
   ArrayList<Door> exteriorToDoors;
   exteriorToDoors = findDoorsToArea("exterior");
   Space exterior = new Space("exterior", exteriorToDoors);


   /*--------*/
   //IT
   ArrayList<Door> ItToDoors;
   ItToDoors = findDoorsToArea("IT");
   Space it = new Space("IT", ItToDoors);

   //corridor
   ArrayList<Door> corridorToDoors;
   corridorToDoors = findDoorsToArea("corridor");
   Space corridor = new Space("corridor", corridorToDoors);

   //room3
   ArrayList<Door> room3ToDoors;
   room3ToDoors = findDoorsToArea("room3");
   Space room3 = new Space("room3", room3ToDoors);


   //floor1
   ArrayList<Area> areasInFloor1 = new ArrayList<>();
   // add areas in floor1
   areasInFloor1.add(room3);
   areasInFloor1.add(corridor);
   areasInFloor1.add(it);
   Partition floor1 = new Partition("floor1", areasInFloor1);


   /*--------*/
   //room2
   ArrayList<Door> room2ToDoors;
   room2ToDoors = findDoorsToArea("room2");
   Space room2 = new Space("room2", room2ToDoors);

  //room1
   ArrayList<Door> room1ToDoors;
   room1ToDoors = findDoorsToArea("room1");
   Space room1 = new Space("room1", room1ToDoors);

   //hall
   ArrayList<Door> hallToDoors;
   hallToDoors = findDoorsToArea("hall");
   Space hall = new Space("hall", hallToDoors);

   //ground floor
   ArrayList<Area> areasInGF = new ArrayList<>();
   //add areas in GF
   areasInGF.add(hall);
   areasInGF.add(room1);
   areasInGF.add(room2);

   Partition ground_floor = new Partition("ground_floor",areasInGF);


   /*--------*/
   //parking
   ArrayList<Door> parkingToDoors;
   parkingToDoors = findDoorsToArea("parking");
   Space parking = new Space("parking",parkingToDoors);

   //basement
   ArrayList<Area> sotano = new ArrayList<>();
   sotano.add(parking);
   Partition basement = new Partition("basement", sotano);
   /*--------*/


   //root
   ArrayList<Area> buildingToDoors = new ArrayList<>();
   buildingToDoors.add(basement);
   buildingToDoors.add(ground_floor);
   buildingToDoors.add(floor1);
   buildingToDoors.add(stairs);
   buildingToDoors.add(exterior);
   rootArea = new Partition("building", buildingToDoors);

  }

  public static ArrayList<Door> getAllDoors(){
   return allDoors;
  }


 public static Door findDoorById(String id) {
  for (Door door : allDoors) {
   if (door.getId().equals(id)) {
    return door;
   }
  }
  System.out.println("door with id " + id + " not found");
  return null; // otherwise we get a Java error
 }

 public static ArrayList<Door> findDoorsToArea(String To){
   ArrayList<Door> AreaDoors = new ArrayList<>();

   for (Door door : allDoors){

    if (door.getTo().equals(To))
     AreaDoors.add(door);

   }
 return AreaDoors;

 }

 public static Area findAreaById(String nameArea){


  Area result = null;

  if (rootArea != null) { //miramos que no sea null la raiz
   result = rootArea.findAreaById(nameArea);
  }
  // devuelve el resultado
  return result;
 }


  }








