
public class University{

	public static void main(String[] args) {
		Personnel[] cohort = { new Faculty("Amos Harold", 5.0), 
						new Student("McCoy Elijah", 4.0), 
						new Student("Rillieux Norbert", 3.99)
						, new Faculty("Russell Jesse", 4.99)};
		
		for(Personnel p : cohort){
			System.out.println(p);
		}
	}
}
