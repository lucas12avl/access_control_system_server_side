package baseNoStates.AreaSpaces;


import baseNoStates.Door;

import java.util.ArrayList;
import java.util.Arrays;


public final class DirectoryAreas { //makes the differents areas and doors

 private static Area rootArea;
 private static ArrayList<Door> allDoors;



 public static void makeAreas() { // space(id + array<doors>) , partition(id + array areas)


  //stairs
  Space stairs = new Space("stairs");
  //exterior
  Space exterior = new Space("exterior");


  /*--------*/
  //IT
  Space IT = new Space("IT");
  //corridor
  Space corridor = new Space("corridor");
  //room3
  Space room3 = new Space("room3");


  //floor1
  ArrayList<Area> areasInFloor1 = new ArrayList<>();
  // add areas in floor1
  areasInFloor1.add(room3);
  areasInFloor1.add(corridor);
  areasInFloor1.add(IT);
  Partition floor1 = new Partition("floor1", areasInFloor1);


  /*--------*/
  //room2
  Space room2 = new Space("room2");
  //room1
  Space room1 = new Space("room1");
  //hall
  Space hall = new Space("hall");

  //ground floor
  ArrayList<Area> areasInGF = new ArrayList<>();
  //add areas in GF
  areasInGF.add(hall);
  areasInGF.add(room1);
  areasInGF.add(room2);

  Partition ground_floor = new Partition("ground_floor",areasInGF);


  /*--------*/
  //parking
  Space parking = new Space("parking");
  //basement
  ArrayList<Area> areasInBasemenet = new ArrayList<>();
  areasInBasemenet.add(parking);
  Partition basement = new Partition("basement",areasInBasemenet);

  /*--------*/
  //root
  ArrayList<Area> buildingToDoors = new ArrayList<>();
  buildingToDoors.add(basement);
  buildingToDoors.add(ground_floor);
  buildingToDoors.add(floor1);
  buildingToDoors.add(stairs);
  buildingToDoors.add(exterior);
  rootArea = new Partition("building", buildingToDoors);

//We create the doors (id from to) in the constructor and they are automatically added to the area to which they give access since:
  // area = set of doors that give access to an area (that's why they are added to the To)
  Door d1 = new Door("D1", exterior, parking); // exterior, parking
  Door d2 = new Door("D2", stairs, parking); // stairs, parking

  // ground floor
  Door d3 = new Door("D3", exterior, hall); // exterior, hall
  Door d4 = new Door("D4", stairs, hall); // stairs, hall
  Door d5 = new Door("D5", hall, room1); // hall, room1
  Door d6 = new Door("D6", hall, room2); // hall, room2

  // first floor
  Door d7 = new Door("D7", stairs, corridor); // stairs, corridor
  Door d8 = new Door("D8", corridor, room3); // corridor, room3
  Door d9 = new Door("D9", corridor, IT); // corridor, IT

  allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));


 }





 public static Area findAreaById(String nameArea){


  Area result = null;

  if (rootArea != null) { //look if the root is null
   result = rootArea.findAreaById(nameArea);
  }

  return result;
 }

 public static ArrayList<Door> getAllDoors() {
  System.out.println(allDoors);
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


}