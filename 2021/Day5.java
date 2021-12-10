import java.util.*;
import java.io.*;

public class Day5{
	public static int noDiag(String fileName) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(fileName));
		int[][] area = new int[1000][1000];
		try{
			while (true){
				String[] coors = reading.readLine().split(" -> ");
				String[] start = coors[0].split(",");
				String[] end = coors[1].split(",");
				// System.out.println(Arrays.toString(start) + " " + Arrays.toString(end));
				if (start[0].equals(end[0])){
					//System.out.println(Arrays.toString(start) + " " + Arrays.toString(end));
					int column = Integer.parseInt(start[0]);
					int starty = Integer.parseInt(start[1]);
					int endy = Integer.parseInt(end[1]);
					if (starty > endy){
						int ending = starty;
						starty = endy;
						endy = ending;
					}
					for (int i = starty; i <= endy; i++){
						area[i][column] ++;
					}
				}
				if ( start[1].equals(end[1])){
					//System.out.println(Arrays.toString(start) + " " + Arrays.toString(end));
					int row = Integer.parseInt(start[1]);
					int startx = Integer.parseInt(start[0]);
					int endx = Integer.parseInt(end[0]);
					if (startx > endx){
						int ending = startx;
						startx = endx;
						endx = ending;
					}
					for (int i = startx; i <= endx; i++){
						area[row][i] ++;
					}
				}
			}
		}
		catch (NullPointerException e){

		}
		int dangerZones = 0;
		for (int i = 0; i < area.length; i++){
			// System.out.println(Arrays.toString(area[i]));
			for (int j = 0; j < area[i].length; j++){
				if (area[i][j] > 1){
					dangerZones++;
				}
			}
		}

		return dangerZones;
	}

	public static int Diag(String fileName) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(fileName));
		int[][] area = new int[1000][1000];
		try{
			while (true){
				String[] coors = reading.readLine().split(" -> ");
				String[] start = coors[0].split(",");
				String[] end = coors[1].split(",");	
				int starty = Integer.parseInt(start[1]);
				int endy = Integer.parseInt(end[1]);
				int startx = Integer.parseInt(start[0]);
				int endx = Integer.parseInt(end[0]);

				//Putting in the vents
				if (startx == endx){
					if (starty > endy){
						for (int i = endy; i <= starty; i++){
							area[i][startx] ++;
						}					
					}else{
						for (int i = starty; i <= endy; i++){
							area[i][startx] ++;
						}
					}
				}
				else if (starty == endy){
					if (startx > endx){
						for (int i = endx; i <= startx; i++){
							area[starty][i] ++;
						}					
					}else{
						for (int i = startx; i <= endx; i++){
							area[starty][i] ++;
						}
					}
				}	
				else{
					int diff = Math.abs(endx - startx);
					if (startx > endx && starty>endy){
						for (int i = 0; i <= diff; i++){
							area[starty - i][startx - i]++;
						}
					}
					else if (startx > endx && starty < endy){
						for (int i = 0; i <= diff; i++){
							area[starty + i][startx - i]++;
						}
					}
					else if (startx < endx && starty > endy){
						for (int i = 0; i <= diff; i++){
							area[starty - i][startx + i]++;
						}
					}
					else{
						for (int i = 0; i <= diff; i++){
							area[starty + i][startx + i]++;
						}
					}
				}
			}
		}
		catch (NullPointerException e){

		}
		int dangerZones = 0;
		for (int i = 0; i < area.length; i++){
			//System.out.println(Arrays.toString(area[i]));
			for (int j = 0; j < area[i].length; j++){
				if (area[i][j] > 1){
					dangerZones++;
				}
			}
		}
		return dangerZones;
	}

	public static void main(String[] args) throws IOException{
		//System.out.println("Salutations, globe.");
		String fileName = args[0];
		System.out.println(noDiag(fileName));
		System.out.println(Diag(fileName));
	}
}