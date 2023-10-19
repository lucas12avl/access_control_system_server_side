package baseNoStates.UsersGroups;

import java.util.ArrayList;

public final class  DirectoryUserGroups {
  private static final ArrayList<UserGroup> groups = new ArrayList<>(); //lista con los grupos

  public static void makeUserGroups() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    // rol NONE significa que sólo guardamos los datos y no tienen permisos
    users.add(new User("Bernat", "12345", "Blank"));
    users.add(new User("Blai", "77532", "Blank"));

    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    users.add(new User("Ernest", "74984", "Employee"));
    users.add(new User("Eulalia", "43295", "Employee"));

    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    users.add(new User("Manel", "95783","Manager"));
    users.add(new User("Marta", "05827", "Manager"));

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    users.add(new User("Ana", "11343","Admin"));


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

  void classifyUsersByGroups(ArrayList<User> usuarios){

    for (User user : usuarios){

      if (user.getRole() != null){
        switch ()
      }


    }


  }


}
