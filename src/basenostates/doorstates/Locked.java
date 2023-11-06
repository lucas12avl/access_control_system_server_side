package basenostates.doorstates;

import basenostates.Door;

public class Locked extends DoorState{

    public Locked(Door door) {
        super(door);
        this.setStateName(States.LOCKED);
    }

    @Override
    public void open() {
        System.out.println("Can't open the door because door is locked");
    }

    @Override
    public void close() {
        System.out.println("Can't close the door because door it is already closed");
    }

    @Override
    public void lock() {
        System.out.println("Door already locked.");
    }

    @Override
    public void unlock() {
        door.setState(new Unlocked(door));
    }

    @Override
    public String getState() { return States.LOCKED; }
}
