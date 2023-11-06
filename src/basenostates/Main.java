package basenostates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import basenostates.areaspaces.DirectoryAreas;
import basenostates.usergroups.DirectoryUserGroups;

public class Main {
  public static void main(String[] args) {
    // DirectoryDoors.makeDoors(); ya no hace falta
    DirectoryUserGroups.makeUserGroups();
    DirectoryAreas.makeAreas();
    new WebServer();
  }
}
