package observer;

import java.util.ArrayList;
import java.util.List;

public class Worker implements Observer {

	private String name;
	
	@Override
	public void update(Observable employee) {
		if(employee.getUpdate() == null) {
			System.out.println("No state");
			return;
		}
		
		//get shipment only if employee is preparing it
		if(employee.getUpdate().equals("PREPARING_SHIPMENT"))
		{
			System.out.println(this.getName() + " got package from " + 
							   employee.getName() + " and headed to the warehouse.");
			employee.getState().resetState(employee);		
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
