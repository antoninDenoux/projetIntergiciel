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
			//myComponent.connect("Bob");
			for (int i=0;i<myComponent.getClients().length;i++) {
				System.out.println(i);
				System.out.println(myComponent.getClients()[i]);
			}
			//myComponent.sendMessage("Bob", "Toto", "Premier message");
			//System.out.println(myComponent.getMessages("Bob"));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
