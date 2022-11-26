import java.util.*;
import java.io.*;

public class Day8{
	public static void main( String[] args) throws IOException{
		System.out.println("Hello dummi");
		BufferedReader reading = new BufferedReader(new FileReader( new File( "Day8.in")));
		int txtLen = 0;
		int trueLen = 0;
		int codedLen = 0;
		while (reading.ready()){
			String line = reading.readLine();
			txtLen += line.length();
			trueLen += line.length();
			codedLen += line.length();
			for (int i = 0; i < line.length(); i++){
				char posit = line.charAt(i);
				if (posit == '"'){trueLen -= 1;}
				if (posit == '\\'){
					char next = line.charAt(i+1);
					if (next == '"' || next == '\\'){
						trueLen -= 1;
						i += 1;
					}
					if (next == 'x'){
						trueLen -= 3;
						i += 3;
					}
				}
			}
			for (int i = 0; i < line.length(); i++){
				char posit = line.charAt(i);
				if (posit == '"'){ codedLen += 1;}
				if (posit == '\\'){codedLen += 1;}
			}
			codedLen += 2;
		}
		reading.close();
		System.out.println(txtLen - trueLen);
		System.out.println(codedLen - txtLen);
	}
}