package basenostates.doorstates;

import basenostates.Door;

public class Locked extends DoorState {

    public Locked(final Door door) {
        super(door);
        this.setStateName(States.LOCKED);
    }

    @Override
    public void open() {
        System.out.println("Can't open the door because door is locked");
    }

    @Override
    public void close() {
        System.out.println(
                "Can't close the door because door it is already closed");
    }

    @Override
    public void lock() {
        System.out.println("Door already locked.");
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
}
