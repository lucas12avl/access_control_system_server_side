package baseNoStates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import baseNoStates.AreaSpaces.DirectoryAreas;
import baseNoStates.UsersGroups.DirectoryUserGroups;

public class Main {
  public static void main(String[] args) {
    DirectoryDoors.makeDoors();
    DirectoryUserGroups.makeUserGroups();
    DirectoryAreas.makeAreas();
    new WebServer();
  }
}
