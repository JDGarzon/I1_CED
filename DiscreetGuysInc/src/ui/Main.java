package ui;

import java.util.Scanner;

import model.Edificio;

public class Main {
	
	public static void main(String[]args) {
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		int numEdificios=sc.nextInt();
		sc.nextLine();
		
		Edificio[] edificios= new Edificio[numEdificios];
		
		
		String[][] stringEd=new String[numEdificios][4];
		for(int i=0;i<numEdificios;i++) {
			
			stringEd[i]=sc.nextLine().split(" ");
			
			int numPisos=Integer.parseInt(stringEd[i][2]);
			int numOficinas=Integer.parseInt(stringEd[i][3]);
			
			String[][] personas=new String[Integer.parseInt(stringEd[i][1])][];
			String [] names=new String[personas.length];
			
			int [] posiciones=new int[personas.length];
			int [] objetivos=new int[personas.length];

			
			for(int j=0;j<personas.length;j++) {
				
				personas[j]=sc.nextLine().split(" ");
				names[j]=personas[j][0];
				posiciones[j]=Integer.parseInt(personas[j][1]);
				objetivos[j]=Integer.parseInt(personas[j][2]);
				
			}
			
			edificios[i]=new Edificio(stringEd[i][0],numPisos,numOficinas,names,posiciones,objetivos);
			sc.nextLine();
			
		}
		
		for(int i=0;i<numEdificios;i++) {
			edificios[i].actualize();
			System.out.println(edificios[i]);
			System.out.println(edificios[i].imprimirEstadoFinal());
		}
		
	}
}
