package observer;

public class Spectator implements Observer {

	private String name;
	private boolean layingDown;
	private Observable trainee;
	
	
	public Spectator(String name) {
		this.name=name;
	}
	public void setTrainee(Observable trainee) {
		this.trainee=trainee;
	}
	public Observable getTrainee() {
		return trainee;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	private String currentExercise() {
		return layingDown ? " laid down." : " standed up.";
	}
	
	@Override
	public void update() {
		if(trainee == null) {
			System.out.println("No trainee to watch.");
			return;
		}
		
		layingDown = trainee.getUpdate();
		
		System.out.println("[s] " + this.getName() + currentExercise());

	}
}
