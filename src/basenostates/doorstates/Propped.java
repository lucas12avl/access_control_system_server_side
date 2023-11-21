package basenostates.doorstates;

import basenostates.Door;

public class Propped extends DoorState{
  public Propped(Door door) {
    super(door);
    this.setStateName(States.PROPPED);
  }
  /*this state only can be possible if the UnlockedShortly state ends and the door remains opened making impossible to turn the locked state again    */

  @Override
  public void open() {
    System.out.println("The door " + this.door.getId() + " is already open because is propped");
  }

  @Override
  public void close() {

    this.door.setClosed(true);
    System.out.println("The propped door " + this.door.getId() + " is now closed, changing door state to locked");
    door.setState(new Locked(door));
  }

  @Override
  public void lock() {
    System.out.println("The door " + this.door.getId() + " can't be locked because is propped, please close the door before");
  }

  @Override
  public void unlock() {
    System.out.println("The door " + this.door.getId() + " can't be unlocked because isn't locked yet. Please, close teh door before");
  }

  @Override
  public void unlockShortly() {
    System.out.println("The door " + this.door.getId() + " is already open and unlocked. Please, close teh door before");
  }

  @Override
  public String getState() {
    return States.PROPPED;
  }

}
