package TP_chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {
	
	public String[] listClients;
	public String[] msg;

	protected DialogueImpl() throws RemoteException {
		super();
		listClients = new String[3];
		listClients[0] = "Toto";
		listClients[1] = "Bob";
		msg = new String[3];
	}
	
	@Override
	public void connect(String pseudo) {
		listClients[1] = pseudo;
	}

	@Override
	public String[] getClients() throws RemoteException {
		return listClients;
	}

	@Override
	public void disconnect(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(String from, String to, String message) throws RemoteException {
		msg[0] = from;
		msg[1] = to;
		msg[2] = message;
	}

	@Override
	public String[] getMessages(String pseudo) throws RemoteException {
		if (msg[0] == pseudo) {
			return msg;
		}
		else {
			return null;
		}
	}

}
