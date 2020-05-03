package command;
import common.Trainee;

public class LayDownCommand implements Command {

	private Trainee trainee;
	
	public LayDownCommand(Trainee trainee) {
		this.trainee=trainee;
	}
	
	@Override
	public void execute() {
		this.trainee.layDown();
	}

}
