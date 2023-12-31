//Kristen Anderson 
//CIS406
//Order EntryPhase 3 Lab

package orderEntryPhase3;
import java.util.Scanner;
import java.util.InputMismatchException;
public class OrderEntryPhase3 {
	
	

	public static void main(String[] args) {
		final int MAX_ITEMS = 10;
		String[] itemNumber = new String[MAX_ITEMS];
		String[] itemDescription = new String[MAX_ITEMS];
		double[] itemPrice = new double[MAX_ITEMS];
		int[] quantity = new int[MAX_ITEMS];
		double[] grossAmount = new double[MAX_ITEMS];
		double[] taxPercentage = new double[MAX_ITEMS];
		double[] taxAmount = new double[MAX_ITEMS];
		double[] discountPercent = new double[MAX_ITEMS];
		double[] discountAmount = new double[MAX_ITEMS];
		double[] netAmount = new double[MAX_ITEMS];
		char addItems = 'y';
		String response;
		int itemCount = 0;
		double totalGrossAmount = 0;
		double totalTaxAmount = 0;
		double totalDiscountAmount = 0;
		double totalNetAmount = 0;
				
		Scanner input = new Scanner(System.in);
		
		while (addItems != 'n' && addItems != 'N') 
			{
			try {
				System.out.print("Enter item number: ");
				itemNumber[itemCount] = input.nextLine();
		
				System.out.print("Enter item description: ");
				itemDescription[itemCount] = input.nextLine();
		
				System.out.print("Enter the item price: ");
				itemPrice[itemCount] = input.nextDouble();
		
				System.out.print("Enter quantity ordered: ");
				quantity[itemCount] = input.nextInt();
		
				System.out.print("Enter the tax pecentage for the item: ");
				taxPercentage[itemCount] = input.nextDouble();
		
				System.out.print("Enter the discount percent of the item: ");
				discountPercent[itemCount] = input.nextDouble();
			}	
			catch (InputMismatchException e) 
			{
				System.out.print("Input format error!");
				e.printStackTrace();
			}
			catch (Exception e) 
			{
				System.out.println("Error! contact administrator!: ");		
			}
			
				grossAmount[itemCount] = itemPrice[itemCount] * quantity[itemCount];
				taxAmount[itemCount] = grossAmount[itemCount] * taxPercentage[itemCount] / 100.0;
				grossAmount[itemCount] += taxAmount[itemCount];
				discountAmount[itemCount] = grossAmount[itemCount] * discountPercent[itemCount] / 100.0;
				netAmount[itemCount] = grossAmount[itemCount] - discountAmount[itemCount];
				totalGrossAmount += grossAmount[itemCount];
				totalTaxAmount += taxAmount[itemCount];
				totalDiscountAmount += discountAmount[itemCount];
				totalNetAmount += netAmount[itemCount];
				itemCount++;
			
				System.out.print("\nEnter More Items? (y/n): ");
				addItems = input.next().charAt(0);
				response = input.nextLine();			  	
			}		
	
		input.close();		
		
		System.out.println("Item Number\t" +
						   "Item Description\t" +
						   "Item Price\t" +
						   "Quantity\t" +
						   "Tax %\t\t" + 
						   "Tax Amt\t\t" + 
						   "Discount %\t" +
						   "Discount Ammt\t" +
				   		   "Net Amt");

		System.out.println("----------\t" +
						   "-----------------\t" +
						   "---------\t" +
						   "--------\t" +
						   "-----\t\t" +
						   "--------\t" +
						   "----------\t" +
						   "------------\t" +
						   "-------");
		for (int i = 0; i < itemCount; i++)
		{
			System.out.println(itemNumber[i] + "\t" + "\t" + 
							  itemDescription[i] + "\t" + "\t" + "\t" +
							  itemPrice[i] + "\t" + "\t" +
							  quantity[i] + "\t" + "\t" + 
							  taxPercentage[i] + "\t" + "\t" + 
							  "$" + taxAmount[i] + "\t" + "\t" + 
							  discountPercent[i] + "\t" + "\t" +
							  "$" + discountAmount[i] + "\t" + "\t" +
							  "$" + netAmount[i] + "\t");
		}
		System.out.println("\nTotals" + "\t\t" +
		         		 "# items: " + itemCount + "\t" +
		         		 "\t\t" +
		         		 "\t\t" +
		         		 "\t\t" +
		         		 "\t\t" +
		         		 "$" + totalTaxAmount + "\t" +
		         		 "\t\t" + 
		         		 "\t" +
		         		 "$" + totalDiscountAmount + "\t\t" +
		         		 "$" + totalNetAmount);	

						  	 

	}

}