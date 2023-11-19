//Kristen Anderson 
//CIS406
//Order EntryPhase 3 Lab

package orderEntryPhase3;
import java.util.Scanner;
import java.util.InputMismatchException;
public class OrderEntryPhase3 {
	
	

	public static void main(String[] args) {
		String itemNumber = ".";
		String itemDescription = (".");
		double itemPrice = 0.00;
		int quantity = 0;
		double grossAmount;
		double taxPercentage = 0.0;
		double taxAmount = 0.0;
		double discountPercent = 0.0;
		double discountAmount = 0.0;
		double netAmount = 0.0;
		char addItems = 'y';
		String userResponse;
		
		
		Scanner input = new Scanner(System.in);
		
		while (addItems != 'n' && addItems != 'N') 
			{
		
			try {
				System.out.print("Enter item number: ");
				itemNumber = input.nextLine();
		
				System.out.print("Enter item description: ");
				itemDescription = input.nextLine();
		
				System.out.print("Enter the item price: ");
				itemPrice = input.nextDouble();
		
				System.out.print("Enter quantity ordered: 	");
				quantity = input.nextInt();
		
				System.out.print("Enter the tax pecentage for the item: ");
				taxPercentage = input.nextDouble();
		
				System.out.print("Enter the discount percent of the item: ");
				discountPercent = input.nextDouble();
			
			}
			catch (InputMismatchException e) {
				
				System.out.print("Input format error!");
				e.printStackTrace();
				}
			catch (Exception e) {
				System.out.println("Error! contact administrator!: ");
				}
		
		
				grossAmount = itemPrice * quantity;
				taxAmount = grossAmount * taxPercentage / 100.0;
				grossAmount += taxAmount;
				discountAmount = grossAmount * discountPercent / 100.0;
				netAmount = grossAmount - discountAmount;
		
				System.out.println("Item Number\t" +
						    "Item Description\t" +
					  "Item Price\t" +
						  "Quantity\t" +
						  "Tax %\t" + "\t" + 
						  "Tax Amt\t" + 
						  "Discount Ammt\t" +
						  "Net Amt");
		
				System.out.println(itemNumber + "\t" + "\t" + 
						   itemDescription + "\t" + "\t" +
						   itemPrice + "\t" + "\t" + 
						   quantity + "\t" + "\t" + 
						   taxPercentage + "\t" + "\t" + 
						   "$" + taxAmount + "\t" + "\t" + "\t" + 
						   discountPercent + "\t" + "\t" + "\t" +
						   "$" + discountAmount + "\t" + "\t" + "\t" +
						   "$" + netAmount + "\t");
			
				System.out.print("\nEnter More Items? (y/n): ");
				addItems = input.next().charAt(0);
				userResponse = input.nextLine();
				
		}
		input.close();				
						  	 

	}

}
