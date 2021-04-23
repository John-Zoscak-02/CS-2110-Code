
public abstract class Personnel {
	private final int NUMLETTERS = 6;
	protected String fullName;

	/**
	 * Calculated the computing ID of the person.
	 * @return
	 */
	protected String calculateId() {
		//Extract first and last Initial 
		char firstInitial = this.fullName.split("")[0].charAt(0);
		char lastInitial = this.fullName.split("")[1].charAt(0);
		//Generated four random letters
		String id ="";
		id += firstInitial;
		id +=lastInitial;
		do {
			id+= (char) (Math.random()*26 + 60);
		}while(id.length() < NUMLETTERS);
		return fullName;
		
	}
	
	/**
	 * Print outs name of Class fullname computing_id
	 */
	public abstract String toString();

}



