package chain;

import common.Employee;
import observer.Observer;
import state.PreparingState;
import state.State;

public class InternationalEmployee extends Employee {

	public InternationalEmployee() {
		this.level = Employee.INTERNATIONAL;
	}

	@Override
	protected void handleOrder() {
		System.out.println(this.name + " has taken the order.");
		
		PreparingState preparingState = new PreparingState();
		
		this.setState(preparingState);
		
		notifyObservers();
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public void setState(State state) {
		this.state = state;		
		System.out.println(this.name + " is now " + this.state.getStateName());
	}

	@Override
	public void subscribe(Observer observer) {
		this.observers.add(observer);		
	}

	@Override
	public void unsubscribe(Observer observer) {
		this.observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: this.observers) {
			observer.update(this);
		}
	}

	@Override
	public String getUpdate() {
		return this.state.getStateName();
	}

}
