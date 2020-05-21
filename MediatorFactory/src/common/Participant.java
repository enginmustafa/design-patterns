package common;

import mediator.MessageMediator;

public interface Participant {
	public void receive(String msg);
	public void send(String msg);
	
	public boolean isMessageValid(String msg, Participant participant);
	
	public void setName(String name);
	public String getName();
	
	public void setMediator(MessageMediator mediator);
	public void setMediator();
	public MessageMediator getMediator();
	
	public void setControlWord(String message);
}
