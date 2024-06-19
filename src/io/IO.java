package io;

import java.util.Scanner;

/**
 * Class represents input and output of the Chess Game (Console).
 */
public class IO {
	
	//User a Scanner to take in input in the console.
	private static Scanner scan = new Scanner(System.in);
	
	public static int getInt(String prompt) {
		System.out.println(prompt);
		return scan.nextInt();
	}

}
