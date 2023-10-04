package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically

  //añadimos dos variables privadas to y from, que indican que la puerta va de un 'space' a otro,
  // 'from' es l 'space donde se encuentra el sensor
  private final String from;
  private final String to;


  // Added locked value
  private String locked;

  public Door(String id, String desde, String hacia) {
    this.id = id;
    closed = true;
    /*
    Added locked value to door
     */
    locked = "locked";

     this.from = desde;
     this.to = hacia;

  }

  public void processRequest(RequestReader request) {
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

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        /*
        Added this if statement
         */
        if (locked.equals("locked")) {
          break;
        }

        if (closed) {
          closed = false;
        } else {
          System.out.println("Can't open door " + id + " because it's already "
                  + "open");
        }
        break;
      case Actions.CLOSE:
        if (closed) {
          System.out.println("Can't close door " + id + " because it's already "
                  + "closed");
        } else {
          closed = true;
        }
        break;
      case Actions.LOCK:
        // TODO
        if (!closed) {
          System.out.println("Can't lock door " + id + " because it is open.");
        } else {
          setStateName("locked");
          closed = true;
        }
        break;
      case Actions.UNLOCK:
        // TODO
        if (!closed) {
          System.out.println("Can't unlock door " + id + " because it is open.");
        } else {
          setStateName("unlocked");
          closed = true;
        }
        break;
      case Actions.UNLOCK_SHORTLY:
        // TODO
        System.out.println("Action " + action + " not implemented yet");
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return locked;
  }

  public String getFrom() {
    return from;
  }
// necesitamos saber de donde a donde llevan las puertas
  public String getTo() {
    return to;
  }

  public void setStateName(String name) {
    this.locked = name;
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
    return json;
  }
}
