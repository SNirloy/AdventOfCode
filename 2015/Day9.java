import java.io.*;
import java.util.*;
import java.lang.Thread;

public class Day9{

	public static void main (String[] args) throws IOException, InterruptedException{
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

		int[] choices = new int[distMat.length];
		for (int i = 0; i < choices.length; i++){
			choices[i] = i;
		}
		
		ArrayList<int[]> perms = permutations(new int[distMat.length], choices, 0, new ArrayList<int[]>());
		System.out.println(perms.size());


		int minDist = Integer.MAX_VALUE;
		for (int[] perm : perms){
			int someDist = 0;
			for (int i = 0; i < perm.length - 1; i ++){
				someDist += distMat[perm[i]][perm[i+1]];
			}
			// System.out.println("Some Dist: " + someDist);
			minDist = Math.min(someDist, minDist);
		}	
		System.out.println(minDist);

	}

	public static ArrayList<int[]> combinations (int[] choices, int[] holding, int index, ArrayList<int[]> ultracombo){
		for (int i = 0; i < choices.length; i++){
			holding[index] = choices[i];
			if (index == holding.length - 1){
				int[] copy = new int[holding.length];
				for (int j = 0; j < holding.length; j++){
					copy[j] = holding[j];
				}
				ultracombo.add(copy);
			}
			else{
				int[] newChoices = new int[choices.length - i - 1 ];
				for (int j = i + 1; j < choices.length; j++){
					newChoices[j - i - 1] = choices[j];
				}
				combinations(newChoices, holding, index + 1, ultracombo);
			}
		}
		return ultracombo;
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
