import java.util.*;
import java.io.*;

public class Day7{
	public static HashMap<String, Integer> bytes = new HashMap<String, Integer>();
	public static HashMap<String, String[]> tree = new HashMap<String, String[]>();

	public static void main (String[] args) throws IOException{
		//System.out.println("Hello");
		BufferedReader reading = new BufferedReader( new FileReader( new File ("Day7.in")));
		while( reading.ready()){
			String[] line = reading.readLine().split(" ");
			int len = line.length;
			String target = line[len - 1];
			String[] source;
			switch (len){
				case 3:
					source = new String[1];
					if(! isNum(line[0])){
						source[0] = line[0];
						tree.put(target, source);
					} else{
						int value = Integer.parseInt(line[0]);
						bytes.put(target, value);
					}
					break;
				case 4:
					source = new String[2];
					source[0] = line[1];
					source[1] = line[0];
					tree.put(target, source);
					break;
				case 5:
					source = new String[3];
					source[2] = line[1];
					source[0] = line[0];
					source[1] = line[2];
					tree.put(target, source);
					break;
			}
		}
		reading.close();
		System.out.println("a: " + pathing("a"));
	}

	public static boolean isNum(String word){
		boolean wordiness = true;
		for (int i = 0; i < word.length(); i++){
			wordiness = (wordiness && Character.isDigit(word.charAt(i)));
		}
		return wordiness;
	}

	public static int pathing( String wire){
		if (isNum(wire)){ return Integer.parseInt(wire);}
		if(! bytes.containsKey(wire)){
			String[] sources = tree.get(wire);
			int len = sources.length;
			switch( len){
				case 1:
					bytes.put(wire, pathing(sources[0]));
					break;
				case 2:
					int source = pathing(sources[0]);
					bytes.put(wire, ~source);
					break;
				case 3:
					int source0 = pathing(sources[0]);
					int source1 = pathing(sources[1]);
					switch (sources[2]){
						case "AND": 
							bytes.put(wire, source0 & source1);
							break;
						case "OR":
							bytes.put(wire, source0 | source1);	
							break;
						case "RSHIFT":
							bytes.put(wire, source0 >> source1);
							break;
						case "LSHIFT": 
							bytes.put(wire, source0 << source1);
							break;
					}
					break;
			}
		}
		int val = bytes.get(wire);
		if (val < 0){
			val += Math.pow(2, 16);
			bytes.put(wire, val);
		}
		return bytes.get(wire);
	}
}