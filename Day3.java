import java.util.*;
import java.io.*;

public class Day3{
	public static int numHouses (String str){
		Map<String, Integer> houses = new HashMap <String, Integer> ();
		int xcoor = 0;
		int ycoor = 0;
		houses.put (("" + xcoor + "," + ycoor), 1);
		for (int i = 0; i < str.length(); i++){
			// Use if statements
			if (str.substring(i, i+1).equals("^"){
				ycoor++;
			}
			if (str.substring(i, i+1).equals("v"){
				ycoor--;
			}
			if (str.substring(i, i+1).equals(">"){
				xcoor++;
			}
			if (str.substring(i, i+1).equals("<"){
				xcoor--;
			}
		}

		return houses.size();
	}
	public static void main (String[] args){
		System.out.println("Salutations, planet!");
	}
}