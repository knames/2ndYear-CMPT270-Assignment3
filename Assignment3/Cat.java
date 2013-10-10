public class Cat extends Pet
{
	/** color of the dog*/
	private String color;
	
	/** 
	 * Initialize an instance with given color.
	 * @param color   color of dog
	 * @precond name != null*/
	public Cat(String name, Person o, String color)
	{		
		super(name, o);
		if (color == null)
			throw new RuntimeException("The color of the pet cannot be null");
		this.color = color;
	}
	
	/** @return the color of the pet*/
	public String getColor()
	{
		return color;
	}
	
	/** @return a string representation of the dogs color */
	public String toString()
	{
		return "color: " + color;
	}
	
	public static void main(String[] args)
	{
		int numErrors = 0;
		Person p = new Person("Frank", "Alphabets");
		Cat cat = new Cat("Stupid", p, "white");
		System.out.println("The cat called Stupid with owner Frank is "
							+ "colored: " + cat.getColor());
		if (! cat.getColor().equals("white"))
		{
			System.out.println("The constructor or getColor failed for Stupid"
								+ "\n The color obtained was " + cat.getColor());
			numErrors++;
		}
		System.out.println("\nThe number of errors found is " + numErrors);
	}
}