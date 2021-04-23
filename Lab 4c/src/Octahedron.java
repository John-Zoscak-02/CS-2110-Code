
public class Octahedron implements Solids{
	
	private double edge;
	private String color, name;
	
	public Octahedron(double edge, String color, String name){
		this.edge = edge;
		this.color = color;
		this.name = name;
	}
	
	// Volume = [(square root of 2)/3]  * edge^3  [Note: edge^3 is edge-cubed]
	public double getVolume(){
		return (Math.sqrt(3)/3) * Math.pow(3, edge);
	}

	public String getColor(){
		return color;
	}

	public String getName(){
		return name;
	}

}
