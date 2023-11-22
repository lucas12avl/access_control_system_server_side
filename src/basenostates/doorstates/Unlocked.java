package basenostates.doorstates;

import basenostates.Door;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
*   Unlocked class:
*   Most of the code regarding the change of the door status is here due to the
*       fact that only when the door is unlocked can be either opened, closed
*       or locked.
*/
public class Unlocked extends DoorState {

    private static final Logger logger = LoggerFactory.getLogger(Unlocked.class);
    public Unlocked(final Door door) {
        super(door);
        this.setStateName(States.UNLOCKED);
    }

    @Override
    public void open() {
        if (this.door.isClosed()) {
            this.door.setClosed(false);
        } else {

            logger.info("Can't open door " + this.door.getId()
                + " because it's already " + "open");
        }
    }

    @Override
    public void close() {
        if (this.door.isClosed()) {
            logger.info("Can't close door " + door.getId()
                + " because it's already " + "closed");
        } else {
            this.door.setClosed(true);
        }
    }

    @Override
    public void lock() {
        door.setState(new Locked(door));
    }

    @Override
    public void unlock() {
        door.setState(new Unlocked(door));
    }
    @Override
    public void unlockShortly() {
        logger.info("Can't unlock shortly the door " + door.getId()
            + " because it's already unlocked");

    }


    @Override
    public String getState() {
        return States.UNLOCKED;
    }


}
