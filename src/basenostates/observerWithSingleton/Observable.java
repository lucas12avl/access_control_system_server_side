package basenostates.observerWithSingleton;

import basenostates.doorstates.Locked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*
*  the behavioural pattern observer has been applied here. the implementation consists
* in making the extended class clock observable and the implementation of UnlockedShortly as an observer when the state is assigned to a door
*
*
* */
public abstract class Observable {
  private static final Logger logger =
          LoggerFactory.getLogger(Observable.class);
  private final ArrayList<Observer> observers;
  private boolean changed;


  public Observable() {
    this.observers = new ArrayList<>();
    this.changed = false;
  }

  public void addObserver(Observer ob) {
    this.observers.add(ob);
  }
  public void deleteObserver(Observer ob){
    if (!this.observers.remove(ob)){
      logger.error("the observer can't be removed because it doesn't exist");
    }
  }


  public void setChanged(boolean change){
    changed = change;
  }
  public boolean getChanged(){
    return changed;
  }

  public void notifyObservers(LocalDateTime actualTime){
    if(getChanged()) {
      if(!observers.isEmpty()) {
        ArrayList<Observer> observersCopy = new ArrayList<>(observers);
        for (Observer observer : observersCopy) {
          observer.update(this, actualTime);
          changed = false;
        }
      }
    }
  }

}

