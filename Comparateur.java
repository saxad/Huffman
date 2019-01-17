package huffman;

import java.util.Comparator;

public class Comparateur implements Comparator<Noeud> {

	
	
	public int compare(Noeud x,Noeud y) 
	{
		return x.nbreOcc - y.nbreOcc;
	}
}


