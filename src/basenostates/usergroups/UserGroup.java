package basenostates.usergroups;

import java.util.ArrayList;


public class UserGroup { //Groups are the ones to make the actions, not the users
  private final String groupId;
  private ArrayList<User> userList; //list with the different users in the group
  private ArrayList<String> areasAvailables;
  private ArrayList<String> actionsAvailable;


  public UserGroup(String ID,ArrayList<User> groupUsers,ArrayList<String> areas, ArrayList<String> actions){

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

  public ArrayList<String> getAreasAvailables() {
    return areasAvailables;
  }

  public void setAreasAvailables(ArrayList<String> areasNotAvailables) {
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
