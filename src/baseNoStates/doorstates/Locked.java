package baseNoStates.doorstates;

import baseNoStates.Door;

public class Locked extends DoorState{

    public Locked(Door door) {
        super(door);
        name = States.LOCKED;
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
        /*if (!door.isClosed()) {
            System.out.println("Can't lock door " + door.getId() + " because it is open.");
        } else {
            door.setStateName(name);
        }
        System.out.println("It is already locked.");*/
    }

    @Override
    public void unlock() {
        door.setStateName(new Unlocked(door));
    }
}
