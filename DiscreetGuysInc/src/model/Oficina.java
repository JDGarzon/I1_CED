package model;

public class Oficina {
	private Persona persona;
	int numOficina;
	public Oficina(Persona persona,int numOficina) {
		this.persona=persona;
		this.numOficina=numOficina;
	}
	
	public Oficina(int numOficina) {
		this.numOficina=numOficina;
	}
	
	public boolean isEmpty() {
		return persona==null;
	}
	
	public Persona outP() {
		Persona out=new Persona(persona.getName(),persona.getObjetivo());
		persona=null;
		return out;
	}
	
	public void setPersona(Persona p) {
		this.persona=p;
	}
	
	public String toString() {
		return numOficina+"";
	}
	
	public String toStringwithName() {
		return persona+" se mueve a la oficina  :"+numOficina;
	}
	

	
	public String getName() {
		return persona.toString();
	}
	
}
