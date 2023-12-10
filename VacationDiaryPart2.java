package vacationDiaryPart2;
import java.util.Scanner;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class VacationDiaryPart2 
{
	private static String validateDate(Scanner input, String prompt)
	{
		boolean validInput = false;
		String dateString = "";
		String end = "end";
		
		while (!validInput)
		{
			validInput = true;
			try 
			{
				System.out.print(prompt);
				dateString = input.nextLine();
				if (!dateString.equals(end))
				{
					SimpleDateFormat sdfmt = new SimpleDateFormat("mmddyyyy");
					sdfmt.setLenient(false);
					Date JavaDate = sdfmt.parse(dateString);
					if (dateString.length() != 8)
					{
						throw new Exception();
					}
				}
				else
				{
					validInput = false;
					return dateString;}
				}
			}
			catch (Exception e)
			{
				System.out.println("Invaild date format. Please re-enter date");
				validInput = false;
			}
		}		
		return dateString;
		
	}
	private static String validateCityCountry(Scanner input, String prompt)
	{
		System.out.print(prompt);
		String location = input.nextLine();
		if (location.length() < 15)
		{
			for (int i = location.length(); i < 15; i++)
			{
				location += " ";	
			}
		}
		else if (location.length() > 15)
		{
			location = location.substring(0,15);
		}
		return location;
	}
	private static int validateNumberDays(Scanner input, String prompt)
	{
		boolean validInput = false;
		int numberDays = 0;
		
		while (!validInput)
		{
			validInput = true;
			try
			{
				System.out.print(prompt);
				numberDays = input.nextInt();
				if (numberDays < 1 || numberDays > 30)
				{
					throw new Exception();				
				}
			}
			catch (Exception e)
			{
				System.out.println("Days must be between 1 and 30");
				validInput = false; 
			}
			
		}
		return numberDays;
	}
	private static String validateTravelMode(Scanner input, String prompt)
	{
		boolean validInput = false;
		String travelMode = "";
		
		while (!validInput)
		{
			validInput = true;
			try
			{
				System.out.print(prompt);
				travelMode = input.nextLine();
				if (!travelMode.equals("car") &&
					!travelMode.equals("airplane") &&	
					!travelMode.equals("ship") &&
					!travelMode.equals("train") &&
					!travelMode.equals("bus"))
				{
					throw new Exception();
				}
			}
			catch (Exception e)
			{
				System.out.println("Please enter a valid travel mode");
				validInput = false;
			}
		}
		return travelMode;
	}
	public static void main(String[] args) 
	{			
		Scanner input = new Scanner(System.in);
		
		String continueQuestions = "";
		
		int numStops = 0;
		final int MAX_STOPS = 10;
		String dateStarted[] = new String[MAX_STOPS];
		String cityVisited[] = new String[MAX_STOPS];
		String countryVisited[] = new String[MAX_STOPS];
		int numberDays[] = new int[MAX_STOPS];
		String travelMode[] = new String[MAX_STOPS];
		
		while (continueQuestions != "end")
		{
			String nextQuestion = "Enter date vacation started (mmddyyyy) or end to quit: ";
			dateStarted[numStops] = validateDate(input, nextQuestion);
			if (dateStarted[numStops].equals("end"))
			{
				continueQuestions = "end";
				continue;
			}
			nextQuestion =  "Enter City Visited: ";
			cityVisited[numStops] = validateCityCountry(input, nextQuestion);
			nextQuestion = "Enter Country Visited: ";
			countryVisited[numStops] = validateCityCountry(input, nextQuestion);
			nextQuestion = "Enter number of Days: ";
			numberDays[numStops] = validateNumberDays(input, nextQuestion);
			String ignore = input.nextLine();
			nextQuestion = "Enter Mode of Travel (car, airplane, ship, train, bus): ";
			travelMode[numStops] = validateTravelMode(input, nextQuestion);
			
			numStops++;
		}
		input.close();
		
		System.out.println("================================================================");
		System.out.println("=========================== Vacation Diary =====================");
		System.out.println("Date\t\tCity\t\tCountry\t\tDays\t\tMode");
		System.out.println("===========\t===============\t===========\t==========\t=========");
		
		for (int i = 0; i < numStops; i++)
		{
			System.out.println(dateStarted[i] + "\t" +
							  cityVisited[i] + "\t" +
							  countryVisited[i] + "\t" + 
							  numberDays[i] + "\t\t" +
							  travelMode[i]);
		}
		System.out.println("Bye!!!");
	}
}
