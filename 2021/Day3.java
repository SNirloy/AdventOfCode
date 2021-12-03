import java.util.*;
import java.io.*;

public class Day3{
	public static int binaryRead (String bin){
		int deciNum = 0;
		for ( int i = 0; i < bin.length() - 1; i ++){
			int val = Integer.parseInt(bin.substring(i, i+1));
			if (val == 1){
				deciNum += (Math.pow (2, bin.length() - (i + 1)));
			}
		}
		deciNum += Integer.parseInt(bin.substring(bin.length() - 1));
		return deciNum;
	}
	public static int power(String fileName) {
		try{
			File file = new File(fileName);
			Scanner reading = new Scanner(file);
			int[] sums;
			int count = 1;
			String input = reading.nextLine();
			sums = new int[input.length()];
			for (int i = 0; i < sums.length; i++){
				sums[i] = Integer.parseInt(input.substring(i, i+1));
			}
			while (reading.hasNextLine()){
				input = reading.nextLine();
				for (int i = 0; i < input.length(); i++){
					sums[i] += Integer.parseInt(input.substring(i, i+1));
				}
				count++;
			}
			reading.close()
			String gamma, epsilon;
			gamma = "";
			epsilon = "";
			for (int i = 0; i < sums.length; i++){
				if (((double) sums[i])/((double)count) > 0.5){
					gamma += "1";
					epsilon += "0";
				}
				else{
					gamma += "0";
					epsilon += "1";
				}
			}
			int gammaNum = binaryRead(gamma);
			int epsilonNum = binaryRead(epsilon);
			return gammaNum * epsilonNum;
			
		}
		catch (FileNotFoundException e){
			return -1;
		}	
	}
	public static int lifeSupport(String fileName) {
		try{
			File file = new File(fileName);
			Scanner reading = new Scanner(file);
			int[] sums;
			int count = 1;
			String input = reading.nextLine();
			sums = new int[input.length()];
			for (int i = 0; i < sums.length; i++){
				sums[i] = Integer.parseInt(input.substring(i, i+1));
			}
			while (reading.hasNextLine()){
				input = reading.nextLine();
				for (int i = 0; i < input.length(); i++){
					sums[i] += Integer.parseInt(input.substring(i, i+1));
				}
				count++;
			}
			reading.close()

			for (int i = 0; i < sums.length; i++){
				if (((double) sums[i])/((double)count) > 0.5){
					gamma += "1";
					epsilon += "0";
				}
				else{
					gamma += "0";
					epsilon += "1";
				}
			}
			int gammaNum = binaryRead(gamma);
			int epsilonNum = binaryRead(epsilon);
			return gammaNum * epsilonNum;
			
		}
		catch (FileNotFoundException e){
			return -1;
		}	
	}
	public static void main(String[] args){
		//System.out.println("Salutations, globe");
		String fileName = args[0];
		System.out.println(power(fileName));
	}
}