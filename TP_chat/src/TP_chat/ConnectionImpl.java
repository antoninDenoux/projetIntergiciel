package TP_chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConnectionImpl extends UnicastRemoteObject implements Connection {

	protected ConnectionImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Dialogue connect(String pseudo) {
		try {
			Dialogue myComponent = new DialogueImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void disconnect(String pseudo) {
		// TODO Auto-generated method stub
		
	}

}
