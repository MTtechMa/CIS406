package interestRateCalculatorPart2;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;
import java.text.NumberFormat;

public class InterestRateCalculatorPart2 
{
	static double calculateInterest(double loan, double rate) 
	{
		return loan * rate/100.0;
	}

	static double getNumData(Scanner input, String prompt) 
	{
		double newNum = 0;
		boolean validInput = false;
		
		while (!validInput) 
		{
			validInput = true; 
			try 
			{
				System.out.print(prompt);
				String inputString = input.nextLine();
				if (inputString.contains(","))
				{
					throw new InputMismatchException("");	
				}
				newNum = Double.parseDouble(inputString);
			}
			catch (Exception e)
			{
				System.out.println("Error! Invaid numeric value. Please try again. ");
				validInput = false;
			}
		}
		return newNum;
	}
	
	public static void main(String[] args) 
	{	
		System.out.println("Welcome to the Interest Calculator");
		
		Scanner input = new Scanner(System.in);
		
		Locale usa = new Locale("en", "US");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		
		char keepGoing = 'y';
		
		while (keepGoing != 'n' && keepGoing != 'N')
		{
			double loanAmount = getNumData(input, "\nEnter loan amount: ");
			
			double interestRate = getNumData(input, "\nEnter interest rate: ");
			
			double interestAmount = calculateInterest(loanAmount, interestRate);
			
			System.out.println("\nLoan Amount:\t\t" + dollarFormat.format(loanAmount));
			if ((double) (int) interestRate == interestRate  ) 
			{
				System.out.println("Interest rate:\t\t" + (int)interestRate + "%");
			}
			else 
			{
				System.out.println("Interest rate: \t\t" + interestRate + "%");
			}
			System.out.println("Interest:\t\t" + dollarFormat.format(interestAmount));
			
			System.out.print("Continue? (y/n): ");
			keepGoing = input.next().charAt(0);
			String ignore = input.nextLine();	
		}
		
		input.close();
		System.out.println("\nBye!!!");
			
	
		}
}
	
