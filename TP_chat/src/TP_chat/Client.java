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
		Connection myConnection;
		Dialogue myComponent = null;
		
		try {
			boolean boucle = false;
			myConnection = (Connection) Naming.lookup("Connection");
			System.out.println("Bienvenue sur le tchat");
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
			while(!boucle) {
				System.out.println("Veuillez indiquer votre pseudo");
				String pseudoLine = userIn.readLine();
				myComponent = myConnection.connect(pseudoLine.split(" ")[0]);
				if (myComponent == null) {
					System.out.println("Pseudo déjà pris");
				} else {
					boucle = true;
					System.out.println(pseudoLine.split(" ")[0]+"--Début du tchat, taper help pour l'aide");
				}
			}			
			while (boucle) {
				String theLine = userIn.readLine();
				String[] req = theLine.split(" ");
				switch (req[0]) {
				case ("help"):
					System.out.println("Commandes disponibles: getClients ; getMessages ; end ; sendMessage");
					break;
				case ("sendMessage"):
					System.out.println(myComponent.sendMessage(req[1], req[2]));
					break;
				case ("getMessages"):
					System.out.println(myComponent.getMessages());
					break;
				case ("getClients"):
					System.out.println(myComponent.getClients());
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
