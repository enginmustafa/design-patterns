package observer;

import state.State;

public interface Observable {
	public void subscribe(Observer observer);
	public void unsubscribe(Observer observer);
	public void notifyObservers();
	public String getUpdate();
	public State getState();
	public void setState(State state);
	public String getName();
}
