package baseNoStates.UsersGroups;


public class User {
  private final String name;
  private final String credential;

  private final String role;

  public User(String name, String credential, String rol) {
    this.name = name;
    this.credential = credential;
    this.role = rol;
  }

  public String getRole() {
    return role;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
