import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Day2{

	public static int wrapPaper (String equat){
		int indexX1, indexX2, factor1, factor2, factor3;
		indexX1 = equat.indexOf("x");
		indexX2 = equat.lastIndexOf("x");
		factor1 = Integer.parseInt(equat.substring(0, indexX1));
		factor2 = Integer.parseInt(equat.substring(indexX1 + 1, indexX2));
		factor3 = Integer.parseInt(equat.substring(indexX2 + 1));
		int[] factors = {factor1, factor2, factor3};
		Arrays.sort(factors);
		int surfaceArea = 2 * (factor1 * factor2 + factor2 * factor3 + factor3 * factor1);
		int slack = factors[0] * factors[1];
		/*
		System.out.println(factor1);
		System.out.println(factor2);
		System.out.println(factor3);
		System.out.println(surfaceArea);
		System.out.println(slack);
		*/
		return surfaceArea + slack;

	}

	public static int ribbon (String equat){
		int indexX1, indexX2, side1, side2, side3;
		indexX1 = equat.indexOf("x");
		indexX2 = equat.lastIndexOf("x");
		side1 = Integer.parseInt(equat.substring(0, indexX1));
		side2 = Integer.parseInt(equat.substring(indexX1 + 1, indexX2));
		side3 = Integer.parseInt(equat.substring(indexX2 + 1));
		int[] sides = {side1, side2, side3};
		Arrays.sort(sides);
		
		/*
		System.out.println(factor1);
		System.out.println(factor2);
		System.out.println(factor3);
		System.out.println(surfaceArea);
		System.out.println(slack);
		*/
		return 0;

	}

	public static void main (String[] args){
 		int paperSum = 0;

		try {
   			File myObj = new File("inputDay2.txt");
			Scanner myReader = new Scanner(myObj);
                	while (myReader.hasNextLine()) {	
                		String data = myReader.nextLine();
                		paperSum += wrapPaper(data);
               		 }
                myReader.close();
		}
                catch (FileNotFoundException e) {
                	System.out.println("An error occurred.");
                        e.printStackTrace();
                }
		
		System.out.println(paperSum);
		
		/*
		System.out.println(wrapPaper("2x3x4"));
		System.out.println();
		System.out.println(wrapPaper("1x1x10"));
		*/
       }
}