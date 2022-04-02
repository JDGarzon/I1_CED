package model;

import structures.PriorityQueue;
import structures.Stack;
import structures.Table;

public class Ascensor {
	PriorityQueue<Integer> botones;
	Table<Integer,Stack<Persona>> personas;
	
	public Ascensor() {
		botones=new PriorityQueue<>();
		personas=new Table<>();
	}
	
	public void addPersona(int piso,Persona toAdd) {
		Stack<Persona> localPersonas=personas.get(piso);
	
		if(localPersonas==null) {
			localPersonas=new Stack<>();
			localPersonas.push(toAdd);
			personas.put(piso, localPersonas);
			botones.push(piso);
		}else {
			localPersonas.push(toAdd);
			botones.push(piso);
		}
	}
	//0 para mismo piso 1 para avanzar -1 para bajar
	public int advance(int pisoActual) {
		if(botones.peek()==pisoActual) {
			return 0;
		}else if(botones.peek()<pisoActual) {
			return -1;
		}else return 1;
	}
	
	
}
