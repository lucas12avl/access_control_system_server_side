package basenostates.doorstates;

import basenostates.Door;
import basenostates.observerWithSingleton.Clock;
import basenostates.observerWithSingleton.Observable;
import basenostates.observerWithSingleton.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnlockedShortly extends DoorState implements Observer {

/*
 once we get an instance of this class, we must subscribe to the observable
 clock, and hold this state until the clock observer updates 10 times.
 this 10 updates (1 per second)  will increase the ticks count, the state
 checks if the door is closed, if it's closed, returns the door to the locked
 state if not, it will put the propped until it closes
 */
  private static final Logger logger = LoggerFactory.getLogger(UnlockedShortly.class);
  private final int period = 10;
  private int ticks = 0;

  public UnlockedShortly(final Door door) {
    super(door);
    Clock.getInstance().addObserver(this);

  }


  @Override
  public void open() {
    if (this.door.isClosed()) {
      this.door.setClosed(false);
    } else {
      logger.warn("Can't open door " + this.door.getId()
          + " because it's already " + "open");
    }
  }

  @Override
  public void close() {
    if (this.door.isClosed()) {
      logger.warn("Can't close door " + door.getId()
          + " because it's already " + "closed");
    } else {
      this.door.setClosed(true);
    }
  }

  @Override
  public void lock(){
    logger.warn("Can't lock de door"
            + door.getId()
            + "manually because it will be closed automatically after 10s ");
  }

  @Override
  public void unlock(){
    logger.warn("Can't unlock de door"
            + door.getId()
            + "manually because it will remain unlocked during 10s ");

  }

  @Override
  public void unlockShortly() {
    logger.info("Door already unlocked shortly.");
  }

  @Override //observer
  public void update(Observable ob, Object time) {
    ticks++;

    if (ticks >= period) {
      if (door.isClosed()) {
        door.setState(new Locked(door));
      } else {
        door.setState(new Propped(door));
      }
      logger.debug("\n \n Current Tick Amount = " + ticks );


      Clock.getInstance().deleteObserver(this);
    }

  }

  @Override
  public String getState() {
    return States.UNLOCKED_SHORTLY;
  }

}
