package model;

public class Persona {
	
	private String name;
	private int objetivo;
	
	public Persona(String name,int objetivo) {
		this.name=name;
		this.objetivo=objetivo;
	}
	
	public String getName() {
		return name;
	}

	public int getObjetivo() {
		return objetivo;
	}
	
	public String toString() {
		return name;
	}
	
}
