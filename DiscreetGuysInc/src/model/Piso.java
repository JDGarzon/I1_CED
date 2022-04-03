package model;

import structures.Queue;
import structures.Stack;

public class Piso {
	private Ascensor ascensor;
	private Queue<Persona> pasillo;
	private Oficina[] oficinas;
	int piso;
	
	
	
	public Piso(int numOficinas,int piso) {
		ascensor=new Ascensor();
		pasillo=new Queue<>();
		oficinas=new Oficina[numOficinas];
		for(int i=0;i<oficinas.length;i++) {
			oficinas[i]=new Oficina();
		}
		this.piso=piso;
	}
	
	
	
	public void addPersonas(Persona personas) {
		for(int i=0;i<oficinas.length;i++) {
	
			if(oficinas[i].isEmpty()) {
				oficinas[i].setPersona(personas);
				break;
			}
			
		}
	}
	
	public Ascensor getAscensor() {
		return ascensor;
	}
	
	public void setAscensor(Ascensor toChange) {
		ascensor=toChange;
	}
	
	public void meterOficina(Persona p) {
		for(int i=0;i<oficinas.length;i++) {
			if(oficinas[i].isEmpty()) {
				oficinas[i].setPersona(p);
				return ;
			}
		}
		return ;
	}
	
	public void sacarOficina() {
		for(int i=0;i<oficinas.length;i++) {
			if(!oficinas[i].isEmpty()) {
				pasillo.push(oficinas[i].outP());
			}
		}
	}
	
	public void moveraAscensor() {
		for(int i=0;i<pasillo.size();i++) {
			Persona persona=pasillo.poll();
			ascensor.addPersona(persona.getObjetivo(),persona);
		}
		 
	}
	
	public void meterPersonaPasillo(Persona persona) {
		pasillo.push(persona);
	}
	
	public void sacarDeAscensor() {
		Stack<Persona> personas=ascensor.getPersonas(piso);
		if(personas!=null) {
			for(int i=0;i<personas.size();i++) {
				pasillo.push(personas.pop());
			}
		}
	}
	
	public String toString() {
		String out="";
		for(int i=0;i<oficinas.length;i++) {
			out+="[";
			if(!oficinas[i].isEmpty()) {
				out+="O";
			}else out+="X";
			out+="]";
		}
		return out;
	}
	
	
	
}
