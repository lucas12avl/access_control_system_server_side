package basenostates.doorstates;

import basenostates.Door;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Propped extends DoorState {

  private static final Logger logger = LoggerFactory.getLogger(Propped.class);

  public Propped(final Door door) {
    super(door);
    this.setStateName(States.PROPPED);
  }
  /*
    this state only can be possible if the UnlockedShortly state ends and the
    door remains opened making impossible to turn the locked state again
    */

  @Override
  public void open() {
    logger.warn("The door "
            + this.door.getId()
            + " is already open because is propped");
  }

  @Override
  public void close() {

    this.door.setClosed(true);
    logger.debug("The propped door "
            + this.door.getId()
            + " is now closed, changing door state to locked");
    door.setState(new Locked(door));
  }

  @Override
  public void lock() {
    logger.warn("The door "
            + this.door.getId()
            + " can't be locked because is propped"
            + " please close the door before");
  }

  @Override
  public void unlock() {
    logger.warn("The door "
            + this.door.getId()
            + " can't be unlocked because isn't locked yet."
            + " Please, close the door before");
  }

  @Override
  public void unlockShortly() {
    logger.warn("The door "
            + this.door.getId()
            + " is already open and unlocked. "
            + " Please, close the door before");
  }

  @Override
  public String getState() {
    return States.PROPPED;
  }

}
