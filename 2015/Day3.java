import java.util.*;
import java.io.*;

public class Day3{
	public static int numHouses (String str){
		Map<String, Integer> houses = new HashMap <String, Integer> ();
		int xcoor = 0;
		int ycoor = 0;
		String key = ("" + xcoor + "," + ycoor);
		houses.put (key, 1);
		for (int i = 0; i < str.length(); i++){
			// Use if statements
			if (str.substring(i, i+1).equals("^")){
				ycoor++;
			}
			else if (str.substring(i, i+1).equals("v")){
				ycoor--;
			}
			else if (str.substring(i, i+1).equals(">")){
				xcoor++;
			}
			else{
				xcoor--;
			}
			key = ("" + xcoor + "," + ycoor);
			if ( houses.containsKey (key)){
				houses.replace(key, houses.get(key) + 1);
			}
			else{
				houses.put(key, 1);
			}
		}

		return houses.size();
	}

	public static int roboHouses(String str){
		Map<String, Integer> houses = new HashMap <String, Integer> ();
		int santax = 0;
		int santay = 0;
		int robox = 0;
		int roboy = 0;
		String key = ("" + 0 + "," + 0);
		houses.put (key, 2);
		for (int i = 0; i < str.length(); i++){
			// Use if statements
			if (i % 2 == 0){
				key = (santax + "," + santay);
				if (str.substring(i, i+1).equals("^")){
					santay++;
				}
				else if (str.substring(i, i+1).equals("v")){
					santay--;
				}
				else if (str.substring(i, i+1).equals(">")){
					santax++;
				}
				else{
					santax--;
				}
				key = ("" + santax + "," + santay);
			}
			else{
				key = (robox + "," + roboy);
				if (str.substring(i, i+1).equals("^")){
					roboy++;
				}
				else if (str.substring(i, i+1).equals("v")){
					roboy--;
				}
				else if (str.substring(i, i+1).equals(">")){
					robox++;
				}
				else{
					robox--;
				}
				key = ("" + robox + "," + roboy );
			}
			if ( houses.containsKey (key)){
				houses.replace(key, houses.get(key) + 1);
			}
			else{
				houses.put(key, 1);
			}
		}		
		return houses.size();
	}

	public static void main (String[] args) throws IOException{
		// System.out.println("Salutations, planet!");
		try{
			String input = args[0];
			File file = new File (input);
			BufferedReader br = new BufferedReader (new FileReader(input));
			String directions = br.readLine();
			System.out.println(numHouses(directions));
			System.out.println(roboHouses(directions));
			br.close();
		}
		catch (FileNotFoundException e){
			System.out.println("You done goofed, fool");
		}
	}
}