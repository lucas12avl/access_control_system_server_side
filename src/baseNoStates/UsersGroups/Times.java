package baseNoStates.UsersGroups;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.LocalDate;

public final class Times {

  //schedulers for employees
  public static final LocalTime timeFromEmployee = LocalTime.of(9,0);
  public  static final LocalTime timeToEmployee = LocalTime.of(17,0);
  public  static final DayOfWeek employeesNotAvailable = DayOfWeek.SATURDAY;
  public static final DayOfWeek employeesNotAvailable2 = DayOfWeek.SUNDAY;


  //schedulers for Managers
  public static final LocalTime timeFromManager = LocalTime.of(8,0);
  public static final LocalTime timeToManager = LocalTime.of(20,0);
  public static final DayOfWeek managersNotAvailable = DayOfWeek.SUNDAY;


  //SCHEDULER GLOBAL
  public static final LocalDate dateFrom = LocalDate.of(2023,9,1);
  public static final LocalDate dateTo = LocalDate.of(2024,3,1);

}
