import java.util.*;


/**
 * A model of Kennel, extends BasicKennel
 * adding a keyed dictionary 
 */
public class Kennel extends BasicKennel
{
	/** HashMap that holds the Kennels*/
	private HashMap<String, PetOwner> KennelHash = 
			new HashMap<String, PetOwner>();
	
	/** Initialize an instance to hold pets
	 * @param size   the size/number of pens
	 * @precond size > 0  */
	public Kennel(int size)
	{
		super(size);
	}
	
	/** Adds a PetOwner to the HashMap
	 * @param owner   the PetOwner to be added*/
	public void addOwner(PetOwner owner)
	{
		KennelHash.put(owner.getName(), owner);
	}
	
	/** Checks the HashMap to see if it contains
	 *  a given owner
	 *  @param owner   the name of the owner*/
	public boolean hasOwner(String owner)
	{
		return KennelHash.containsKey(owner);
	}
	
	/** Takes the string name of a given Owner
	 * and returns the object Owner
	 * @param owner    name of the owner*/
	public PetOwner getOwner(String owner)
	{
		return KennelHash.get(owner);
	}
	
	/** Returns a string representation of the Owners
	 * in the Kennel HashMap*/
	public String toString()
	{
		String temp = "Owners:\n";
		
		for (String key: KennelHash.keySet())
		{
			temp = temp + key + "\n-" 
					+ getOwner(key).toString() + "\n";
		}
		
		return temp;
	}
	/** Returns a string representation of the kennels
	 * and their occupancy(if any)
	 * @param Kennel   the kennel we are looking at*/
	public String listPenOccupancy(Kennel kennel)
	{
		String temp = "Kennel Occupancy:\n";
		for (int i = 1; i<= kennel.size(); i++)
		{
			temp = temp + i + ": ";
			if (kennel.hasOccupant(i))
			{
				temp = temp + occupantOfPen(i).getName() + "\n";
			}
			else
			{
				temp = temp + "unoccupied\n";
			}
		}

		
		return temp;
	}
	
	/** A method to test the Kennel Class*/
	public static void main(String[] args)
	{
		Kennel myKennel = new Kennel(10);
		int numErrors = 0;
		PetOwner owner1 = new PetOwner("Barb", "Tahiti");
		PetOwner owner2 = new PetOwner("Frank", "Cuba");
		Dog Rex = new Dog("Rex", owner1, "Pug");
		Dog Barky = new Dog ("Barky", owner1, "Pug");
		Cat Evil = new Cat ("Evil", owner2, "Black");
		Cat Stupid = new Cat ("Stupid", owner2, "Purple");
		
		myKennel.insert(Rex, 1);
		myKennel.insert(Barky, 9);
		myKennel.insert(Stupid, 3);
		
		String expectedtoString = 
				"Owners:\n"
				+"Frank\n"
				+"-Pet's owned: Evil. Stupid. \n"
				+"Barb\n"
				+"-Pet's owned: Rex. Barky. \n";
		
		String expectedPenOccupancy = 
				"Kennel Occupancy:\n"
				+"1: Rex\n"
				+"2: unoccupied\n"
				+"3: Stupid\n"
				+"4: unoccupied\n"
				+"5: unoccupied\n"
				+"6: unoccupied\n"
				+"7: unoccupied\n"
				+"8: unoccupied\n"
				+"9: Barky\n"
				+"10: unoccupied\n";
		
		owner1.addPet(Rex);
		owner1.addPet(Barky);
		owner2.addPet(Evil);
		owner2.addPet(Stupid);
		
		myKennel.addOwner(owner1);
		myKennel.addOwner(owner2);
		
		if (!myKennel.hasOwner("Barb") || 
				!myKennel.hasOwner("Frank"))
		{
			numErrors++;
			System.out.println("Error with hasOwner, could not find" 
					+ " Barb or Frank");
		}
		
		if (myKennel.getOwner("Barb") != owner1 || 
				myKennel.getOwner("Frank") != owner2)
		{
			numErrors++;
			System.out.println("Error with getOwner, returns" 
					+ " incorrect values for owner 1 and/or 2");
		}
		
		if (!myKennel.toString().equals(expectedtoString))
		{
			numErrors++;
			System.out.println("Error, toString did not "
					+ "print expected output.");
		}
				
		if (!myKennel.listPenOccupancy(myKennel).equals(expectedPenOccupancy))
		{
			numErrors++;
			System.out.println("Error, listPenOccupancy did not "
					+ "print expected output.");
		}
		
		if (numErrors == 0)
			System.out.println("The test ran successfully for Kennel.");
		else
		{
			System.out.println("\nThe number of errors found is " 
					+ numErrors);
		}
	}
}