package huffman;

import java.util.HashMap;
import java.util.Map;

public class Frequence {
	
	
	String traitementChaine;
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	int[] freqTableau = new int[25];
	char[] charTableau = new char[25];
	
	Frequence(String chaine){
		this.traitementChaine = chaine;
		
	}
	
	
	public void Occurence() {
		
		char[] charTable = this.traitementChaine.toCharArray(); 
		
		for(char c  : charTable) {
			
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		
	}
	
	public  void OccuTableau() {
		
		this.Occurence();
		int count = 0;
		//this.charTableau = new  char[this.map.size()];
		
		//this.freqTableau = new  int[this.map.size()];
		
		for(Map.Entry<Character, Integer> entry :this.map.entrySet()) {
			this.charTableau[count] = entry.getKey(); 
			this.freqTableau[count] = entry.getValue();
			count ++ ;
				
	}

  }
	
	public int tailleEffective() {
		
		int len = 0;
		int i = 0;
		while(this.charTableau[i] != '\0') {
			len++;
			i++;
		}
		return len;
	}
}
