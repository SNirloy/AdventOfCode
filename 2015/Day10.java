import java.util.*;
import java.io.*;

public class Day10{ // 27

	static int[][] elemTrans = new int[92][];
	static int[] elemLen = new int[92];

	public static void main (String[] args) throws IOException{
	  /*
		BufferedReader reading = new BufferedReader(new InputStreamReader(System.in));
		String input = reading.readLine();
		reading.close();
	  */

		BufferedReader someRead = new BufferedReader(new FileReader( new File ("Conway92Elements.txt")));
		for (int i = 0; i < 92; i ++){
			String[] line = someRead.readLine().split(",");
			elemLen[i] = Integer.parseInt(line[0]);
			String[] changes = line[1].split(" ");
			elemTrans[i] = new int[changes.length];
			for (int j = 0; j < changes.length; j++){
				elemTrans[i][j] = Integer.parseInt(changes[j]);
			}
			
		}
		someRead.close();
		for (int i = 0; i < elemLen.length; i++){
			System.out.print("Element " + i + ": ");
			System.out.print("\t Length: " + elemLen[i]);
			System.out.println("\tTo: " + Arrays.toString(elemTrans[i]));
		}

		ArrayList<Integer> thing = new ArrayList<Integer>();
		thing.add(27);

		for (int i = 0; i < 50; i++){
			thing = elementProcess(thing);
		}
		int size = 0;
		for (Integer element : thing){
			size += elemLen[element];
		}
		System.out.println("Size: " + size);
	}
	
	public static String process (String input){
		char num = input.charAt(0);
		int count = 0;
		String result = "";
		for (int i = 0; i < input.length(); i ++){
			if (num == input.charAt(i)){ count += 1;}
			else {
				result += count;
				result += num;
				num = input.charAt(i);
				count = 1;
			}
		}
		result += count; 
		result += num;
		return result;
	}

	public static ArrayList<Integer> elementProcess (ArrayList<Integer> source){
		ArrayList<Integer> nextStep = new ArrayList<Integer>();
		for(Integer num : source){
			for (int element: elemTrans[num]){
				nextStep.add(element);
			}
		}
		return nextStep;
	}
}