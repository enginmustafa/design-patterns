package state;

import observer.Observable;

public interface State {
	public void applyState(Context context);
	public String getStateName();
	public void resetState(Observable observable);
}
