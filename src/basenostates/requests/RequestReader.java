package basenostates.requests;

import basenostates.areaspaces.DirectoryAreas;
import basenostates.usergroups.DirectoryUserGroups;
import basenostates.Door;
import basenostates.usergroups.User;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class RequestReader implements Request {
  private final String credential; // who
  private final String action;     // what
  private final LocalDateTime now; // when
  private final String doorId;     // where
  private String userName;
  private boolean authorized;
  private final ArrayList<String> reasons; // why not authorized
  private String doorStateName;
  private boolean doorClosed;

  public RequestReader(final String credential, final String action, final LocalDateTime now,
                       final String doorId) {
    this.credential = credential;
    this.action = action;
    this.doorId = doorId;
    reasons = new ArrayList<>();
    this.now = now;
  }

  public void setDoorStateName(final String name) {
    doorStateName = name;
  }

  public String getAction() {
    return action;
  }

  public boolean isAuthorized() {
    return authorized;
  }

  public void addReason(final String reason) {
    reasons.add(reason);
  }


  @Override
  public String toString() {
    if (userName == null) {
      userName = "unknown";
    }
    return "Request{"
            + "credential=" + credential
            + ", userName=" + userName
            + ", action=" + action
            + ", now=" + now
            + ", doorID=" + doorId
            + ", closed=" + doorClosed
            + ", authorized=" + authorized
            + ", reasons=" + reasons
            + "}";
  }

  public JSONObject answerToJson() {
    JSONObject json = new JSONObject();
    json.put("authorized", authorized);
    json.put("action", action);
    json.put("doorId", doorId);
    json.put("closed", doorClosed);
    json.put("state", doorStateName);
    json.put("reasons", new JSONArray(reasons));
    return json;
  }

  // see if the request is authorized and put this into the request, then send
  //  it to the door.
  // if authorized, perform the action.
  public void process() {
    User user = DirectoryUserGroups.findUserByCredential(credential);
    Door door = DirectoryAreas.findDoorById(doorId);
    assert door != null : "door " + doorId + " not found";
    authorize(user, door);
    // this sets the boolean authorize attribute of the request
    door.processRequest(this);
    // even if not authorized we process the request, so that if desired we
    //  could log all the requests made to the server as part of processing
    //  the request
    doorClosed = door.isClosed();
  }

  // the result is put into the request object plus, if not authorized,
  // why not, only for testing
  private void authorize(final User user, final Door door) {
    if (user == null) {
      authorized = false;
      addReason("user doesn't exists");
    } else {
      boolean aut; //helps us to know the reasons

      aut = user.canSendRequest(now);
      if (!aut) {
        addReason("Can not send request, is not your date/time");
      }


      aut = user.canBeInSpace(door.getFrom());
      if (!aut) {
        addReason("Can not send request from here");
      }


      aut =  user.canBeInSpace(door.getTo());
      if (!aut) {
        addReason("Can not go there");
      }



      aut = user.canDoAction(action);
      if (!aut) {
        addReason("Can not do the requested action");
      }



      authorized = user.canSendRequest(now)
              && user.canBeInSpace(door.getFrom())
              && user.canBeInSpace(door.getTo())
              && user.canDoAction(action);

    }
  }
}

