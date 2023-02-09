import java.io.*;
import java.util.*;

public class Day9{

	public static void main (String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File("Day9.in")));
		int len = 1;
		String start = "";
		while (reading.ready()){
			String[] line = reading.readLine().split(" ");
			if (start.compareTo(line[0]) != 0){
				len += 1;
				start = line[0];
			}
		}
		reading.close();
		System.out.println(len);

		int[][] distMat = new int[len][len];

		BufferedReader reread = new BufferedReader(new FileReader(new File("Day9.in")));
		for (int i = 0; i < len; i++){
			for (int j = i + 1; j < len; j++){
				String[] line = reread.readLine().split(" ");
				int distance = Integer.parseInt(line[line.length - 1]);
				distMat[i][j] = distance;
				distMat[j][i] = distance;
			}
		}
		reread.close();

		for (int[] row : distMat){
			System.out.println(Arrays.toString(row));
		}

		int[] full = new int[len];
		for (int i = 0; i < len; i++){
			full[i] = i;
		}
		
		System.out.println(holdingFish(distMat, full));
	}

	public static int holdingFish( int[][] distMat, int[] places){
		if(places.length > 2){
			int minDist = Integer.MAX_VALUE;
			for (int endpoint = 0; endpoint < places.length; endpoint ++){
				int[] subset = new int[places.length - 1];
			    // filling out the array
				for (int i = 0; i < places.length; i++){
					if (i < endpoint){
						subset[i] = places[i];
					}
					if (i > endpoint){
						subset[i - 1] = places[i];
					}
				}
				int dist = holdingFish(distMat, subset);
				dist += Math.min(distMat[subset[0]][places[endpoint]], distMat[subset[subset.length - 1]][places[endpoint]]);
				minDist = Math.min (dist, minDist);
			}
			return minDist;
		}
		else{
			return distMat[places[0]][places[1]];
		}
	}
	
}
