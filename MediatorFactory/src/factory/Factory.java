package factory;

import common.Participant;

public interface Factory {
	public Participant getParticipant(String participantType);
}
