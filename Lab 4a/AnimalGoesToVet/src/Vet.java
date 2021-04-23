/**
 * 
 * @author CS 2110 Faculty
 * Vet class, where all domesticated animals must visit
 *
 */
public class Vet {

	// TODO The following method is incomplete; you need to fix it to:
	// a) take an animal argument and b) have the animal make its noise
	public static void giveShot(Animal animal) {
		System.out.println(String.valueOf(animal.getClass()).substring(6) + " " + animal.name + " after the shot cried " + animal.makeNoise());
	}
	
	public static void main(String[] args) {
		Animal a1 = new Dog("Jack");
		Animal a2 = new Cat("Garfield");
		Animal a3 = new Animal("Marlow");
		// TODO Complete the rest of the code to print the following output:
		giveShot(a1);
		giveShot(a2);
		giveShot(a3);
	}

}
