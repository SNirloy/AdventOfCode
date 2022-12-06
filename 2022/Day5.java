import java.io.*;
import java.util.*;

public class Day5{
	public static void main(String[] args) throws IOException{
		BufferedReader reading = new BufferedReader(new FileReader(new File("Day5.in")));
		boolean stack = true;
		int stacks = 0;
		int depth = 0;
		while (stack){
			String line = reading.readLine();
			if (line.equals("")){
				stack = false;
			}
			else{
				int temp = 0;
				for (int i = 0; i < line.length() - 2; i++){
					if (line.charAt(i) == '[' && line.charAt(i + 2) == ']'){
						temp += 1;
					}
				}
				stacks = Math.max(stacks, temp);
				depth += 1;
			}
		}
		System.out.println(stacks);
		reading.close();
		BufferedReader reread = new BufferedReader(new FileReader(new File("Day5.in")));
		char[][] wackStack= new char[depth - 1][stacks];
		stack = true;
		int height = 0;
		while(stack){
			String line = reread.readLine();
			if (line.equals("")){
				stack = false;
			}
			else{
				int col = 0; 
				for (int i = 0; i < line.length(); i++){
					if (i % 4 == 1 && height < depth - 1){
						wackStack[height][col] = line.charAt(i);
						col += 1;	
					}
				}
				height += 1;
			}
		}
		ArrayList<ArrayDeque<Character>>stackage = new ArrayList<ArrayDeque<Character>>();
		for (int i = 0; i < stacks; i++){
			ArrayDeque<Character> putin = new ArrayDeque<Character>();
			for (int j = depth - 2; j >= 0; j --){
				if (wackStack[j][i] != ' '){
					putin.addFirst(wackStack[j][i]);
				}
			}
			stackage.add(putin);
		}

		String[] wackerStacker = new String[wackStack[0].length];
		for (int col = 0; col < wackStack[0].length; col++){
			String strstack = "";
			for (int row = 0; row < wackStack.length; row++){
				if (wackStack[row][col] != ' '){
					strstack += wackStack[row][col];
				}
			}
			wackerStacker[col] = strstack;
		}

		while(reread.ready()){
			String[] line = reread.readLine().split(" ");
			int amount = Integer.parseInt(line[1]);
			int src = Integer.parseInt(line[3]) - 1;
			int trgt = Integer.parseInt(line[5]) - 1;
			ArrayDeque<Character> source = stackage.get(Integer.parseInt(line[3]) - 1);
			ArrayDeque<Character> target = stackage.get(Integer.parseInt(line[5]) - 1);
			for (int i = 0; i < amount; i++){
				char moving = source.removeFirst();
				target.addFirst(moving);
			}
			wackerStacker[trgt] = wackerStacker[src].substring(0, amount) + wackerStacker[trgt];
			wackerStacker[src] = wackerStacker[src].substring(amount);
			
		}
		reread.close();
		String ans = "";
		for (int i = 0; i < stacks; i++){
			ans += stackage.get(i).getFirst();
		}
		System.out.println(ans);
		
		System.out.println(Arrays.toString(wackerStacker));
	}
}