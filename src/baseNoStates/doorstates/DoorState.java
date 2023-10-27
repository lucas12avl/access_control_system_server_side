package baseNoStates.doorstates;

import baseNoStates.Door;

// Abstract class that set each method used by each derived class.
public abstract class DoorState {

    protected Door door;
    protected String name;
    public DoorState(Door door){
        this.door = door;
    }

    public abstract void open();
    public abstract void close();
    public abstract void lock();
    public abstract void unlock();
    // Set the state of the door
    public void setStateName(String nouEstat) {
        this.name = nouEstat;
    }

    public String getState() {
        return States.UNLOCKED;
    }

}
