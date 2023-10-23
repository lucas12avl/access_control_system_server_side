package baseNoStates;
import baseNoStates.AreaSpaces.Space;
import baseNoStates.doorstates.DoorState;
import baseNoStates.doorstates.Unlocked;
import baseNoStates.requests.RequestReader;

import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically


  //añadimos dos variables privadas to y from, que indican que la puerta va de un 'space' a otro,
  // 'from' es l 'space donde se encuentra el sensor
  private final Space from;
  private final Space to;


  // Added locked value
  private String locked;
  DoorState currentState;

  public Door(String id, Space desde, Space hacia) {

    this.id = id;
    closed = true;
    currentState = new Unlocked(this);
    /*
    Added locked value to door
     */
    locked = "locked";

    this.from = desde;
    this.to = hacia;

    this.to.addDoorsToSpace(this); // asiganmos la puerta al espcio al que lleva



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
        currentState.open();
        break;
      case Actions.CLOSE:
        /*
          Comprueba si la puerta está cerrada, en caso de estarlo lo indica por
            terminal.
          Si no está cerrada closed = true;
         */
        currentState.close();
        break;
      case Actions.LOCK:
        /*
          Comprueba si la puerta está abierta ya que en caso de estarlo no la
            puede bloquear.
          Si la puerta está cerrada el estado cambia a "locked" mediante el
            setter setStateName.
         */
        currentState.lock();
        break;
      case Actions.UNLOCK:
        /*
          Comprueba si la puerta está abierta.
          En caso de estarlo salta aviso en terminal que no puede desbloquear
            una puerta ya abierta.
          En caso de no estar abierta setStateName cambia el estado de la
            puerta a "unlocked".
         */
        currentState.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        /* TODO Implementar la acción UNLOCK_SHORTLY
          Max duration: 10s
          Get Current time
          En cada request del servidor se muestra la hora, quizas se pueda
            parsear cada request para obtener la hora.
          Una vez obtenida la hora se deben sumar 10s y indicar que la puerta
            permanecera unlocked hasta hora+10s, en caso de que la hora
            dada sea superior a hora+10s la puerta debe aparecer cerrada y
            bloqueada.
            Para ello podriamos usar las librerias:
              RequestReader
              JSONObject
            Me he fijado que en RequestReader hay una variable llamada
              private final LocalDateTime now;
            Que indica la hora en la que se ha hecho la accion.
            Quizas se pueda crear un getter en ese archivo?

            De los logs: eso *parece* estructura json, no?
            created request reader Request{credential=11343, userName=unknown, action=unlock_shortly, now=2023-10-04T09:30, doorID=D1, closed=false, authorized=false, reasons=[]}
         */
        /*
        if (!closed) {
          System.out.println("Can't unlock door " + id + " because it is open.");
        } else {
          setStateName("unlocked");
          closed = true;
        }

         */

        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean close) {
    closed = close;
  }

  public String getId() {
    return id;
  }

  public Space getFrom() {
    return from;
  }

  // necesitamos saber de donde a donde llevan las puertas
  public Space getTo() {
    return to;
  }

  public String getStateName() {
    return currentState.getState();
  }

  public void setStateName(DoorState door) {
    this.currentState = door;
  }


  public void setStateName(String name) {
    this.locked = name;
  }

  public void setState (DoorState newState) {
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
    return json;
  }
}