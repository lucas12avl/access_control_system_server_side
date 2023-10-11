package baseNoStates.doorstates;

import baseNoStates.Door;

public abstract class DoorState {

    protected Door door;
    protected String name;
    public DoorState(Door door){
        this.door = door;
    }

    public abstract void open();
        /*
            Esta acción inicialmente comprueba si está bloqueada o no.
            En caso de estar bloqueada indicará que está bloqueada y parará la
              acción.
             Si locked == false se abre la puerta.
         */
        /*
        if (doorstate.equals("locked")) {
            System.out.println("Do nothing lol.");
        }

        if (doorstate) {
            closed = false;
        } else {
            System.out.println("Can't open door " + id + " because it's already "
                    + "open");
        }

         */
    public abstract void close();
    public abstract void lock();
        /*
        if (!closed) {
            System.out.println("Can't lock door " + id + " because it is open.");
        } else {
            setStateName("locked");
            closed = true;
        }
        */

    public abstract void unlock();
        /*
        if (!closed) {
            System.out.println("Can't unlock door " + id + " because it is open.");
        } else {
            setStateName("unlocked");
            closed = true;
        }

         */

    public void setStateName(String nouEstat) {
        this.name = nouEstat;
    }

    public String getState() {
        return States.UNLOCKED;
    }

}
