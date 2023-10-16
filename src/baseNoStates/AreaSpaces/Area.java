package baseNoStates.AreaSpaces;


import baseNoStates.Door;

import java.util.ArrayList;

public abstract class Area {
 protected String AreaID; //protected --> forma parte de las clases derivadas, pero las que no son derivadas deven acceder atraves de getters y setters


 public Area(String id) {
  this.AreaID = id;
 }

 public String getAreaID() {
  return AreaID;
 }


 //  se tiene que hacer para el process de la classe request areas


 public abstract Area findAreaById(String id);


public abstract ArrayList<Door> getDoorsGivingAccess();




}

