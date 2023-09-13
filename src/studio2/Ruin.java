package studio2;
import java.util.Scanner;
import java.util.Random;
public class Ruin {
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What's your start amount? ");
		double startAmount = in.nextDouble();
		System.out.println("What's your win chance? ");
		double winChance = in.nextDouble();
		System.out.println("What's your win limit amount? ");
		double winLimit = in.nextDouble();
		System.out.println("How many times do you want to play? ");
		int totalSimulations = in.nextInt();
		double originalAmount = startAmount;
		
			for(int i = 0; i < totalSimulations; i++) {
				startAmount = originalAmount;
				while(startAmount > 0 && startAmount < winLimit){
					if(winChance < Math.random()){ 
						startAmount--;
						System.out.println("LOSE!");
					}
					
					else
					{
						startAmount++;
						System.out.println("WIN!");
					}	
				}
				System.out.println("Simulation: " + i + " " + startAmount);
			}
	}
}
