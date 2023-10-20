package baseNoStates.UsersGroups;

import baseNoStates.AreaSpaces.DirectoryAreas;

import java.util.ArrayList;


public class UserGroup { //Groups are the ones to make the actions, not the users
  private final String groupId;
  private ArrayList<User> userList = new ArrayList<>(); //list with the different users in the group
  private ArrayList<DirectoryAreas> areasAvailables;


  public UserGroup(String ID,User user,ArrayList<DirectoryAreas> areas){

   groupId = ID;
   userList.add(user);
   areasAvailables = areas;
  }

  public String getGroupId() {
    return groupId;
  }

  public ArrayList<User> getUserList() {
    return userList;
  }

  public ArrayList<DirectoryAreas> getAreasAvailables() {
    return areasAvailables;
  }

  public void setAreasAvailables(ArrayList<DirectoryAreas> areasAvailables) {
    this.areasAvailables = areasAvailables;
  }

  public void setUserList(ArrayList<User> userList) {
    this.userList = userList;
  }

}
