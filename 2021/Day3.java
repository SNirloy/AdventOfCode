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
			reading.close();
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
			Scanner bit = new Scanner(file);
			String glimpse, oxy, CO2;
			glimpse = bit.nextLine();
			bit.close();
			oxy = "";
			CO2 = "";


			for (int i = 0; i < glimpse.length(); i++){
				int oSum = 0;
				int oCount = 0;
				int cSum = 0;
				int cCount = 0;
				Scanner reading = new Scanner(file);
				while (reading.hasNextLine()){
					String input = reading.nextLine();
					if (input.indexOf(oxy) == 0){
						oSum += Integer.parseInt(input.substring(i, i+1));
						oCount++;
					}
					if (input.indexOf(CO2) == 0){
						cSum += Integer.parseInt(input.substring(i, i+1));
						cCount++;
					}
				}
				reading.close();
				double oAvg = (double)oSum / (double)oCount;	
				if (oAvg == 1){
					oxy += "1";
				}
				else if (oAvg == 0){
					oxy += "0";
				}	
				else if (oAvg < 0.5){
					oxy += "0";
				}
				else{
					oxy+= "1";
				}
				double cAvg = (double)cSum / (double)cCount;
				if (cAvg == 1){
					CO2 += "1";
				}
				else if (cAvg == 0){
					CO2 += "0";
				}
				else if (cAvg < 0.5){
					CO2 += "1";
				}
				else{
					CO2 += "0";
				}
			}
			System.out.println(oxy + ", " + CO2);
			return binaryRead(oxy) * binaryRead(CO2);
			
		}
		catch (FileNotFoundException e){
			return -1;
		}	
	}
	public static void main(String[] args){
		//System.out.println("Salutations, globe");
		String fileName = args[0];
		System.out.println(power(fileName));
		System.out.println(lifeSupport(fileName));
	}
}