package com.supre.Task1_NumberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int userScore = 0;
		
		System.out.println("\t\t\t\t********NUMBER GAME********");
		System.out.print("Enter the No. of Rounds willing to play: ");
		int no_Of_Rounds = Integer.parseInt(scan.nextLine());
		
		System.out.println("GAME STARTS");
		for(int i=1;i<=no_Of_Rounds;i++)
		{
			System.out.println("\nRound - " + i + " starts");
			System.out.print("Guess the Number between 1 - 100: ");
			int computerNumber = new Random().nextInt(100);
			int attempts = 1;
			while(attempts < 11)
			{
				int guessNumber = Integer.parseInt(scan.nextLine());
				if(guessNumber == computerNumber)
				{
					System.out.println("Congrats!!!.. You won this Round " + i + "\n");
					userScore++;
					break;
				}
				else 
				{
					System.out.println((guessNumber < computerNumber) ? "Guessed Number is too low... " : "Guessed Number is too high...");
					if((10 - attempts) > 0)
						System.out.print("Attempts left are " + (10 - attempts) + " Try again: ");
				}
				attempts++;
			}
			if(attempts == 11)
			{
				System.err.println("\nSorry You have lost this Round "+ i);
				System.out.println("Correct Answer for This Round is: "+computerNumber);
			}
			
		}
		
		if(userScore == no_Of_Rounds) 
		{
			System.out.println("Hurray!!! Whitewash...");
			System.out.println("Your Score: "+userScore);
		}
		else
		{
			System.out.println("Game Over");
			System.out.println("Your Score: "+userScore);
		}
		
		scan.close();
	}

}
