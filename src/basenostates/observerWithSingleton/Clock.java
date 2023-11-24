package basenostates.observerWithSingleton;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/*
* We applied the Singleton creation pattern: the pattern consist in initialize
*   a unique instance of the clock because all UnlockedShortly states can be
* notified by the same clock
* */
public final class Clock extends Observable {
  private static Clock instance = null;

  private final Timer timer;


  private Clock() {

    this.timer = new Timer();
    start();

  }

  public static Clock getInstance() {

     if (instance == null) {
       instance =  new Clock();
     }
    return instance;
  }


  public void start() {
    TimerTask repeatedTask = new TimerTask() {
      public void run() {
        // once the clock starts running we have to change the date and notify
        //  observers every second
        setChanged(true);
        notifyObservers(LocalDateTime.now());
      }
    };
    timer.scheduleAtFixedRate(repeatedTask, 0L, 1000L);

  }
}
