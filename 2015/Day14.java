import java.util.*;
import java.io.*;

public class Day14{
	public static void main(String[] args)throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader (new File("Day14.in")));
		ArrayList<int[]> deerInfo = new ArrayList<int[]>();
		while (reading.ready()){
			int[] info = new int[3];
			String[] line = reading.readLine().split(" ");
			info[0] = Integer.parseInt(line[3]);
			info[1] = Integer.parseInt(line[6]);
			info[2] = Integer.parseInt(line[13]);
			deerInfo.add(info);
		}
		reading.close();

		int maxDist = 0;
		int totalTime = 2503;

		for (int[] deer: deerInfo){
			// System.out.println(Arrays.toString(deer));
			int cycle = deer[1] + deer[2];
			int reps = totalTime / cycle;
			int dist = deer[0] * reps * deer[1];
			int left = totalTime % cycle;
			if (left > deer[1]){ dist += deer[0] * deer[1];}
			else{ dist += deer[0] * left;}
			maxDist = Math.max(dist, maxDist);
		}
		System.out.println(maxDist);
	}
}