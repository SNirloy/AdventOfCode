import java.util.*;
import java.io.*;

public class Day1{


	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader( new FileReader( new File("Day1.in")));
		int sum = 0;
		while(reading.ready()){
			String line = reading.readLine();
			int num1 = -1;
			int num2 = -1;
			for (int i = 0; i < line.length(); i++){
				char ind = line.charAt(i);
				if (ind >= 48 && ind <= 57){
					if (num1 == -1){
						num1 = ind - 48;
					}
					else{
						num2 = ind - 48;
					}
				}		
			}
			if (num2 == -1){
				num2 = num1;
			}
			sum += num1* 10 + num2;
		}
		reading.close();
		System.out.println(sum);
	}

}