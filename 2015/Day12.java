import java.io.*;
import java.util.*;

public class Day12{
	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader( new File( "Day12.json")));
		long sum = 0;
		while (reading.ready()){
			String line = reading.readLine();
			String num = "";
			boolean negative = false;
			for (int i = 0; i < line.length(); i++){
				char c = line.charAt(i);
				if (c >= 48 && c <= 57){
					num += c;
				}
				else{
					if (num.length() > 0){
						int trueNum = Integer.parseInt(num);
						if (negative){trueNum *= -1;}
						sum += trueNum;
						System.out.println(trueNum);
					}
					num = "";
					negative = false;
				}	
				if (c == 45){ negative = true;}			
			}
		}
		reading.close();
		System.out.println(sum);
	}
}