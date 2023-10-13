package baseNoStates.AreaSpaces;


import baseNoStates.Door;

import java.util.ArrayList;

abstract class Area {
 protected String AreaID; //protected --> forma parte de las clases derivadas, pero las que no son derivadas deven acceder atraves de getters y setters


 public Area(String id) {
  this.AreaID = id;
 }

 public String getAreaID() {
  return AreaID;
 }

 public abstract ArrayList<Door> getDoors();



 //  se tiene que hacer para el process de la classe request areas


 public abstract Area findAreaById(String id);







}

