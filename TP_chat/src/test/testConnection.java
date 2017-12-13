package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.Connection;

import org.junit.jupiter.api.Test;

import TP_chat.ConnectionImpl;
import TP_chat.Dialogue;

class testConnection {

	@Test
	void testConnectionImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDialogueList() {
		try {
			ConnectionImpl conn = new ConnectionImpl();
			Dialogue dial1 = conn.connect("Bob");
			Dialogue dial2 = conn.connect("Toto");
			assertEquals(dial1, conn.getDialogueList().get(0));
			assertEquals(dial2, conn.getDialogueList().get(1));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testConnect() {
		fail("Not yet implemented");
	}

	@Test
	void testDisconnect() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMessages() {
		fail("Not yet implemented");
	}

}
