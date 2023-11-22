package basenostates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import basenostates.areaspaces.DirectoryAreas;
import basenostates.usergroups.DirectoryUserGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  public static void main(final String[] args) {
    DirectoryUserGroups.makeUserGroups();
    DirectoryAreas.makeAreas();
    new WebServer();
  }
}
