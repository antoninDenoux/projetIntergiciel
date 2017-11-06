package TP_chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ConnectionImpl extends UnicastRemoteObject implements Connection {
	
	public ArrayList<Dialogue> dialogueList;
	public ArrayList<String> listClients;

	protected ConnectionImpl() throws RemoteException {
		super();
		dialogueList = new ArrayList<Dialogue>();
		listClients = new ArrayList<String>();
	}

	public ArrayList<Dialogue> getDialogueList() {
		return dialogueList;
	}

	@Override
	public Dialogue connect(String pseudo) {
		try {
			Dialogue component = new DialogueImpl(pseudo);
			try {
				Naming.rebind(component.getPseudo(), component);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean alreadyPseudo=false;
			for (String client: listClients) {
				if (pseudo.equals(client)) {
					alreadyPseudo = true;
				}
			}
			if (!alreadyPseudo) {
				dialogueList.add(component);
				listClients.add(pseudo);
				for (Dialogue dialogue: dialogueList) {
					dialogue.setListClients(listClients);
				}
			} else {
				return null;
			}
			return component;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public void disconnect(String pseudo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMessages(String pseudo) throws RemoteException {
		boolean isMsg = false;
		String answer = "";
		for (Dialogue dialogue: dialogueList) {
			for (String[] msg: dialogue.getListMsg()) {
				if (msg[0].equals(pseudo)) {
					answer += "-- Message de " + dialogue.getPseudo() + " --\n" + msg[1] + "\n-- Fin du message --\n";
					isMsg = true;
				}
			}
		}
		if (isMsg) {
			return answer+" ------Fin des messages------";
		} else {
			return "Vous n'avez pas de message ! :(";
		}
	}

}
