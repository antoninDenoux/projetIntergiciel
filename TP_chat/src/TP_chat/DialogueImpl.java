package TP_chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {

	Connection myConnection;
	public ArrayList<String> listClients;
	public ArrayList<String[]> listMsg;
	public String pseudo;

	public DialogueImpl(String pseudo) throws RemoteException {
		super();
		listClients = new ArrayList<String>();
		listMsg = new ArrayList<String[]>();
		this.pseudo = pseudo;
	}

	public String getPseudo() {
		return pseudo;
	}
	
	public ArrayList<String[]> getListMsg() {
		return listMsg;
	}
	
	public void setListClients(ArrayList<String> listClients) {
		this.listClients = listClients;
	}

	@Override
	public String getClients() throws RemoteException {
		String answer= "Liste des utilisateurs: ";
		for (String nom: listClients) {
			answer += nom+" ";
		}
		return answer;
	}

	@Override
	public void disconnect(String pseudo) throws RemoteException {
		for (int i=0;i<listClients.size();i++) {
			if (listClients.get(i).equals(pseudo)) {
				listClients.remove(i);
			}
		}
	}

	@Override
	public String sendMessage(String to, String message) throws RemoteException {
		for (String nom : listClients) {
			if (nom.equals(to)) {
				String[] msg = {to, message };
				listMsg.add(msg);
				return "Message envoyé !";
			}
		}
		return "L'utilisateur " + to + " n'existe pas !";
	}

	@Override
	public String getMessages() throws RemoteException {
		try {
			myConnection = (Connection) Naming.lookup("Connection");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myConnection.getMessages(pseudo);
	}

}
