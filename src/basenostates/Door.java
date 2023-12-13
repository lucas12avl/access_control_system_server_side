package basenostates;
import basenostates.areaspaces.Space;
import basenostates.doorstates.DoorState;
import basenostates.doorstates.Unlocked;
import basenostates.requests.RequestReader;

import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically


  /*
  * These two new variables have been added to indicate where the door sensor
  *   is on (from) and where the door heads to (to).
  */
  private final Space from;
  private final Space to;


  // Added locked value
  private String locked;
  private DoorState currentState;

  public Door(final String id, final Space desde, final Space hacia) {

    this.id = id;
    closed = true;
    currentState = new Unlocked(this);
    /*
    Added locked value to door
     */
    locked = "locked";

    this.from = desde;
    this.to = hacia;

    //We assign the door the space it heads to
    this.to.addDoorsToSpace(this);
  }

  public void processRequest(final RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(final String action) {
    switch (action) {
      case Actions.OPEN:
        currentState.open();
        break;
      case Actions.CLOSE:
        currentState.close();
        break;
      case Actions.LOCK:
        currentState.lock();
        break;
      case Actions.UNLOCK:
        currentState.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        currentState.unlockShortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(final boolean close) {
    closed = close;
  }

  public String getId() {
    return id;
  }
  // We need to know where each door gives access.
  public Space getFrom() {
    return from;
  }
  public Space getTo() {
    return to;
  }

  // Get and set the state of each door.
  public String getStateName() {
    return currentState.getState();
  }
  public void setState(final DoorState newState) {
    currentState = newState;
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    json.put("from", this.getFrom().getAreaId());
    return json;
  }
}
