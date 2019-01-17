package huffman;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Socket Client;
		arbre k = null ; 
		String resultat = "";
		
		try {
			
			System.out.println("Tentation de connexon sur le serveur ...");
			Client = new Socket(InetAddress.getLocalHost(),2222);
			System.out.println("Connexion établie ");
			ObjectInputStream input = new ObjectInputStream(Client.getInputStream());
			
			
			try {
				k = (arbre) input.readObject();
				//System.out.println("bloc try");
				System.out.println("Réception du message ");
				k.decode(k.resultat);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			

			
				
			
			

			Client.close();
			System.out.println("Fermeture de la socket");
			
		}
		catch(UnknownHostException e) {
			System.out.println(e);
		}
		
		catch(IOException e) {
			System.out.println(e);
		}
		
		
	}

}
