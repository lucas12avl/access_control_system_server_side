package baseNoStates.UsersGroups;

import baseNoStates.AreaSpaces.DirectoryAreas;
import baseNoStates.AreaSpaces.Area;

import java.util.ArrayList;


public class UserGroup { //Groups are the ones to make the actions, not the users
  private final String groupId;
  private ArrayList<User> userList; //list with the different users in the group
  private ArrayList<Area> areasAvailables;


  public UserGroup(String ID,ArrayList<User> groupUsers,ArrayList<Area> areas){

   groupId = ID;
   userList = groupUsers;
   areasAvailables = areas;
  }

  public String getGroupId() {
    return groupId;
  }

  public ArrayList<User> getUserList() {
    return userList;
  }

  public ArrayList<Area> getAreasAvailables() {
    return areasAvailables;
  }

  public void setAreasAvailables(ArrayList<Area> areasAvailables) {
    this.areasAvailables = areasAvailables;
  }

  public void setUser(User user) {
    this.userList.add(user);
  }

}
