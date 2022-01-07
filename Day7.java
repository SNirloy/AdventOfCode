import java.util.*;
import java.io.*;

public class Day7{
	public static String toBinary(String num){
		int deci = Integer.parseInt(num);
		String inBin = "";
		for (int i = (int)(Math.log(deci)/Math.log(2)); i > 0; i--){
			if (Math.pow(2, i) <= deci){
				inBin += "1";
				deci -= Math.pow(2, i);
			}
			else{
				inBin += "0";
			}
		}
		inBin += ("" + deci);
		return inBin;
	}

	public static int toDecimal(String bin){
		int num = 0;
		for (int i = 1; i <= bin.length(); i++){
			int place = bin.length() - i;
			String digit = bin.substring( place, place + 1);
			if (digit.equals("1")){
				num += Math.pow(2, (i - 1));
			}
		}
		return num;
	}
	public static void main(String[] args){
		//System.out.println("Nebuchadnezzer");

	// Testing toBinary
		System.out.println(toBinary("357"));
		System.out.println(toBinary("8"));
		for (int i = 0; i < 16; i++){
			String test = ""+i;
			System.out.print(toBinary(test) + "->");
			System.out.println(toDecimal(toBinary(test)));
		}
	}		
}