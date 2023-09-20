package studio2;

import java.util.Scanner;

public class Pi {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many darts would you like to throw?");
		int darts = in.nextInt();
		
		for(int i = 0; i < darts; i++) {
			double x = Math.random();
			double y = Math.random();
		}
	}

}
