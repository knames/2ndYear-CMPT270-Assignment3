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
				AddOwner();
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
	
	/** Add's an owner to the system.
	@p*/
	private void AddOwner() 
	{
		String tempName;
		String tempAddress;
		PetOwner tempOwner;
		System.out.println("What is the Owner's name?");
		tempName = inputString();
		System.out.println("What is the Owner's address?");
		tempAddress = inputString();
		tempOwner = new PetOwner(tempName, tempAddress);
		myKennel.addOwner(tempOwner);
		
		
	}

	private void AddDog() 
	{
		String tempName;
		String tempOwner;
		String tempBreed;
		System.out.println("What is the dog's name?");
		tempName = inputString();
		System.out.println("What is the name of the owner?");
		tempOwner = inputString();
		if (myKennel.hasOwner(tempOwner))
		{
			System.out.println("What breed is the dog?");
			tempBreed = inputString();
			myKennel.getOwner(tempOwner);
			Dog tempDog = new Dog(tempName, myKennel.getOwner(tempOwner), tempBreed);
			myKennel.getOwner(tempOwner).addPet(tempDog);
		}
		else
		{
			System.out.println(tempOwner+ " was not found in the system."
					+ " Please try again.");
			
		}

	}

	private void AddCat() 
	{
		String tempName;
		String tempOwner;
		String tempColor;
		System.out.println("What is the cat's name?");
		tempName = inputString();
		System.out.println("What is the name of the owner?");
		tempOwner = inputString();
		if (myKennel.hasOwner(tempOwner))
		{
			System.out.println("What color is the cat?");
			tempColor = inputString();
			myKennel.getOwner(tempOwner);
			Cat tempCat = new Cat(tempName, myKennel.getOwner(tempOwner), tempColor);
			myKennel.getOwner(tempOwner).addPet(tempCat);
		}
		else
		{
			System.out.println(tempOwner+ " was not found in the system."
					+ " Please try again.");
			
		}
		
	}

	private void DisplayPenOccupant() 
	{
		System.out.println(myKennel.listPenOccupancy(myKennel));
	}

	private void AssignPetToPen() 
	{
		// TODO Auto-generated method stub
		boolean hasSpot = false;
		for (int i = 1; i<myKennel.size(); i++)
		{
			if (!myKennel.hasOccupant(i)
			{
				hasSpot = true;
				i = myKennel.size()+1; //ends loop prematurely
			}
		}
		if (!hasSpot)
		{
			System.out.println("All of the kennels are full");
		}
		else
		{
			System.out.println("What is the name of the pet you"
					+ " are placing in the kennel?");
			String tempPet = inputString();
			if (myKennel.hasPet(tempPet))
			{
				System.out.println(tempPet + " is already in  kennel #"
					+ myKennel.penNumberOf(tempPet) + ".");
			}
			else 
			{
				System.out.println("Which kennel would you like to place " 
					+ "the pet in?");
				System.out.println(myKennel.listPenOccupancy(myKennel));
				int tempPenNumber = inputInt();
				while (myKennel.hasOccupant(tempPenNumber)
				{
					System.out.println("There is already a pet in Kennel # " 
						+ "please choose an unoccupied kennel.");
						tempPenNumber = inputInt();
				}
				myKennel.insert(tempPet, tempPenNumber);
			}
		}
	}

	private void ReleasePetFromPen() 
	{
		// TODO Auto-generated method stub
		String tempPet;
		System.out.println("What is the name of the pet you would "
		 	+ "like to release?");
		System.out.println(myKennel.listPenOccupancy(myKennel);
		tempPet = inputString();
		while (!myKennel.hasPet(tempPet))
		{
			System.out.println(tempPet + "Was not found in the Kennels. "
				+ "Please choose a pet that is in the Kennels to remove.");
			tempPet = inputString;
		}
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
