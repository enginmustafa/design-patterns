package common;

import mediator.MessageMediator;

public class User implements Participant {

    private MessageMediator mediator;
    private String name;
    
    public void setMediator(MessageMediator med) {
    	this.mediator=med;
    }
    
    //remove mediator
    public void setMediator() {
    	this.mediator=null;
    }
    
    public MessageMediator getMediator() {
    	return this.mediator;
    }
    
    public void setName(String name) {
    	this.name=name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void send(String msg) {
    	if(mediator != null) {
	    	System.out.println(" + " + this.name + " sent: " + msg);
	        mediator.sendMessage(msg, this);
    	}
    }

    public void receive(String msg) {
    	System.out.println("	-" + this.name + " received:" + msg);
    }

	@Override
	public boolean isMessageValid(String msg, Participant participant) {
		// User can't validate messages.
		return true;
	}

	@Override
	public void setControlWord(String message) {
		//User can't control words.	
	}
}