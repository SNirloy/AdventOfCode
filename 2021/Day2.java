import java.util.*;
import java.io.*;

public class Day2{
	public static int dTimesH (String fileName) throws IOException{
		BufferedReader reading = new BufferedReader (new FileReader (fileName));
		int depth, hPos;
		hPos = 0;
		depth = 0;
		try{
			while (true){
				String[] command = reading.readLine().split(" ");
				int value = Integer.parseInt(command[1]);
				switch (command[0]){
					case "forward":
						hPos += value;
						break;

					case "down":
						depth += value;
						break;

					case "up":
						depth -= value;
						break;
				}
			}
		}
		catch (NullPointerException e){
			reading.close();
			return hPos * depth;
		}
	}
	public static void main(String[] args) throws IOException{
		//System.out.println("Salutations, globe");
		String fileName = args[0];
		System.out.println (dTimesH(fileName));
	}
}