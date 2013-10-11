import java.util.LinkedList;
import java.util.ListIterator;

public class PetOwner extends Person
{
	/** LinkedList to hold pets */
	private LinkedList<Pet> petList = new LinkedList<Pet>();
	
	/** 
	 * Initialize an instance with given name, and address
	 * @param name   name of the person
	 * @param address   address of the person
	 * @precond name != null*/
	public PetOwner(String name, String address)
	{
		super(name, address);
	}

	/**
	 * @param name   name of pet 
	 * @return true if successfully added pet*/
	public boolean addPet(Pet name) 
	{
		return petList.add(name);
	}
	
	/** 
	 * @param name   name of pet
	 * @return true if LinkedList contains pet*/
	public boolean hasPet(Pet name)
	{
		return petList.contains(name);
	}
	
	/** 
	 * @param name   name of pet
	 * @return true if successfully removed pet*/
	public boolean removePet(Pet name)
	{
		return petList.remove(name);
	}

	/** @return a string representation of the pets in the list */
	public String toString()
	{
		ListIterator<Pet> iter = petList.listIterator();
		String temp = "Pet's owned: ";
		while (iter.hasNext())
		{
			temp = temp + iter.next().getName() + ". ";
		}
		return temp;
	}

	/** 
	 * A method to test the PetOwner class.
	 * */
	public static void main(String[] args)
	{
		int numErrors = 0;
		PetOwner p = new PetOwner("Phil", "Broadway");
		Pet Sushi = new Pet("Sushi", p);
		Pet Rex = new Pet("Rex", p);
		String expectedOutput = "Pet's owned: Sushi. Rex. ";
		
		if (!p.addPet(Sushi))
		{
			numErrors++;
			System.out.println("Error adding pet Sushi to List.");
		}
		if (!p.addPet(Rex))
		{
			numErrors++;
			System.out.println("Error adding pet Rex to List.");
		}
		
		if (!p.toString().equals(expectedOutput))
		{
			numErrors++;
			System.out.println("Error, toString did not "
					+ "print expected output.");
		}
		
		if (!p.removePet(Sushi))
		{
			numErrors++;
			System.out.println("Error removing Sushi fromlist");
		}
		
		if (p.hasPet(Sushi))
		{
			numErrors++;
			System.out.println("Error, pet Sushi should have" 
					+ " been removed.");
		}
		
		if (!p.hasPet(Rex))
		{
			numErrors++;
			System.out.println("Error, could not find Rex");
		}
		
		
		if (numErrors == 0)
			System.out.println("The test ran successfully for PetOwner.");
		else
		{
		System.out.println("\nThe number of errors found is " + numErrors);
		}

	}

}
