//Kristen Anderson
//CIS406
//Interest Rate Calculator Lab Part 1
package interestRateCalculatorPart1;
import java.util.Scanner;
public class InterestRateCalculatorPart1 
{

	public static void main(String[] args) 
	{
		
		System.out.println("Welcome to the Interest Calculator");
		char keepGoing = 'y';
		Scanner input = new Scanner(System.in);
			
		while(keepGoing != 'n' && keepGoing != 'N') 
		{
			
			System.out.print("\nEnter loan amount:  ");
			int loanAmount = input.nextInt();
		
			System.out.print("Enter interest rate:   ");
			double interestRate = input.nextDouble();
				 
			System.out.print("\nLoan amount:\t\t" + "$" + loanAmount);
			System.out.print("\nInterest rate:\t\t" + interestRate + "%");
			System.out.print("\nInterest:\t\t" + "$" );
			System.out.println();
		}
		
		System.out.print("\nContinue? (y/n): ");
		System.out.println();
				
		keepGoing = input.next().charAt(0);
			
			
		input.close();
		System.out.print("\nBye!!");
			
		}
			

}
