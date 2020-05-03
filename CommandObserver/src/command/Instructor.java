package command;

public class Instructor {
	private String name;
	private Command command;
	
	
	public Instructor(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void tellCommand() {
		System.out.println("[i] " + this.name + " told command.");
		System.out.println();
		
		command.execute();
	}
}
