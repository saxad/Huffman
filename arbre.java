package huffman;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.PriorityQueue;

public class arbre implements  Serializable{
	
	String chaine ;
	Noeud root;
	String resultat = "";
	static HashMap< Character , String > dictionnaire = new HashMap<>(); 
	
	arbre(String chaine){
		this.chaine = chaine;
	}
	
	public String decode(String chaine) {
		

		String decoded = "";
		Noeud tmpNoeud = this.root;
		char[] zeroOneTab= chaine.toCharArray();
		
		
		
		for(int i = 0; i< zeroOneTab.length; i++)
		{   
			
			if(zeroOneTab[i] == '1' && tmpNoeud.droite != null) {
				
				tmpNoeud = tmpNoeud.droite;
		        
			}
			else if(zeroOneTab[i] == '0' && tmpNoeud.gauche != null){
				tmpNoeud = tmpNoeud.gauche;
				}
			if(tmpNoeud.gauche 
	                == null
	            && tmpNoeud.droite 
	                   == null
	            && (Character.isLetter(tmpNoeud.caractere))|| tmpNoeud.caractere == ' ' ) {
				decoded += tmpNoeud.caractere;
				//System.out.println(tmpNoeud.caractere);
	
	        	tmpNoeud = this.root;
			}
		}
		System.out.println(" le message decodé est :" + decoded);
		return decoded;
	}
	
	public BigInteger encode(String chaine) {
		
		
		String[] chaineTab = chaine.split("");
		System.out.println(" enregistrer les données dans un dictionnaire : \n " + arbre.dictionnaire);
		for(int i = 0; i< chaineTab.length; i++) {
			//System.out.println(chaineTab[i]);
			this.resultat += arbre.dictionnaire.get(chaineTab[i].charAt(0));
		}
		System.out.println("Notre message encodé : " + this.resultat);
		
		
		BigInteger bigresult = new BigInteger(this.resultat);
		return bigresult;
		
	}
	public void creation() {
	
		Frequence f = new Frequence(this.chaine);
		f.OccuTableau();
		
		PriorityQueue<Noeud> Queue = new PriorityQueue<Noeud>(f.tailleEffective(), new Comparateur());
		
		for(int i =0; i < f.tailleEffective(); i++) {
			Noeud newNoeud = new Noeud(f.charTableau[i], f.freqTableau[i]);
			Queue.add(newNoeud);
		}
		
		this.root = null;
		while(Queue.size() > 1) {
		      
			Noeud x = Queue.peek(); 
			Queue.poll(); 
  
             
            Noeud y = Queue.peek(); 
            Queue.poll(); 
   
            Noeud z = new Noeud(); 
   
            z.nbreOcc = x.nbreOcc + y.nbreOcc; 
            z.caractere = '-'; 
  
             
            z.gauche = x; 
  
             
            z.droite = y; 
  
             
            this.root = z; 
  
             
            Queue.add(z); 
		}
		
	}
	
	
	  
	public void printCode(Noeud root, String s) 
	    { 
			
	        if (root.gauche 
	                == null
	            && root.droite 
	                   == null
	            && (Character.isLetter(root.caractere))|| root.caractere == ' ' ) { 
	  
	        	
	            System.out.println( "le code correspondant a "+ root.caractere + " est :" + s);
	            root.code = s;
	            dictionnaire.put(root.caractere , root.code);
	            
	  
	            return; 
	        }   
	  
	        printCode(root.gauche , s + "0"); 
	        printCode(root.droite, s + "1"); 
	    } 
	

}
