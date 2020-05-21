package common;

import factory.Factory;
import factory.ParticipantFactory;
import mediator.ChatMessageMediator;
import mediator.MessageMediator;


public class FactoryMediatorMain {

	public static void main(String[] args) {
		
		MessageMediator mediator = new ChatMessageMediator();
		
		Factory factory = new ParticipantFactory();
		
		Participant user1 = factory.getParticipant(ParticipantTypes.user);
		Participant user2 = factory.getParticipant(ParticipantTypes.user);		
		Participant user3 = factory.getParticipant(ParticipantTypes.user);

		user1.setName("Phill");
		user2.setName("George");
		user3.setName("Natalia");
		
		mediator.addParticipant(user1);
		mediator.addParticipant(user2);
		mediator.addParticipant(user3);
		
		user1.send("Hello");
		user2.send("Hi Phill");
		user3.send("addBot cat");
		user1.send("Hi Natalia");
		user2.send("cat");
		
		//user is removed after usage of forbidden word
		//he cant send messages anymore
		user2.send("Am i removed?");
			
		//only users that are left in the conversation receive further messages
		user1.send("Have a nice day!");
	}

}
