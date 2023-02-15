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

		int[] choices = new int[distMat.length];
		for (int i = 0; i < choices.length; i++){
			choices[i] = i;
		}
	
		System.out.println("Choices: " + Arrays.toString(choices));

/*
		ArrayList<int[]> singles = combinations(choices, new int[1], 0, new ArrayList<int[]>());

		System.out.println("Combinations of 1");
		for (int[] arr : singles){
			System.out.println("\t" + Arrays.toString(arr));
		}


		ArrayList<int[]> pairs = combinations(choices, new int[2], 0, new ArrayList<int[]>());

		System.out.println("Combinations of 2");
		for (int[] arr : pairs){
			System.out.println("\t" + Arrays.toString(arr));
		}

		ArrayList<int[]> triples = combinations(choices, new int[3], 0, new ArrayList<int[]>());

		System.out.println("Combinations of 3");
		for (int[] arr : triples){
			System.out.println("\t" + Arrays.toString(arr));
		}
*/

	}

	public static ArrayList<int[]> combinations (int[] choices, int[] holding, int index, ArrayList<int[]> ultracombo){
		for (int i = 0; i < choices.length; i++){

	/*
			System.out.println("i to index: " + i + ", " + index);
			System.out.println("Choices: " + Arrays.toString(choices));
			System.out.println("Holding: " + Arrays.toString(holding));
			System.out.println("Combos: ");
			for (int[] arr: ultracombo){System.out.println("\t" + Arrays.toString(arr));}
			System.out.println();

	*/
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
}
