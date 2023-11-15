package basenostates.doorstates;

import basenostates.Door;
/*
*   Unlocked class:
*   Most of the code regarding the change of the door status is here due to the
*       fact that only when the door is unlocked can be either opened, closed
*       or locked.
*/
public class Unlocked extends DoorState {
    public Unlocked(final Door door) {
        super(door);
        this.setStateName(States.UNLOCKED);
    }

    @Override
    public void open() {
        if (this.door.isClosed()) {
            this.door.setClosed(false);
        } else {
            System.out.println("Can't open door " + this.door.getId()
                    + " because it's already " + "open");
        }
    }

    @Override
    public void close() {
        if (this.door.isClosed()) {
            System.out.println("Can't close door " + door.getId()
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
    public String getState() {
        return States.UNLOCKED;
    }
}
