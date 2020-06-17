package state;

public interface Context {

	public State getState();

	public void setState(State state);

}
