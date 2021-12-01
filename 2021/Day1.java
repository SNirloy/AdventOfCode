import java.util.*;
import java.io.*;

public class Day1{
	public static int increases (String fileName) throws IOException {
		BufferedReader reading = new BufferedReader(new FileReader (fileName));
		int counter = 0;
		try{
			int current, next;
			current = Integer.parseInt(reading.readLine());
			while (true == true){
				//System.out.println(current);
				next = Integer.parseInt(reading.readLine());
				if (next > current){
					counter++;
				}
				current = next;
			}
		}catch (EOFException e){
			return counter;
		}
		catch (NumberFormatException ex){
			return counter;
		}
	}
	public static int sumIncreases (String fileName) throws IOException {
		BufferedReader reading = new BufferedReader(new FileReader (fileName));
		int count = 0;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		try{
			while (true == true){
				//System.out.println(current);
				nums.add(Integer.parseInt(reading.readLine()));
				if (nums.size() >= 4){
					int sum1 = nums.get(nums.size() - 2) + nums.get(nums.size() - 3) + nums.get(nums.size() - 4);
					int sum2 = nums.get(nums.size() - 1) + nums.get(nums.size() - 2) + nums.get(nums.size() - 3);
					if (sum2 > sum1){
						count++;
					}
				}
			}
		}catch (NumberFormatException ex){
			//System.out.println(nums);
			return count;
		}
	}
	public static void main(String[] args) throws IOException{
		//System.out.println("Salutations, globe");
		String fileName = args[0];
		System.out.println(increases(fileName));
		System.out.println(sumIncreases(fileName));
	}
}