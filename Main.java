package huffman;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {

		
		String chaine  ="saad zizi";
        String[] chaineTab = chaine.split("");
        String resultat ="";
        
		arbre k = new arbre(chaine);
		k.creation();
		k.printCode(k.root,"");
		
		/*
		System.out.println(" dic " + arbre.dictionnaire);
		for(int i = 0; i< chaineTab.length; i++) {
			System.out.println(chaineTab[i]);
			resultat += arbre.dictionnaire.get(chaineTab[i].charAt(0));
		}
		System.out.println("this is result " + resultat);
		*/
		k.encode(k.chaine);
		k.decode(k.resultat);
		String p = k.resultat;
		 //p = p.trim().replaceAll("\n ", "");
		BigInteger  m = new BigInteger(p);
		System.out.println(m);
		
	}

}
