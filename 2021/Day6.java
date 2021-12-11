import java.util.*;
import java.io.*;

public class Day6{
	public static int days80(String fileName) throws IOException{
		ArrayList<Integer> fishies = new ArrayList<Integer> ();
		BufferedReader reading = new BufferedReader (new FileReader (fileName));
		String[] starter = reading.readLine().split(",");
		reading.close();
		for (int i = 0; i < starter.length; i++){
			fishies.add(Integer.parseInt(starter[i]));
		}
		int days = 80;
		for (int i = 0; i < days; i++){
			int size = fishies.size();
			for (int j = 0; j < size; j++){
				int fish = fishies.get(j);
				fish-= 1;
				if (fish == -1){
					fishies.add(8);
					fish = 6;
				}
				fishies.set(j, fish);
			}
			size = fishies.size();
		}
		return fishies.size();
	}

	public static long tooManyDays(String fileName) throws IOException{
		long[] fishies = new long[9];
		BufferedReader reading = new BufferedReader (new FileReader (fileName));
		String[] starter = reading.readLine().split(",");
		reading.close();
		for (int i = 0; i < starter.length; i++){
			int age = Integer.parseInt(starter[i]);
			fishies[age]++;
		}
		int days = 256;
		//System.out.println(Arrays.toString(fishies));
		for (int i = 0; i < days; i++){
			long birthing = fishies[0];
			for (int j = 0; j < fishies.length - 1; j++){
				fishies[j] = fishies[j+1];
			}
			fishies[8] = birthing;
			fishies[6] += birthing;
			//System.out.println(Arrays.toString(fishies));
		}
		long sum = 0;
		for (int i = 0; i < fishies.length; i++){
			sum += fishies[i];
		}
		return sum;
	}
	public static void main(String[] args) throws IOException{
		System.out.println("Salutations, globe");
		String fileName = args[0];
		System.out.println(days80(fileName));
		System.out.println(tooManyDays(fileName));
	}
}