package TP_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) {
		Dialogue myComponent;
		try {
			boolean boucle = true;
			myComponent = (Dialogue) Naming.lookup("Dialogue");
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Bienvenue sur le tchat, taper help pour l'aide");
			while (boucle) {
				String theLine = userIn.readLine();
				String[] req = theLine.split(" ");
				switch (req[0]) {
				case ("help"):
					System.out.println("Commandes disponibles: connect pseudo ; end ; sendMessage");
					break;
				case ("connect"):
					System.out.println(myComponent.connect(req[1]));
					break;
				case ("sendMessage"):
					System.out.println(myComponent.sendMessage(req[1], req[2], req[3]));
					break;
				case ("getMessages"):
					System.out.println(myComponent.getMessages(req[1]));
					break;
				case ("end"):
					boucle = false;
					System.out.println("Fin du tchat");
					break;
				default:
					System.out.println("Commande inconnue");
				}
			}
		} catch (NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
