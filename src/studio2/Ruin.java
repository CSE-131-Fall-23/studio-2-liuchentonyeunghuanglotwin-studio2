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
		int totalSimulations = in.nextInt() + 1;

		int numRuins = 0;

		// represents each day
		for(int i = 0; i < totalSimulations; i++)
		{
			double originalAmount = startAmount;
			int numPlays = 0;

			// one day worth of game 
			while(originalAmount > 0 && originalAmount < winLimit)
			{
				numPlays++;
				if(winChance > Math.random()){
					//	System.out.println("WIN!" + originalAmount);
					originalAmount++;
				}
				else {
					//	System.out.println("LOSE!" + originalAmount);
					originalAmount--;
				}
			}

			System.out.print("Simulation " + i + ": " + numPlays);
			if(originalAmount == 0) {
				numRuins++;
				System.out.println(" LOSE");
			}
			else {
				System.out.println(" WIN");
			}
		}


		System.out.println("Ruin Rate from Simulation: " + (double)numRuins / totalSimulations);
		double expectedRuin = 0;
		if (winChance == 0.5) 
		{
			expectedRuin = 1 - ((double) startAmount/winLimit);
		}
		else 
		{
			double alpha = (1.0 - winChance) / winChance;
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
		}
		System.out.println("Expected Ruin Rate: " + expectedRuin);

		System.out.println("Losses: " + numRuins + " Simulations: " + (totalSimulations - 1));
	} 
}


/*	for(int i = 0; i < totalSimulations; i++) {
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
 */
