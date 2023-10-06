package baseNoStates;
class rol{ //variables globales para cada tipo de user
  static final int none = 0;
  static final int employee = 1;
  static final int manager = 2;
  static final int admin = 3;
}

public class User {
  private final String name;
  private final String credential;

  private final int role; //rol del usuario dentro de la app

  public User(String name, String credential, int role) {
    this.name = name;
    this.credential = credential;
    this.role = role;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
