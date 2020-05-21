package common;

import mediator.MessageMediator;

public class Bot implements Participant {

    private MessageMediator mediator;
    private String name;
    private String controlWord;
    
    
    public void setMediator(MessageMediator med) {
    	this.mediator=med;
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
    
    public void setControlWord(String word) {
    	this.controlWord=word;
    	this.name = "BOT["+ controlWord +"]";
    }
    
	@Override
	public void receive(String msg) {
		// Bot can't receive messages.
		
	}

    public boolean isForbidden(String word) {
    	return word.equals(controlWord);
    }
	
	@Override
	public boolean isMessageValid(String msg, Participant participant) {
		if (isForbidden(msg)) {
			this.mediator.removeParticipant(participant);
			informUsers(participant.getName(), msg);
			return false;
		}
		return true;
		
	}
	
	private void informUsers(String name, String message) {
		this.mediator.sendMessage(" " + this.name + " removed: " + name + " from chat. The word " + message + " is forbidden.", this);		
	}

	@Override
	public void send(String msg) {
		//Bot cant send normal message.		
	}

	@Override
	public void setMediator() {
		this.mediator=null;
	}
}
