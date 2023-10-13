package baseNoStates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import baseNoStates.AreaSpaces.DirectoryAreas;

public class Main {
  public static void main(String[] args) {
    DirectoryDoors.makeDoors();
    DirectoryUsers.makeUsers();
    DirectoryAreas.makeAreas();
    new WebServer();
  }
}
