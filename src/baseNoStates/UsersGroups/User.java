package baseNoStates.UsersGroups;


import baseNoStates.Actions;
import baseNoStates.AreaSpaces.Space;
import baseNoStates.Door;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class User {
  private final String name;
  private final String credential;

  private UserGroup group;

  public User(String name, String credential, UserGroup group) {
    this.name = name;
    this.credential = credential;
    this.group = group;
  }

  public UserGroup getGroup() {
    return group;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }

  public boolean canSendRequest(LocalDateTime now){

    DayOfWeek dayOfWeek = now.getDayOfWeek();
    int hour = now.getHour();
    int minute = now.getMinute();
    LocalTime time = LocalTime.of(hour,minute);
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();
    int year = now.getYear();
    LocalDate dateArgument = LocalDate.of(year,month,day);



    return switch (this.group.getGroupId()) {
      case "Employee" -> (dayOfWeek != Times.employeesNotAvailable && dayOfWeek != Times.employeesNotAvailable2
          && time.isBefore(Times.timeToEmployee) && time.isAfter(Times.timeFromEmployee) && dateArgument.isAfter(Times.dateFrom)
          && dateArgument.isBefore(Times.dateTo));
      case "Manager" -> (dayOfWeek != Times.managersNotAvailable && time.isBefore(Times.timeToManager)
          && time.isAfter(Times.timeFromManager) && dateArgument.isAfter(Times.dateFrom)
          && dateArgument.isBefore(Times.dateTo));
      case "Admin" -> true;
      default -> false; //BLANK USERS HERE
    };

  }

  public boolean canBeInSpace(Space space){


    return switch (this.group.getGroupId()) {
      case "Employee" -> this.group.getAreasAvailables().contains(space.getAreaID());
      case "Manager" -> true;
      case "Admin" -> true;
      default -> false; //BLANK USERS HERE
    };
  }

  public boolean canDoAction(String action){
    return switch (this.group.getGroupId()) {
      case "Employee" -> this.group.getGroupActions().contains(action);
      case "Manager" -> true;
      case "Admin" -> true;
      default -> false; //BLANK USERS HERE
    };
  }



}
