package TP_chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Dialogue extends Remote {
	
	String connect(String pseudo) throws RemoteException;
	void disconnect(String pseudo) throws RemoteException;
	String getClients() throws RemoteException;
	String sendMessage(String from, String to, String message) throws RemoteException;
	String getMessages(String pseudo) throws RemoteException;
}
