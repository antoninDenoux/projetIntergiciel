package TP_chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dialogue myComponent;
		try {
			myComponent = (Dialogue) Naming.lookup("Dialogue");
			System.out.println(myComponent.connect("Bob"));
			System.out.println(myComponent.connect("JJG"));
			System.out.println(myComponent.connect("Bob"));
			System.out.println(myComponent.sendMessage("Toto", "Bob", "Premier message"));
			System.out.println(myComponent.sendMessage("Toto", "Bob", "Second message"));
			System.out.println(myComponent.getMessages("Bob"));
			System.out.println(myComponent.getClients());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
