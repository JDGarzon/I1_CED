package model;

import structures.PriorityQueue;
import structures.Stack;
import structures.Table;

public class Ascensor {
	private PriorityQueue<Integer> botones;
	private Table<Integer,Stack<Persona>> personas;
	private Table<Integer,Integer> pisoOficina;
	private int numPersonas;

	public Ascensor(Table<Integer,Integer> pisoOficina) {
		botones=new PriorityQueue<>();
		personas=new Table<>();
		numPersonas=0;
		this.pisoOficina=pisoOficina;
	}
	
	public void setPisoOficina(Table<Integer,Integer> pisoOficina) {
		this.pisoOficina=pisoOficina;
	}
	
	public void addPersona(int objetivo,Persona toAdd) {
		
		
		Stack<Persona> localPersonas=personas.get(pisoOficina.get(objetivo));
	
		if(localPersonas==null) {
			localPersonas=new Stack<>();
			localPersonas.push(toAdd);
			personas.put(pisoOficina.get(objetivo), localPersonas);
			botones.push(objetivo);
			numPersonas++;
		}else {
			localPersonas.push(toAdd);
			botones.push(objetivo);
			numPersonas++;
		}
	}
	//0 para mismo piso 1 para avanzar -1 para bajar
	public int advance(int pisoActual) {
		pisoActual++;
		
		
		if(pisoOficina.getPair(botones.peek()).getValue() ==pisoActual) {
			botones.pop();
			return 0;
		}else if(pisoOficina.getPair(botones.peek()).getValue()<pisoActual) {
			return -1;
		}else return 1;
		
	}
	
	public Stack<Persona> getPersonas(int piso){
		return personas.get(piso);
	}
	
	
	public int getNumPersonas() {
		return numPersonas;
	}
	
	public void setNumpersonas() {
		
		numPersonas-=1;
		
		
	}
	
	public boolean isEmpty() {
		return numPersonas==0;
	}
	
	public String toString() {
		return ""+numPersonas;
	}
	
	
	
}
