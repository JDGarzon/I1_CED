package model;

import structures.LinkedList;
import structures.Node;
import structures.Table;

public class Edificio {
	private LinkedList<Piso> pisos;
	private Piso pisoActual;
	private String identificador;
	private Table<Integer,Integer> pisoOficina;
	
	public Edificio(String identificador, int numPisos,int numOficinas,String[] names,int[] posiciones,int[] objetivos) {
		this.identificador=identificador;
		pisoOficina=new Table<>();
		pisos=new LinkedList<>();
		Piso[] pisos=new Piso[numPisos];
		Persona[] personas=new Persona[names.length];
		
		for(int i=0;i<names.length&&i<objetivos.length;i++) {
			personas[i]=new Persona(names[i],objetivos[i]);
		}
		
		for(int i=0;i<numPisos;i++) {
			Piso newPiso=new Piso(numOficinas,i,i+1,pisoOficina);
			pisos[i]=newPiso;
			this.pisos.add(newPiso);
			Oficina[] oficinas=newPiso.getOficinas();
			for(int j=0;j<oficinas.length;j++) {
				pisoOficina.put(Integer.parseInt(oficinas[j].toString()), i+1);
			}
		}
		
		for(int i=0;i<posiciones.length;i++) {
			pisos[posiciones[i]-1].addPersonas(personas[i]);
		}
		pisoActual=this.pisos.getFirst().getFirst();
	}
	
	
	
	public void actualize() {
		pisoActual.actualize();
		Ascensor ascensor=pisoActual.getAscensor();		
		int size=pisos.size();
		for(int i=0;i<size;i++) {
			pisoActual=pisos.up();
			pisoActual.setAscensor(ascensor);
			pisoActual.actualize();
		}
		
		
		if(pisoActual.numPerAscensor()>0) {
			while(pisoActual.numPerAscensor()>0) {
				int upOrdown= pisoActual.upOrdown();
				if(upOrdown<0) {
					pisoActual=pisos.down();
					pisoActual.setAscensor(ascensor);
					pisoActual.actualize();
				}else if(upOrdown>0) {
					pisoActual=pisos.up();
					pisoActual.setAscensor(ascensor);
					pisoActual.actualize();
				}
			}
			
		}
	}
	public String toString() {
		String out="Movimientos edificio "+identificador+"\n";
		
		pisos.reset();
		Node<Piso> localPiso=pisos.getLast();
		Piso pisoActual=localPiso.getFirst();
		if(pisos.size()==2) {
			out+=(localPiso)+"\n"+localPiso.getPrevious()+"\n";
		}else{
			for(int i=pisos.size()-1;i>=0;i--) {
				
				out+=pisoActual+"\n";
				localPiso=localPiso.getPrevious();
				pisoActual=localPiso.getFirst();
				
			}
		}
		
		return out;
	}

	public String imprimirEstadoFinal() {
		String out="Estado final de las oficinas en el edificio "+identificador+"\n[";
		pisos.reset();
		
		Node<Piso> localPiso=pisos.getLast();
		Piso pisoActual=localPiso.getFirst();
		if(pisos.size()==2) {
			
			out+=localPiso.getFirst().nombreEnPiso()+localPiso.getPrevious().getFirst().nombreEnPiso();
		}else{
			for(int i=pisos.size()-1;i>=0;i--) {
				out+=pisoActual.nombreEnPiso();
				localPiso=localPiso.getPrevious();
				pisoActual=localPiso.getFirst();
				
			}
		}
		out=out.substring(0, out.length()-1);
		out+="]\n";
		return out;
	}
}
