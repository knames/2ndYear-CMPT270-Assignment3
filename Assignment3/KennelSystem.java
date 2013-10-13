import java.util.InputMismatchException;
import java.util.Scanner;

public class KennelSystem
{
	private Kennel myKennel = new Kennel(1);
	/** Initialize System
	 * @postcond   a new Kennel instance is created*/
	public KennelSystem()
	{
		System.out.println("How many Kennels"  
				 + "  would you like to create to get started:");
		Kennel myKennel = new Kennel(inputInt());
		mainMenu();
		
	}
	
	/** Displays Mainmenu, requests user's input
	 * to navigate through options
	 * @postcond   System may have changed based on users' input*/
	public void mainMenu()
	{
		boolean quitCalled = false;
		do
		{
			System.out.println("Main Menu. Please select an option:"
					+ "\n0.  quit"
					+ "\n1.  add a new owner to the system"
					+ "\n2.  add a new dog to the system"
					+ "\n3.  add a new cat to the system"
					+ "\n4.  display the occupant (if any) of every pen"
					+ "\n5.  assign a pet to a pen"
					+ "\n6.  release a pet from its pen"
					+ "\n7.  display current system state");
			
			boolean correctInput = false;
			int userInput = -1;
			do 
			{
				userInput = inputInt();
				if (userInput < 0 || userInput > 7)
				{
					System.out.println(userInput + " is not a valid"
							+ " choice.");
				}
				else
				{
					correctInput = true;
				}
			}while (!correctInput);
			
			if (userInput == 0)
			{
				quitCalled=true;
				DisplaySystemState();
			}
			else if (userInput == 1)
				myKennel.addOwner(AddOwner()); // what do i do here ADDS OWNERS BUT PET KENNEL HAS NO PETS SO IT DOESNT CRASH / EXCEPTION
			else if (userInput == 2)
				AddDog();
			else if (userInput == 3)
				AddCat();
			else if (userInput == 4)
				DisplayPenOccupant();
			else if (userInput == 5)
				AssignPetToPen();
			else if (userInput == 6)
				ReleasePetFromPen();
			else if (userInput == 7)
				DisplaySystemState();
		
		} while (!quitCalled);
	}
	

	private PetOwner AddOwner() 
	{
		String tempName;
		String tempAddress;
		PetOwner tempOwner;
		System.out.println("What is the Owner's name?");
		tempName = inputString();
		System.out.println("What is the Owner's address?");
		tempAddress = inputString();
		tempOwner = new PetOwner(tempName, tempAddress);
		return tempOwner;
		
		
	}

	private void AddDog() {
		// TODO Auto-generated method stub
		
	}

	private void AddCat() {
		// TODO Auto-generated method stub
		
	}

	private void DisplayPenOccupant() {
		// TODO Auto-generated method stub
		
	}

	private void AssignPetToPen() {
		// TODO Auto-generated method stub
		
	}

	private void ReleasePetFromPen() {
		// TODO Auto-generated method stub
		
	}

	private void DisplaySystemState() {
		// TODO Auto-generated method stub
		System.out.println(myKennel.toString());
		System.out.println(myKennel.listPenOccupancy(myKennel));
		
	}

	/** Requests an integer from the user
	 * @return i   an integer*/
	public int inputInt()
	{
		int i = 0;
		Scanner consoleIn = new Scanner(System.in);
		boolean successful;
		do
		{
			System.out.println("Enter an integer number:");
			successful = true;
			try
			{
				i = consoleIn.nextInt();
			} catch (InputMismatchException e)
			{
				successful = false;
				String faultyInput = consoleIn.nextLine();
				System.out.print("You entered \""
						+ faultyInput + "\"\n\t");
			}
		} while (!successful);
		return i;
	}
	
	/** Requests a String from the user
	 * @return strInput   a String*/
	public String inputString()
	{
		String strInput = "";
		Scanner consoleIn = new Scanner(System.in);
		boolean successful;
		do
		{
			System.out.println("Enter alphabet characters:");
			successful = true;
			try
			{
				strInput = consoleIn.nextLine();
			}
			catch (RuntimeException e)
			{
				successful = false;
				String faultyInput = consoleIn.nextLine();
				System.out.print("You entered \""
						+ faultyInput + "\"\n\t");
			}
		} while (!successful);
		return strInput;
	}
	
	public static void main(String[] args)
	{
		KennelSystem mySystem = new KennelSystem();
	}
}