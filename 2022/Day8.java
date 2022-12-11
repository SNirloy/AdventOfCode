import java.util.*;
import java.io.*;

public class Day8{
	public static void main (String[] args) throws IOException{
		BufferedReader reading = new BufferedReader( new FileReader(new File("Day8.in")));
		int [][] arr;
		int width = 0;
		int height = 0;
		while(reading.ready()){
			String line = reading.readLine();
			//System.out.println(Arrays.toString(line));
			width = Math.max(width, line.length());
			height ++;
		}
		reading.close();
		BufferedReader reread = new BufferedReader( new FileReader(new File("Day8.in")));
		arr = new int[height][width];
		int rcount = 0;
		while(reread.ready()){
			String[] line = reread.readLine().split("");
			for (int c = 0; c < line.length; c++){
				arr[rcount][c] = Integer.parseInt(line[c]);
			}
			rcount += 1;
		}
		reread.close();
		// for (int[] row : arr){
		//	System.out.println(Arrays.toString(row));
		// }

		boolean[][] vis = new boolean[height][width];

		for (int i = 0; i < width; i++){
			vis[0][i] = true;
			vis[height - 1][i] = true;
		}

		for (int i = 0; i < height; i++){
			vis[i][0] = true;
			vis[i][width - 1] = true;
		}

		for (int r= 1; r < height - 1; r ++){
			int maxim = arr[r][0];
			for (int c = 1; c < width - 1; c++){
				if( arr[r][c] > maxim){
					maxim = arr[r][c];
					vis[r][c] = true;
				}
			}
		}

		for (int r= 1; r < height - 1; r ++){
			int maxim = arr[r][height - 1];
			for (int c = width - 2; c > 0; c--){
				if( arr[r][c] > maxim){
					maxim = arr[r][c];
					vis[r][c] = true;
				}
			}
		}

		for (int c = 1; c < width - 1; c ++){
			int maxim = arr[0][c];
			for (int r = 1; r < height - 1; r++){
				if( arr[r][c] > maxim){
					maxim = arr[r][c];
					vis[r][c] = true;
				}
			}
		}

		for (int c = 1; c < width - 1; c ++){
			int maxim = arr[height - 1][c];
			for (int r = height - 2; r > 0; r--){
				if( arr[r][c] > maxim){
					maxim = arr[r][c];
					vis[r][c] = true;
				}
			}
		}

		int visCount = 0;
		for (boolean[] row: vis){
			// System.out.println(Arrays.toString(row));
			for (boolean tree: row){
				if (tree){visCount++;}
			}
		}
		System.out.println("Visible: " + visCount);

		int[][] scene = new int[height][width];
		
		for (int r = 1; r < height - 1; r++){
			for (int c = 1; c < width - 1; c++){
				//System.out.println(r + ", " + c);
				int sceneVal = 1;
				int factor = 0;
				for (int i = r - 1; i >= 0; i--){
					factor ++;
					if (arr[i][c] >= arr[r][c]){break;}
				}
				//System.out.println("\t" + factor);
				sceneVal *= factor;

				factor = 0;
				for (int i = r + 1; i < height; i++){
					factor ++;
					if (arr[i][c] >= arr[r][c]){break;}
				}
				//System.out.println("\t" + factor);
				sceneVal *= factor;
// heights
				factor = 0;
				for (int i = c - 1; i >= 0; i--){
					factor ++;
					if (arr[r][i] >= arr[r][c]){break;}
				}
				//System.out.println("\t" + factor);
				sceneVal *= factor;

				factor = 0;
				for (int i = c + 1; i < width; i++){
					factor ++;
					if (arr[r][i] >= arr[r][c]){break;}
				}
				//System.out.println("\t" + factor);
				sceneVal *= factor;
			
				scene[r][c] = sceneVal;
			}
		}

		int maxim = 0; 
		for (int[] row: scene){
			//System.out.println(Arrays.toString(row));
			for(int num : row){
				maxim = Math.max(maxim, num);
			}
		}
	
		System.out.println("Max Scene: " + maxim);
	}
}