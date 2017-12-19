package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import TP_chat.ConnectionImpl;
import TP_chat.Dialogue;

class testConnection {

	@Test
	void testConnectionImpl() {
		try {
			ConnectionImpl conn = new ConnectionImpl();
			ArrayList<Dialogue> dialogueList = new ArrayList<Dialogue>();
			ArrayList<String> listClients = new ArrayList<String>();
			assertEquals(dialogueList, conn.getDialogueList());
			assertEquals(listClients, conn.getListClients());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testGetDialogueList() {
		try {
			ConnectionImpl conn = new ConnectionImpl();
			ArrayList<Dialogue> dialogueList = new ArrayList<Dialogue>();
			assertEquals(dialogueList, conn.getDialogueList());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetMessages() {
		try {
			ConnectionImpl conn = new ConnectionImpl();
			assertEquals("Vous n'avez pas de message ! :(",conn.getMessages("Bob"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
