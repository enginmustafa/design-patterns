package common;
import java.util.ArrayList;
import java.util.List;

import observer.Observable;
import observer.Observer;

public class Trainee implements Observable{
	
	private String name;
	List<Observer> observers = new ArrayList<Observer>();
	private boolean layingDown;

	public Trainee(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void layDown() {
		this.layingDown=true;
		printExercise();
	}
	
	public void standUp() {
		this.layingDown=false;
		printExercise();
	}
	
	
	private void printExercise() {
		if(layingDown) 
			System.out.println("[t] " + getName() +" laid down.");
		else
			System.out.println("[t] " + getName() + " standed up.");
		
		
		System.out.println();
		notifyObservers();
	}
	@Override
	public void subscribe(Observer spectator) {
		this.observers.add(spectator);
		spectator.setTrainee(this);
		
	}
	@Override
	public void unsubscribe(Observer spectator) {
		this.observers.remove(spectator);
	}
	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
		
		System.out.println();
	}
	@Override
	public boolean getUpdate() {
		return this.layingDown;
	}
}
