import java.util.*;
import java.io.*;

public class Day6{
	public static int numLights(String fileName){
		try{
			File file = new File(fileName);
			Scanner reading = new Scanner(file);
			int[][] lights = new int[1000][1000];
			while (reading.hasNextLine()){
				String[] line = reading.nextLine().split(" ");
				String[] start, end;
				int startr, startc, endr, endc;
				if(line[0].equals("toggle")){
					start = line[1].split(",");
					end = line[3].split(",");
				}
				else{
					start = line[2].split(",");
					end = line[4].split(",");
				}
				startr = Integer.parseInt(start[0]);
				startc = Integer.parseInt(start[1]);
				endr = Integer.parseInt(end[0]);
				endc = Integer.parseInt(end[1]);

				for (int i = startr; i <= endr; i++){
					for (int j = startc; j <= endc; j++){
						if(line[0].equals("toggle")){
							if(lights[i][j] == 0){
								lights[i][j] = 1;
							}
							else{
								lights[i][j] = 0;
							}
						}
						else{
							if(line[1].equals("on")){
								lights[i][j] = 1;
							}
							if(line[1].equals("off")){
								lights[i][j] = 0;
							}
						}
					}
				}
			}
			int num = 0;
			for (int i = 0; i < 1000; i++){
				for(int j = 0; j < 1000; j++){
					if (lights[i][j] == 1){
						num++;
					}
				}
			}
			return num;
		} catch(FileNotFoundException e){
			return -1;
		}
		
	}

	public static int bright(String fileName){
		try{
			File file = new File(fileName);
			Scanner reading = new Scanner(file);
			int[][] lights = new int[1000][1000];
			while (reading.hasNextLine()){
				String[] line = reading.nextLine().split(" ");
				String[] start, end;
				int startr, startc, endr, endc;
				if(line[0].equals("toggle")){
					start = line[1].split(",");
					end = line[3].split(",");
				}
				else{
					start = line[2].split(",");
					end = line[4].split(",");
				}
				startr = Integer.parseInt(start[0]);
				startc = Integer.parseInt(start[1]);
				endr = Integer.parseInt(end[0]);
				endc = Integer.parseInt(end[1]);

				for (int i = startr; i <= endr; i++){
					for (int j = startc; j <= endc; j++){
						if(line[0].equals("toggle")){
							lights[i][j] += 2;
						}
						else{
							if(line[1].equals("on")){
								lights[i][j] ++;
							}
							if(line[1].equals("off")){
								if(lights[i][j] > 0){
									lights[i][j]--;
								}
							}
						}
					}
				}
			}
			int num = 0;
			for (int i = 0; i < 1000; i++){
				for(int j = 0; j < 1000; j++){
					num += lights[i][j];

				}
			}
			return num;
		} catch(FileNotFoundException e){
			return -1;
		}
		
	}

	public static void main(String[] args){
		System.out.println("Salutations, globe");
		String fileName = args[0];
		System.out.println(numLights(fileName));
		System.out.println(bright(fileName));
	}
}