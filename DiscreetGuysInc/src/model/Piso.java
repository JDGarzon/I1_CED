package model;

import structures.Queue;
import structures.Stack;
import structures.Table;

public class Piso {
	private Ascensor ascensor;
	private Queue<Persona> pasillo;
	private Queue<Persona> noEntraron;
	private Oficina[] oficinas;
	int piso;
	
	
	
	public Piso(int numOficinas,int piso,int mult,Table<Integer,Integer> pisoOficina) {
		ascensor=new Ascensor(pisoOficina);
		pasillo=new Queue<>();
		noEntraron=new Queue<>();
		oficinas=new Oficina[numOficinas];
		
		if(oficinas.length==1) {
			oficinas[0]=new Oficina(piso+1);
		}else {
			for(int i=0;i<oficinas.length;i++) {
				oficinas[i]=new Oficina(1+piso+(i+(1*piso)));
				mult++;
			}
		}		
		this.piso=piso+1;
	}
	
	
	
	public void addPersonas(Persona persona) {
		pasillo.push(persona);
	}
	
	public Ascensor getAscensor() {
		return ascensor;
	}
	
	public void setAscensor(Ascensor toChange) {
		ascensor=toChange;
	}
	
	public Persona meterOficina(Persona p) {
		for(int i=0;i<oficinas.length;i++) {
			int idOficina=Integer.parseInt(oficinas[i].toString());
			if(idOficina==p.getObjetivo()) {
				if(oficinas[i].isEmpty()) {
					oficinas[i].setPersona(p);
					return null;
				}
			}
			
		}
		return p;
	}
	
	public void sacarOficina() {
		for(int i=0;i<oficinas.length;i++) {
			if(!oficinas[i].isEmpty()) {
				pasillo.push(oficinas[i].outP());
			}
		}
	}
	
	public void moveraAscensor() {
		int size=pasillo.size();
		for(int i=0;i<size;i++) {
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
			int size=personas.size();
			for(int i=0;i<size;i++) {
				pasillo.push(personas.pop());
				ascensor.setNumpersonas();;
				
			}
		}
	}
	
	public void actualize() {
		
		moveraAscensor();
		sacarDeAscensor();
		if(!pasillo.isEmpty()) {
			int size=pasillo.size();
			for(int i=0;i<size;i++) {
				Persona p=meterOficina(pasillo.poll());
				if(p!=null) {
					noEntraron.push(p);
				}
			}
			
		}
		
		
	}
	
	public String toStringTipoMatriz() {
		String out="";
		for(int i=0;i<oficinas.length;i++) {
			out+="[";
			if(!oficinas[i].isEmpty()) {
				out+="O";
			}else out+="X";
			out+="]";
			
		}
		if(pasillo.size()>0) {
			for(int j=0;j<pasillo.size();j++) {
				out+="O";
			}
		}
		return out;
	}
	
	public String toString() {
		String out="";
		
		for(int i=0;i<oficinas.length;i++) {
			if(!oficinas[i].isEmpty()) {
				out+=oficinas[i].toStringwithName()+"\n";
			}
		}
		return out;
		
	}
	
	public int upOrdown() {
		return ascensor.advance(piso);
	}
	
	public int numPerAscensor() {
		return ascensor.getNumPersonas();
	}
	
	public int numOficinas() {
		return oficinas.length;
	}
	
	public Oficina[] getOficinas() {
		return oficinas;
	}
	
	public String nombreEnPiso() {
		String out="";
		for(int i=0;i<oficinas.length;i++) {
			if(!oficinas[i].isEmpty()) {
				out+=oficinas[i].getName()+",";
			}
		}
		
		return out;
	}
}
