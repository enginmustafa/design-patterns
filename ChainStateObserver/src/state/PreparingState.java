package state;

import observer.Observable;

public class PreparingState implements State {

	private String stateName = "PREPARING_SHIPMENT";
	
	@Override
	public void applyState(Context context) {
		context.setState(this);
	}
	
	public void resetState(Observable observable) {
		WaitingState waitingState = new WaitingState();
		
		observable.setState(waitingState);
	}
	
	public String getStateName() {
		return this.stateName;
	}

}
