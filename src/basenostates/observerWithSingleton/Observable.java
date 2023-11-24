package basenostates.observerWithSingleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*
* The behavioural pattern observer has been applied here.
* The implementation consists in making the extended class clock observable
*   and the implementation of UnlockedShortly as an observer when the state is
*   assigned to a door.
* */
public abstract class Observable {
  private static final Logger LOGGER =
          LoggerFactory.getLogger(Observable.class);
  private final ArrayList<Observer> observers;
  private boolean changed;


  public Observable() {
    this.observers = new ArrayList<>();
    this.changed = false;
  }

  public void addObserver(final Observer ob) {
    this.observers.add(ob);
  }
  public void deleteObserver(final Observer ob) {
    if (!this.observers.remove(ob)) {
      LOGGER.error("the observer can't be removed because it doesn't exist");
    }
  }


  public void setChanged(final boolean change) {
    changed = change;
  }
  public boolean getChanged() {
    return changed;
  }

  public void notifyObservers(final LocalDateTime actualTime) {
    if (getChanged()) {
      if (!observers.isEmpty()) {
        ArrayList<Observer> observersCopy = new ArrayList<>(observers);
        for (Observer observer : observersCopy) {
          observer.update(this, actualTime);
          changed = false;
        }
      }
    }
  }

}

