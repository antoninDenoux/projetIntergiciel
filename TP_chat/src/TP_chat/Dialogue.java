package TP_chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Dialogue extends Remote {
	
	void setListClients(ArrayList<String> listClients) throws RemoteException;
	void disconnect(String pseudo) throws RemoteException;
	String getClients() throws RemoteException;
	ArrayList<String[]> getListMsg() throws RemoteException;
	String sendMessage(String to, String message) throws RemoteException;
	String getMessages() throws RemoteException;
	String getPseudo() throws RemoteException;
}
