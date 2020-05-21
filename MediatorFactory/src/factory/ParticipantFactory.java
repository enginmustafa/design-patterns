package factory;

import common.Bot;
import common.Participant;
import common.ParticipantTypes;
import common.User;

public class ParticipantFactory implements Factory {

	@Override
	public Participant getParticipant(String participantType) {

	      if(participantType.equals(ParticipantTypes.user)){
	         return new User();
	         
	      } 
	      else if(participantType.equals(ParticipantTypes.bot)){
	         return new Bot();
	         
	      } 
	      else {
	    	  return null;
	      }	      
	}

}
