import java.util.*;
import java.io.*;

public class Day11{
	public static void main(String [] args) throws IOException{
		BufferedReader reading = new BufferedReader(new InputStreamReader(System.in));
		String prevCode = reading.readLine();
		reading.close();
		char[] password = new char[prevCode.length()];
		for (int i = 0; i < password.length; i++){
			password[i] = prevCode.charAt(i);
		}
		System.out.println(Arrays.toString(password));
	// Uncomment for part 2 
		// password = incToWord(password);
		boolean good = wordCheck(password);
		while (! good){
			password = incToWord(password);
			good = wordCheck(password);
		}

		System.out.println(Arrays.toString(password) + "\t->\t" + good);
	}

	public static char[] incToWord (char[] source){
		boolean done = false;
		int index = source.length - 1;
		while( ! done){
			source[index] += 1;
			if (source[index] == 'i' || source[index] == 'l' || source[index] == 'o'){
				source[index] += 1;
			}
			if (source[index] > 'z'){
				source[index] = 'a';
				index -= 1;
			}
			else{
				done = true;
			}
		}
		return source;
	}

	public static boolean wordCheck (char[] source){
		int doblCount = 0;
		boolean ladder = false;
		for (int i = 1; i < source.length; i++){
			if (source[i] == source[i - 1]){
				doblCount += 1;
				i += 1;
			}
		}
		for (int i = 2; i < source.length; i++){
			if (source[i -2] + 1 == source[i - 1] && source[i] == source[i - 1] + 1){
				ladder = true;
			}
		}
		return ladder && (doblCount >= 2);
	}
}