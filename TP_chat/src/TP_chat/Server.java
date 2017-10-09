package TP_chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Dialogue myComponent = new DialogueImpl();

			Naming.rebind("Dialogue", myComponent);

			System.out.println("Server online");

		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
