package TP_chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {

	public ArrayList<String> listClients;
	public ArrayList<String[]> listMsg;

	protected DialogueImpl() throws RemoteException {
		super();
		listClients = new ArrayList<String>();
		listClients.add("Toto");
		listClients.add("Pierre");
		listMsg = new ArrayList<String[]>();
	}

	@Override
	public String connect(String pseudo) {
		boolean already = false;
		String answer = "Liste des utilisateurs: ";
		for (String nom : listClients) {
			answer += nom + " ";
			if (nom.equals(pseudo)) {
				already = true;
			}
		}
		if (!already) {
			listClients.add(pseudo);
			answer += pseudo;
		}
		return answer;
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
	public String sendMessage(String from, String to, String message) throws RemoteException {
		for (String nom : listClients) {
			if (nom.equals(to)) {
				String[] msg = { from, to, message };
				listMsg.add(msg);
				return "Message envoyé !";
			}
		}
		return "L'utilisateur " + to + " n'existe pas !";
	}

	@Override
	public String getMessages(String pseudo) throws RemoteException {
		boolean isMsg = false;
		String answer = "";
		for (String[] msg : listMsg) {
			if (msg[1].equals(pseudo)) {
				answer += "-- Message de " + msg[0] + " --\n" + msg[2] + "\n-- Fin du message --\n";
				isMsg = true;
			}
		}
		if (isMsg) {
			return answer+" ------Fin des messages------";
		} else {
			return "Vous n'avez pas de message ! :(";
		}
	}

}
