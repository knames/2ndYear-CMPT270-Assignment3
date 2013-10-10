public class Dog extends Pet
{
	/** Breed of the dog*/
	private String breed;
	
	/** 
	 * Initialize an instance with given breed.
	 * @param breed   breed of dog
	 * @precond name != null*/
	public Dog(String name, Person o, String breed)
	{		
		super(name, o);
		if (breed == null)
			throw new RuntimeException("The breed of the pet cannot be null");
		this.breed = breed;
	}
	
	/** @return the breed of the pet*/
	public String getBreed()
	{
		return breed;
	}
	
	/** @return a string representation of the dogs breed */
	public String toString()
	{
		return "Breed: " + breed;
	}
	
	public static void main(String[] args)
	{
		int numErrors = 0;
		Person p = new Person("Frank", "Alphabets");
		Dog dog = new Dog("Rex", p, "Bull");
		System.out.println("The dog called Rex with owner Frank is "
							+ "of type: " + dog.getBreed());
		if (! dog.getBreed().equals("Bull"))
		{
			System.out.println("The constructor or getBreed failed for Rex"
								+ "\n The breed obtained was " + dog.getBreed());
			numErrors++;
		}
		System.out.println("\nThe number of errors found is " + numErrors);
	}
}