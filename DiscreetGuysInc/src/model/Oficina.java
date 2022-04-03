package model;

public class Oficina {
	private Persona persona;
	
	public Oficina(Persona persona) {
		this.persona=persona;
	}
	
	public Oficina() {
		
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
	
}
