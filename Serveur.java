package huffman;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur {
	
	
	public static void main(String[] args)  {
		
		InetAddress localadress ;
		ServerSocket standardist ;
		Socket serveur;
		PrintWriter out ;
		
		String chaine  ="saad zizi";
		arbre k = new arbre(chaine);
		k.creation();
		k.printCode(k.root,"");
		k.encode(chaine);
		
		
			try {
			standardist =  new ServerSocket(2222);
			System.out.println("Serveur ouvert sur le port 2222 \nEn attente d'un client ...");
			serveur = standardist.accept();
			
			System.out.println("connection accepté");
			

			ObjectOutputStream Output = new ObjectOutputStream(serveur.getOutputStream());
			Output.writeObject(k);

			
			standardist.close();
			System.out.println("Fermeture de la socket standardiste");
			serveur.close();
			System.out.println("Fermeture de la socket socket serveur");
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		
	}

}
