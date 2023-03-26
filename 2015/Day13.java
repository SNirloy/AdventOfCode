import java.io.*;
import java.util.*;

public class Day13{
	public static void main (String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File("Day13.in")));
		String[] line = reading.readLine().split(" ");
		int count = 2;
		while (reading.ready()){
			String[] newLine = reading.readLine().split(" ");
			if (newLine[0].equals(line[0])){
				count += 1;
			}
		}	
		reading.close();
		int[][] distMat = new int[count][count];
		BufferedReader reread = new BufferedReader(new FileReader(new File( "Day13.in")));
		for (int r = 0; r < count; r++){
			for (int c = 0; c < count; c++){
				if (r == c){distMat[r][c] = 0;}
				else{
					String[] info = reread.readLine().split(" ");
					int val = Integer.parseInt(info[3]);
					if (info[2].equals("lose")){
						val *= -1;
					}
					distMat[r][c] = val;
				}
			}
		}
		reread.close();
		for (int[] row : distMat){
			for (int i : row){
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		int[] source = new int[distMat.length];
		for (int i = 0; i < source.length; i++){
			source[i] = i;
		}

		for (int r = 0; r < distMat.length; r++){
			for (int c = r; c < distMat.length; c++){
				int net = distMat[r][c] + distMat[c][r];
				distMat[r][c] = net;
				distMat[c][r] = net;
			}
		}
		System.out.println();
		for (int[] row : distMat){
			for (int i : row){
				System.out.print(i + "\t");
			}
			System.out.println();
		}


		ArrayList<int[]> possible = permutations(new int[distMat.length], source, 0, new ArrayList<int[]>());
		int maxHap = Integer.MIN_VALUE;
		for (int[] may : possible){
			// System.out.print(Arrays.toString(may) + ": ");
			int setHap = 0;
			for (int i = 1; i < may.length; i++){
				setHap += distMat[may[i]][may[i-1]];
			}
			setHap += distMat[may[0]][may[may.length -1]];
			maxHap = Math.max(maxHap, setHap);
			// System.out.println(setHap);
		}

		System.out.println(maxHap);

		int[][] plus1 = new int[distMat.length + 1][distMat.length + 1];
		for (int r = 0; r < distMat.length; r++){
			for (int c = 0; c < distMat.length; c++){
				plus1[r][c] = distMat[r][c];
			}
		}
		int[] source1 = new int[plus1.length];
		for (int i = 0; i < source1.length; i++){
			source1[i] = i;
		}
		ArrayList<int[]> possibles= permutations(new int[plus1.length], source1, 0, new ArrayList<int[]>());
		int maxHaps = Integer.MIN_VALUE;
		for (int[] may : possibles){
			
			int setHap = 0;
			for (int i = 1; i < may.length; i++){
				setHap += plus1[may[i]][may[i-1]];
			}
			setHap += plus1[may[0]][may[may.length -1]];
			maxHaps = Math.max(maxHaps, setHap);
			// System.out.println(setHap);
		}
		System.out.println(maxHaps);

		
	}

	public static ArrayList<int[]> permutations (int[] working, int[] source, int index, ArrayList<int[]> store){
		for (int i = 0; i < source.length; i++){
			working[index] = source[i];
			int[] newSource = new int[source.length - 1];
			if (newSource.length == 0){
				int[] copy = new int[working.length];
				for (int k = 0; k < copy.length; k++){
					copy[k] = working[k];
				}
				store.add(copy);
			}
			else{
				for (int j = 0; j < source.length; j++){
					if (j < i){newSource[j] = source[j];}
					if (j > i){newSource[j - 1] = source[j];}
				}
				permutations(working, newSource, index + 1, store);
			}
		}
		return store;
	}

}