package huffman;

import java.io.Serializable;

public class Noeud implements  Serializable{

	
	public char caractere;
	public int nbreOcc ;
	public Noeud gauche;
	public Noeud droite;
	public String code;
	
	Noeud(char c, int nbre) {
		this.caractere = c;
		this.nbreOcc = nbre;
		this.gauche = null;
		this.droite = null;
		this.code = "";
		
	}
	
	public Noeud() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return " le caractere dans le noeud est : " + this.caractere;
	}
}
