package common;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Environment;

import observer.Observable;
import observer.Observer;
import state.Context;
import state.State;

public abstract class Employee implements Context, Observable{
	
	public static int CITY = 1;
	public static int COUNTRY = 2;
	public static int INTERNATIONAL = 3;
	protected State state;
	
	protected List<Observer> observers = new ArrayList<Observer>();
	
	protected int level;
	
	protected String name;
	
	protected Employee nextEmployee;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setNextEmployee(Employee nextLogger) {
		this.nextEmployee = nextLogger;
	}
	
	public void acceptShipment(int level) {
		
		System.out.println("\nOrder with level " + level + " is being processed by " + this.name);
		
		//if employee can handle order, take it
		if(this.level >= level) {
			this.handleOrder();
		}
		//else pass it to next employee
		else if(this.nextEmployee != null) {
			System.out.println(this.name + " could not handle it.");
			
			this.nextEmployee.acceptShipment(level);
		}
		
	}
	
	abstract protected void handleOrder();
	
}
