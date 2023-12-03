import java.util.*;
import java.io.*;

public class Day2{

/*
	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File("Day2.in")));
		int sum = 0;
		while(reading.ready()){
			boolean possible = true;
			String line = reading.readLine();
			String goodLine = "";
			for (int i = 0; i < line.length(); i++){
				if (line.charAt(i) == ';' || line.charAt(i) == ',' || line.charAt(i) == ':'){}
				else{
					goodLine += line.charAt(i);
				}
			}
			//System.out.println(goodLine);
			String[] vals = goodLine.split(" ");
			for (int i = 2; i < vals.length; i+=2){
				int num = Integer.parseInt(vals[i]);
				if (vals[i+1].equals("blue")){
					possible = possible && num <= 14;
				}
				if (vals[i+1].equals("red")){
					possible = possible && num <= 12;
				}
				if (vals[i+1].equals("green")){
					possible = possible && num <= 13;
				}
			}
			if (possible){
				sum += Integer.parseInt(vals[1]);
			}
		}
		reading.close();
		System.out.println(sum);
	}
*/

	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File("Day2.in")));
		long sum = 0;
		while(reading.ready()){

			HashMap<String, Integer> cubes = new HashMap<String, Integer>();
			cubes.put("red", 0);
			cubes.put("blue", 0);
			cubes.put("green", 0);

			String line = reading.readLine();
			String[] game = line.split(": ");
			String[] rounds = game[1].split("; ");
			for (String round : rounds){
				String[] pulls = round.split(", ");
				for (String pull: pulls){
					String[] vals = pull.split(" ");
					int num = Integer.parseInt(vals[0]);
					cubes.put(vals[1], Math.max(num, cubes.get(vals[1])));
				}
			}
			sum += cubes.get("red") * cubes.get("blue") * cubes.get("green");
		}
		reading.close();
		System.out.println(sum);
	}
}