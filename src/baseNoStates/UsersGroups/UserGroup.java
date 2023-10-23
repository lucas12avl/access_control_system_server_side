package baseNoStates.UsersGroups;

import baseNoStates.Actions;
import baseNoStates.AreaSpaces.Area;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import baseNoStates.UsersGroups.Times;
import java.util.ArrayList;


public class UserGroup { //Groups are the ones to make the actions, not the users
  private final String groupId;
  private ArrayList<User> userList; //list with the different users in the group
  private ArrayList<Area> areasAvailables;
  private ArrayList<String> actionsAvailable;


  public UserGroup(String ID,ArrayList<User> groupUsers,ArrayList<Area> areas, ArrayList<String> actions){

   groupId = ID;
   userList = groupUsers;
   areasAvailables = areas;
   actionsAvailable = actions;
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

  public void setAreasAvailables(ArrayList<Area> areasNotAvailables) {
    this.areasAvailables = areasNotAvailables;
  }

  public ArrayList<String> getGroupActions(){return actionsAvailable;}
  public void setActionsAvailable(String action){
    actionsAvailable.add(action);
  }

  public void setUser(User user) {
    this.userList.add(user);
  }


}
