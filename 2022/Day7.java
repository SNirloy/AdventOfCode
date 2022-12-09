import java.util.*;
import java.io.*;

public class Day7{
	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File("Day7.in")));
		Fileish current = new Fileish("/", null);
		while (reading.ready()){
			String[] line = reading.readLine().split(" ");
			//System.out.println("Line: " + Arrays.toString(line));
			switch (line[1]){
				case "ls":
					break;
				case "cd":
					switch (line[2]){
						case "/": 
							while ((! current.name.equals("/")) && (current.parent == null)){
								current = current.parent;
							}
							break;
						case "..":
							current = current.parent;
							break;
						default:
							boolean inside = false;
							for (Fileish x : current.storage.keySet()){
								if (x.name.equals(line[2])){
									inside = true;
									current = x;
								}
							}
							if ( ! inside){
								Fileish child = new Fileish(line[2], current);
								current.storage.put(child, child.size);
							}
							break;
					}
					break;
				default: 
					switch (line[0]){
							case "dir":
								Fileish child = new Fileish(line[1], current);
								current.storage.put(child, child.size);
								break;
							default: 
								int size = Integer.parseInt(line[0]);
								Fileish child1 = new Fileish(line[1], current, size);
								current.storage.put(child1, child1.size);
								break;
					}
					break;
			}			
		}
		while(current.parent != null){current = current.parent;}
		//current.printMap(0);
		current.fillIn();
		//current.printMap(0);
		System.out.println(current.sumLess());
		System.out.println(30000000 - (70000000- current.size));
		System.out.println(current.maxLess(30000000 - (70000000- current.size)));
	}
}

