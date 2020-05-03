package common;
import command.Command;
import command.Instructor;
import command.LayDownCommand;
import command.StandUpCommand;
import observer.Spectator;

public class OberverCommandMain {

	public static void main(String[] args) {
		
		Instructor instructor = new Instructor("Philip");
		Trainee trainee = new Trainee("George");
		
		Spectator spec1 = new Spectator("Michael");
		Spectator spec2 = new Spectator("Silvia");
		Spectator spec3 = new Spectator("Nikolai");
		
		Command layDownCommand = new LayDownCommand(trainee);
		Command standUpCommand = new StandUpCommand(trainee);
		
		trainee.subscribe(spec1);
		trainee.subscribe(spec2);
		trainee.subscribe(spec3);
		
		instructor.setCommand(layDownCommand);
		instructor.tellCommand();
		
		instructor.setCommand(standUpCommand);
		instructor.tellCommand();

	}

}
