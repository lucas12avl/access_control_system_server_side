package baseNoStates.UsersGroups;

import baseNoStates.Actions;
import baseNoStates.AreaSpaces.Area;
import baseNoStates.AreaSpaces.DirectoryAreas;
import baseNoStates.AreaSpaces.Partition;

import java.util.ArrayList;

public final class  DirectoryUserGroups {
  //Arraylist that keeps userGroups object of each group with each user inside
  static final ArrayList<UserGroup> groups = new ArrayList<>();

  //BLANK GROUP INIT
  private static ArrayList<User>blankUsers = new ArrayList<>();
  private static ArrayList<String>blankAreas = new ArrayList<>();
  private static ArrayList<String>blankActions = new ArrayList<>();
  private static UserGroup blank = new UserGroup("Blank",blankUsers,blankAreas, blankActions );

  //EMPLOYEES GROUP INIT

  private static ArrayList<User>employeeUsers = new ArrayList<>();
  private static ArrayList<String>employeeAreas = new ArrayList<>();
  private static ArrayList<String>employeeActions = new ArrayList<>();
  private static UserGroup employee = new UserGroup("Employee",employeeUsers,employeeAreas, employeeActions);

  //MANAGER GROUP INIT

  private static ArrayList<User>managerUsers = new ArrayList<>();
  private static ArrayList<String>managerAreas = new ArrayList<>();
  private static ArrayList<String>managerActions = new ArrayList<>();
  private static UserGroup manager = new UserGroup("Manager",managerUsers,managerAreas, managerActions);

  //ADMIN INIT
  private static ArrayList<User>adminUsers = new ArrayList<>();
  private static ArrayList<String>adminAreas = new ArrayList<>();
  private static ArrayList<String>adminActions = new ArrayList<>();
  private static UserGroup admin = new UserGroup("Admin",adminUsers,adminAreas, adminActions);


  private static  final ArrayList<User> users = new ArrayList<>();
  public static void makeUserGroups() {


    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    // rol NONE significa que sólo guardamos los datos y no tienen permisos
    User user1= new User("Bernat", "12345",blank);
    User user2= new User("Blai", "77532", blank);
    users.add(user1);
    users.add(user2);
    blank.setUser(user1);
    blank.setUser(user2);
    //

    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    User user3=new User("Ernest", "74984", employee);
    User user4=new User("Eulalia", "43295", employee);
    users.add(user3);
    users.add(user4);
    employee.setUser(user3);
    employee.setUser(user4);
    employee.setActionsAvailable(Actions.CLOSE);
    employee.setActionsAvailable(Actions.OPEN);
    employee.setActionsAvailable(Actions.UNLOCK_SHORTLY);

    employeeAreas.add("stairs");
    employeeAreas.add("room1");
    employeeAreas.add("room2");
    employeeAreas.add("hall");
    employeeAreas.add("exterior");
    employeeAreas.add("IT");
    employeeAreas.add("room3");
    employeeAreas.add("corridor");

    employee.setAreasAvailables(employeeAreas);



    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    User user5=new User("Manel", "95783",manager);
    User user6=new User("Marta", "05827", manager);
    users.add(user5);
    users.add(user6);

    manager.setUser(user5);
    manager.setUser(user6);

    managerAreas.addAll(employeeAreas);
    managerAreas.add("parking");
    manager.setAreasAvailables(managerAreas);

    manager.setActionsAvailable(Actions.OPEN);
    manager.setActionsAvailable(Actions.CLOSE);
    manager.setActionsAvailable(Actions.LOCK);
    manager.setActionsAvailable(Actions.UNLOCK);
    manager.setActionsAvailable(Actions.UNLOCK_SHORTLY);

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    User user7=new User("Ana", "11343",admin);
    users.add(user7);
    admin.setUser(user7);

    adminAreas.addAll(managerAreas);
    admin.setAreasAvailables(adminAreas);

    admin.setActionsAvailable(Actions.OPEN);
    admin.setActionsAvailable(Actions.CLOSE);
    admin.setActionsAvailable(Actions.LOCK);
    admin.setActionsAvailable(Actions.UNLOCK);
    admin.setActionsAvailable(Actions.UNLOCK_SHORTLY);

    //Once made the groups add them into the list
    groups.add(blank);
    groups.add(employee);
    groups.add(manager);
    groups.add(admin);

  }

  public static User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
