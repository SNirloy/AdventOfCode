import java.util.*;
import java.io.*;

public class Day4{
	public static int firstWin (String fileName){
		String[]calls = new String[0];
		String[][][] sheets = new String[100][5][5];
		try{
			File file = new File (fileName);
			Scanner reading = new Scanner (file);
			calls = reading.nextLine().split (",");
			int x = 0;
			int y = 0;
			int z = 0;
			while (reading.hasNextInt()){
				sheets[x][y][z] = ("" + reading.nextInt());
				z++;
				if (z== 5){
					z = 0;
					y++;
				}
				if (y == 5){
					y = 0;
					x++;
				}
			}
		}
		catch (FileNotFoundException e){
			return -1;
		}
		for (int i = 0; i < calls.length; i++){
			for (int a = 0; a < sheets.length; a++){
				for (int b = 0; b < sheets[a].length; b++){
					for (int c = 0; c < sheets[a][b].length; c++){
						if (calls[i].equals(sheets[a][b][c])){
							sheets[a][b][c] = "Hit";
						}
					}
				}
				for (int x = 0; x < sheets[a].length; x++){
					boolean win = false;
					if (sheets[a][x][0].equals("Hit")){
						if (sheets[a][x][1].equals("Hit")){
							if (sheets[a][x][2].equals("Hit")){
								if (sheets[a][x][3].equals("Hit")){
									if (sheets[a][x][4].equals("Hit")){
										win = true;
										System.out.println(Arrays.toString(sheets[a][0]));
										System.out.println(Arrays.toString(sheets[a][1]));
										System.out.println(Arrays.toString(sheets[a][2]));
										System.out.println(Arrays.toString(sheets[a][3]));
										System.out.println(Arrays.toString(sheets[a][4]));
									}
								}		
							}
						}
					}
					if (sheets[a][0][x].equals("Hit")){
						if (sheets[a][1][x].equals("Hit")){
							if (sheets[a][2][x].equals("Hit")){
								if (sheets[a][3][x].equals("Hit")){
									if (sheets[a][4][x].equals("Hit")){
										win = true;
										System.out.println(Arrays.toString(sheets[a][0]));
										System.out.println(Arrays.toString(sheets[a][1]));
										System.out.println(Arrays.toString(sheets[a][2]));
										System.out.println(Arrays.toString(sheets[a][3]));
										System.out.println(Arrays.toString(sheets[a][4]));
									}
								}		
							}
						}
					}
					if(win){
						int sum = 0;
						int factor = Integer.parseInt(calls[i]);
						for (int s = 0; s < 5; s++){
							for (int t = 0; t < 5; t++){
								if (! sheets[a][s][t].equals("Hit")){
									sum += Integer.parseInt(sheets[a][s][t]);
								}
							}
						}
						return sum * factor;
					}
				}
			}
		}
		return -1;
	}

	public static int lastWin (String fileName){
		String[]calls = new String[0];
		String[][][] sheets = new String[100][5][5];
		ArrayList<Integer> score = new ArrayList<Integer>();
		try{
			File file = new File (fileName);
			Scanner reading = new Scanner (file);
			calls = reading.nextLine().split (",");
			int x = 0;
			int y = 0;
			int z = 0;
			while (reading.hasNextInt()){
				sheets[x][y][z] = ("" + reading.nextInt());
				z++;
				if (z== 5){
					z = 0;
					y++;
				}
				if (y == 5){
					y = 0;
					x++;
				}
			}
		}
		catch (FileNotFoundException e){
			return -1;
		}
		int lastWinner = 0;
		int lastWin = 0;
		for (int a = 0; a < sheets.length; a++){
			int sheetWin = calls.length - 1;
			for (int b = 0; b < sheets[a].length; b++){
				int bingoDecideH = 0;
				int bingoDecideV = 0;
				for (int c = 0; c < sheets[a][b].length; c++){	
					for (int i = 0; i < calls.length; i++){
						if (calls[i].equals(sheets[a][b][c]) && (i > bingoDecideH)){
							bingoDecideH = i;
						}
						if (calls[i].equals(sheets[a][c][b]) && (i > bingoDecideV)){
							bingoDecideV = i;
						}
					}	
				}
				int quickWin = Math.min(bingoDecideV, bingoDecideH);
				if (quickWin < sheetWin){
					sheetWin = quickWin;
				}
			}
			if (sheetWin > lastWin){
				lastWin = sheetWin;
				lastWinner = a;
			}
		}
		String[][] last = sheets[lastWinner];
		int sum = 0;
		for (int x = 0; x < last.length; x++){
			for (int y = 0; y < last[x].length; y++){
				for (int i = 0; i < calls.length; i++){
					if (calls[i].equals(last[x][y]) && (i > lastWin)){
						sum += Integer.parseInt(last[x][y]);
					}			
				}
			}
		}
		return Integer.parseInt(calls[lastWin]) * sum;
	}

	public static void main (String[] args) throws IOException{
		//System.out.println("Salutations, globe.");
		String fileName = args[0];
		System.out.println(firstWin(fileName));
		System.out.println(lastWin(fileName));
	}
}