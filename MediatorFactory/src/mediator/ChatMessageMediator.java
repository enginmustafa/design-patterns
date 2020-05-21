package mediator;

import java.util.ArrayList;
import java.util.List;

import common.Bot;
import common.Participant;
import common.ParticipantTypes;
import common.util.MessageUtil;
import factory.Factory;
import factory.ParticipantFactory;

public class ChatMessageMediator implements MessageMediator {
    private List<Participant> participants;

    public ChatMessageMediator() {
        this.participants = new ArrayList<>();
    }

    private boolean isBot(Participant participant) {
    	return participant instanceof Bot;
    }
    
    private void addBot(String controlWord) {
    	if(controlWord == null)
    		return;
    	
		//if controlWord is less than 1/greater than 20 characters, don't add bot
		if(controlWord.length() < 1 || controlWord.length() > 20 ) 
			return;

		Factory factory = new ParticipantFactory();
		Participant bot = factory.getParticipant(ParticipantTypes.bot);
		bot.setControlWord(controlWord);
		
		this.addParticipant(bot);
    }
    
    @Override
    public void sendMessage(String message, Participant sender) {
    	MessageUtil messageUtil = new MessageUtil(message," ");
    	
        for (Participant p : this.participants) {
        	
        	//if chat participant is bot and sender is not, 
        	//checkMessage, else, receiveMessage
        	if(isBot(p)) {
        			//if message is forbidden, remove user
        			//break of loop to prevent concurrent modification
        			if(!p.isMessageValid(message,sender)) {
        				break;
        			}
        	}
    		//bot can't add bot
        	else if(!isBot(sender) && messageUtil.FirstWord.equals("addBot")) {
        		addBot(messageUtil.SecondWord);
        		break;
        	}
        	else {
        		
        		//sender should not receive his own message
        		if (p != sender)
                    p.receive(message);
        	}
        }
    }
        
    @Override
    public void addParticipant(Participant participant) {
    	participant.setMediator(this);
        this.participants.add(participant);
    }
    
   
	@Override
	public void removeParticipant(Participant participant) {
			participant.setMediator();
			this.participants.remove(participant);	
	}
}