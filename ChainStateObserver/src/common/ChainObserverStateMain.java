package common;

import chain.CityEmployee;
import chain.CountryEmployee;
import chain.InternationalEmployee;
import observer.Worker;
import state.PreparingState;
import state.WaitingState;

public class ChainObserverStateMain {

	public static void main(String[] args) {
		
		Worker worker = new Worker();
		
		Employee plovdivEmployee = new CityEmployee();
		Employee bulgariaEmployee = new CountryEmployee();
		Employee internationalEmployee = new InternationalEmployee();
		
		WaitingState waitingState = new WaitingState();
		
		worker.setName("[WW]");
		plovdivEmployee.setName("[PLOVDIV]");
		bulgariaEmployee.setName("[BG]");
		internationalEmployee.setName("[I]");

		plovdivEmployee.setNextEmployee(bulgariaEmployee);
		bulgariaEmployee.setNextEmployee(internationalEmployee);
		
		System.out.println("-------- Initiazlization --------\n");
		waitingState.applyState(plovdivEmployee);
		waitingState.applyState(bulgariaEmployee);
		waitingState.applyState(internationalEmployee);
		System.out.println("\n---------------------------------\n");

		
		plovdivEmployee.subscribe(worker);
		bulgariaEmployee.subscribe(worker);
		internationalEmployee.subscribe(worker);
		
		System.out.println("***** ORDER 1 - LEVEL 1 *****");
		plovdivEmployee.acceptShipment(1);
		System.out.println("\n***** ORDER 2 - LEVEL 2 *****");
		plovdivEmployee.acceptShipment(2);
		System.out.println("\n***** ORDER 3 - LEVEL 2 *****");
		bulgariaEmployee.acceptShipment(2);
		System.out.println("\n***** ORDER 4 - LEVEL 3 *****");
		plovdivEmployee.acceptShipment(3);
				
	}

}
