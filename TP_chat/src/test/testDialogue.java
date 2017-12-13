package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import TP_chat.Dialogue;
import TP_chat.DialogueImpl;

class testDialogue {

	@Test
	void testDialogueImpl() {
		try {
			Dialogue component = new DialogueImpl("Bob");
			assertEquals("Bob", component.getPseudo());
			assertNotNull(component.getListMsg());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetPseudo() {
		try {
			Dialogue component = new DialogueImpl("Bob");
			assertEquals("Bob", component.getPseudo());			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetListMsg() {
		try {
			Dialogue component = new DialogueImpl("Bob");
			ArrayList<String> clients = new ArrayList<String>();
			clients.add("Bob");
			clients.add("Toto");
			clients.add("Momo");
			component.setListClients(clients);
			component.sendMessage("Toto", "Test");
			component.sendMessage("Momo", "Test2");
			ArrayList<String[]> messages = new ArrayList<String[]>();
			String[] msg1 = {"Toto","Test"};
			String[] msg2 = {"Momo","Test2"};
			messages.add(msg1);
			messages.add(msg2);
			ArrayList<String[]> result = component.getListMsg();
			for (int i=0; i<result.size(); i++) {
				assertArrayEquals(messages.get(i), result.get(i));	
			}	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testSetListClients() {
		try {
			Dialogue component = new DialogueImpl("Bob");
			ArrayList<String> listClients = new ArrayList<String>();
			listClients.add("Bob");
			listClients.add("Toto");
			component.setListClients(listClients);
			String str = "Liste des utilisateurs: Bob Toto ";
			assertEquals(str, component.getClients());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetClients() {
		try {
			Dialogue component = new DialogueImpl("Bob");
			ArrayList<String> listClients = new ArrayList<String>();
			listClients.add("Bob");
			listClients.add("Toto");
			component.setListClients(listClients);
			String str = "Liste des utilisateurs: Bob Toto ";
			assertEquals(str, component.getClients());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testDisconnect() {
		try {
			Dialogue component = new DialogueImpl("Bob");
			ArrayList<String> listClients = new ArrayList<String>();
			listClients.add("Bob");
			listClients.add("Toto");
			listClients.add("Momo");
			component.setListClients(listClients);
			component.disconnect("Toto");
			String str = "Liste des utilisateurs: Bob Momo ";
			assertEquals(str, component.getClients());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testSendMessage() {
		try {
			Dialogue component = new DialogueImpl("Bob");
			ArrayList<String> listClients = new ArrayList<String>();
			listClients.add("Bob");
			listClients.add("Toto");
			component.setListClients(listClients);
			assertEquals("Message envoyé !", component.sendMessage("Toto", "Test"));
			String[] msg = {"Toto","Test"};
			assertArrayEquals(msg, component.getListMsg().get(0));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetMessages() {
		//fail("Not yet implemented");
	}

}
