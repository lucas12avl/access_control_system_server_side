package baseNoStates.doorstates;

import baseNoStates.Door;

public class Unlocked extends DoorState{
    public Unlocked(Door door) {
        super(door);
        name = States.UNLOCKED;
    }

    @Override
    public void open() {
        /*super(door);*/
    }

    @Override
    public void close() {
        System.out.println("Door is already closed.");
    }

    @Override
    public void lock() {
        door.setStateName(new Locked(door));
    }

    @Override
    public void unlock() {
        System.out.println("Door is already unlocked.");
    }
}
