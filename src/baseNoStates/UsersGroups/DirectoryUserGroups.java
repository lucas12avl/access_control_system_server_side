package baseNoStates.UsersGroups;

import baseNoStates.AreaSpaces.DirectoryAreas;

import java.util.ArrayList;

public final class  DirectoryUserGroups {
  private static final ArrayList<UserGroup> groups = new ArrayList<>(); //lista con los grupos
  private static final ArrayList<User> users = new ArrayList<>();
  public static void makeUserGroups() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    // rol NONE significa que sólo guardamos los datos y no tienen permisos
    User user1= new User("Bernat", "12345", "Blank");
    User user2= new User("Blai", "77532", "Blank");
    users.add(user1);
    users.add(user2);

    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    User user3=new User("Ernest", "74984", "Employee");
    User user4=new User("Eulalia", "43295", "Employee");
    users.add(user3);
    users.add(user4);



    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    User user5=new User("Manel", "95783","Manager");
    User user6=new User("Marta", "05827", "Manager");
    users.add(user5);
    users.add(user6);
    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    User user7=new User("Ana", "11343","Admin");
    users.add(user7);


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

/*  void classifyUsersByGroups(ArrayList<User> usuarios){

    for (User user : usuarios){

      if (user.getRole() != null){
        switch (user.getRole()){

          case "Blank":
            ArrayList<DirectoryAreas> BlankAreas = new ArrayList<>();
            UserGroup Blank = new UserGroup("Blank",user, BlankAreas);





        }
      }


    }


  }*/


}
