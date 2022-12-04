import java.util.*;
import java.io.*;

public class Day3{
	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File( "Day3.in")));
		int total = 0;
		while(reading.ready()){
			//System.out.println(reading.readLine());
			String line = reading.readLine();
			int[] appear = new int[106];
			for (int i = 0; i < line.length(); i++){
				char c = line.charAt(i);
				int index = c - 'A' + 27;
				if (c >= 97){ index = c - 'a' + 1;}
				if (i >= line.length() / 2){ index += 53;}
				appear[index] += 1;
			} 
			for( int i = 1; i < 53; i++){
				if (appear[i] > 0 && appear[i+53] > 0){
					total += i;
				}
			}
			
		}
		reading.close();
		BufferedReader reread = new BufferedReader(new FileReader(new File( "Day3.in")));
		int retotal = 0;
		while (reread.ready()){
			int[] A = new int[53];
			String line = reread.readLine();
			for (int i = 0; i < line.length(); i++){
				char c = line.charAt(i);
				int index = c - 'A' + 27;
				if (c >= 97){ index = c - 'a' + 1;}
				A[index] += 1;
			}
			int[] B = new int[53];
			line = reread.readLine();
			for (int i = 0; i < line.length(); i++){
				char c = line.charAt(i);
				int index = c - 'A' + 27;
				if (c >= 97){ index = c - 'a' + 1;}
				B[index] += 1;
			}

			int[] C = new int[53];
			line = reread.readLine();
			for (int i = 0; i < line.length(); i++){
				char c = line.charAt(i);
				int index = c - 'A' + 27;
				if (c >= 97){ index = c - 'a' + 1;}
				C[index] += 1;
			}
			for (int i = 1; i < 53; i++){
				if (A[i] > 0 && B[i] > 0 && C[i] > 0){ retotal += i;}
			}

		}
		reread.close();
		System.out.println(retotal);
	}
}