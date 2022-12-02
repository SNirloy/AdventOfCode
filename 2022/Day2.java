   import java.util.*;
import java.io.*;

public class Day2{
	public static void main (String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader( new File("Day2.in")));
		int total = 0;
		while(reading.ready()){
			String line = reading.readLine();
			int their = line.charAt(0) - 'A';
			int us = line.charAt(2) - 'X';
			if ((their + 1) % 3 == us){ total += (us + 1 + 6);}
			else if (their == us){ total += (us + 1 + 3);}
			else{ total += (us + 1);}
		}
		reading.close();
		System.out.println(total);

		BufferedReader reread = new BufferedReader(new FileReader( new File("Day2.in")));
		int retotal = 0;
		while( reread.ready()){
			String line = reread.readLine();
			int their = line.charAt(0) - 'A';
			char strat = line.charAt(2);
			switch (strat){
				case 'X': 
					retotal += (their + 2) % 3 + 1;
					break;
				case 'Y': 
					retotal += their + 1 + 3;
					break;
				case 'Z': 
					retotal += (their + 1) % 3 + 1 + 6;
					break;
			}
		}	
		reread.close();
		System.out.println(retotal);	
	}

}