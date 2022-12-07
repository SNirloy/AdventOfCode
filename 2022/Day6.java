import java.util.*;
import java.io.*;

public class Day6{
	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File("Day6.in")));
		String line = reading.readLine();
		HashMap<Character, Integer> peating = new HashMap<Character, Integer>();
		for (int i = 13; i < line.length(); i++){
			for (int j = i -13; j <= i; j++){
				char letter = line.charAt(j);
				if (peating.containsKey(letter)){
					peating.clear();
					break;
				}
				else{peating.put(letter, i);}
			}
			if (peating.size() == 14){
				System.out.println(i + 1);
				break;
			}
		}
	}
}