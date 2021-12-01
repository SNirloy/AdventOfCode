import java.util.*;
import java.io.*;

public class Day1{
	public static int increases (String fileName) throws IOException {
		BufferedReader reading = new BufferedReader(new FileReader (fileName));
		int counter = 0;
		try{
			int current, next;
			current = Integer.parseInt(reading.readLine());
			while (true == true){
				//System.out.println(current);
				next = Integer.parseInt(reading.readLine());
				if (next > current){
					counter++;
				}
				current = next;
			}
		}catch (EOFException e){
			return counter;
		}
		catch (NumberFormatException ex){
			return counter;
		}
	}
	public static void main(String[] args) throws IOException{
		//System.out.println("Salutations, globe");
		String fileName = args[0];
		System.out.println(increases(fileName));
	}
}