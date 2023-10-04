package baseNoStates;


import java.util.ArrayList;

public class Area {

  private final String areaId;
  private final ArrayList<Door> DoorsGivingAccess;
  public Area(String id, ArrayList<Door> allDoors) { //constructor del area

    DoorsGivingAccess = new ArrayList<>(); // inicializamos el array vacio
    this.areaId = id;
    for (Door door : allDoors) {

      if (door.getTo().equals(id)) { // miramos que el 'destino' al atravesar la puerta sea el area que queremos
        DoorsGivingAccess.add(door);
      }
    }


  }


    public String getAreaId(){
      return areaId;

    }



  public  ArrayList<Door> getDoorsGivingAccess() { //nos devuelve una lista de puertas que dan al area seleccionada
    return DoorsGivingAccess;
  }


}

