import java.util.*;
import java.io.*;

public class Day1{
	public static void main (String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader( new File("Day1.in")));
		ArrayList<Long> cals = new ArrayList<Long>();
		long maxi = 0;
		long current = 0;
		while (reading.ready()){
			String line = reading.readLine();
			if (line.equals("") || line.equals("\n")){
				cals.add(current);
				maxi = Math.max(maxi, current);
				current = 0;
			}
			else{
				current += Long.parseLong(line);
			}
		}
		maxi = Math.max(maxi, current);
		reading.close();
		System.out.println(maxi);
		int len = cals.size();
		long[] arr = new long[len];
		for (int i = 0; i < len; i++){
			arr[i] = cals.get(i);
		}
		Arrays.sort(arr);
		System.out.println(arr[len -1] + arr[len -2] + arr[len- 3]);
	}
}