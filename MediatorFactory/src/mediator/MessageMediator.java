package mediator;

import common.Participant;


public interface MessageMediator {
    public void sendMessage(String message, Participant participant);
    public void addParticipant(Participant participant);
    public void removeParticipant(Participant participant);
}
