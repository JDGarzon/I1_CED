package model;

import structures.LinkedList;
import structures.Node;

public class Edificio {
	LinkedList<Piso> pisos;
	Piso pisoActual;
	int numPisoActual;
	String identificador;
	
	public Edificio(String identificador, int numPisos,int numOficinas,String[] names,int[] posiciones,int[] objetivos) {
		this.identificador=identificador;
		pisos=new LinkedList<>();
		Piso[] pisos=new Piso[numPisos];
		Persona[] personas=new Persona[names.length];
		
		for(int i=0;i<names.length&&i<objetivos.length;i++) {
			personas[i]=new Persona(names[i],objetivos[i]);
		}
		
		for(int i=0;i<numPisos;i++) {
			Piso newPiso=new Piso(numOficinas,i);
			pisos[i]=newPiso;
			this.pisos.add(newPiso);
		}
		
		for(int i=0;i<posiciones.length;i++) {
			pisos[posiciones[i]-1].addPersonas(personas[i]);
			
			
		}
		pisoActual=this.pisos.getFirst().getFirst();
		numPisoActual=1;
	}
	
	public void moveAscensor() {
		Ascensor ascensor=pisoActual.getAscensor();
		if(ascensor.advance(numPisoActual)<0) {
			pisos.getFirst().getPrevious().getFirst().setAscensor(ascensor);
		}else if(ascensor.advance(numPisoActual)>0) {
			pisos.getFirst().getNext().getFirst().setAscensor(ascensor);
		}else if(ascensor.advance(numPisoActual)==0) {
			movePeople();
		}
	}
	
	public void movePeople() {
		
	}
	
	public String toString() {
		String out="";
		pisos.reset();
		Node<Piso> localPiso=pisos.getLast();
		
		for(int i=pisos.size()-1;i>=0;i--) {
	
			out+="Piso "+(i+1)+" "+ localPiso.getFirst()+"\n";
			localPiso=localPiso.getPrevious();
			
		}
		return out;
	}
}
