package basenostates.doorstates;

import basenostates.Door;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Locked extends DoorState {
    private static final Logger LOGGER = LoggerFactory.getLogger(Locked.class);

    public Locked(final Door door) {
        super(door);
        this.setStateName(States.LOCKED);
    }

    @Override
    public void open() {
        LOGGER.warn("Can't open the door"
                + this.door.getId()
                + "because it is locked");

    }


    @Override
    public void close() {
        LOGGER.warn("Can't open the door "
                + this.door.getId()
                + " because it is already closed");
    }

    @Override
    public void lock() {
        LOGGER.warn("Door " + this.door.getId() + " already locked.");

    }

    /*
    * If the door is locked, change the status to Unlocked indicating that
    *   it now goes to the Unlocked class.
     */
    @Override
    public void unlock() {
        door.setState(new Unlocked(door));

    }

    @Override
    public String getState() {
        return States.LOCKED;
    }

    @Override
    public void unlockShortly() {
        door.setState(new UnlockedShortly(door));
    }


}
