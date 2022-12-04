import java.util.*;
import java.io.*;

public class Day4{
	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader( new FileReader(new File( "Day4.in")));
		int total = 0;
		int otherTotal = 0;
		while(reading.ready()){
			String[] line = reading.readLine().split(",");
			String[] coors = new String[line.length * 2];
			for (int i = 0; i < line.length; i++){
				String[] thing = line[i].split("-");
				for (int j = 0; j < thing.length; j++){
					coors[i * line.length + j] = thing[j];
				}
			}
			int[] clean = new int[coors.length];
			for (int i = 0; i < coors.length; i++){
				clean[i] = Integer.parseInt(coors[i]);
			}
			if ((clean[0] <= clean[2] && clean[1] >= clean[3]) || (clean[0] >= clean[2] && clean[1] <= clean[3])){
				total += 1;
			}
			if ((clean[0] >= clean[2] && clean[0] <= clean[3]) || (clean[1] >= clean[2] && clean[1] <= clean[3]) || (clean[2] >= clean[0] && clean[2] <= clean[1]) || (clean[3] >= clean[0] && clean[3] <= clean[1])){
				otherTotal += 1;
			}
		}
		System.out.println(total);
		System.out.println(otherTotal);
	}
}