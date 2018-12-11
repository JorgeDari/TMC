import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Admin_parking
{
	
	public static final int lugares = 20;
	
	

	// MENU PRINCIPAL
	
	
	public static void main(String[] args) 
	{
		Garage_funciones cars = new Garage_funciones();
		
		// Creao e inicializo en uno todo el arreglo del estacionamiento
		int parking[] = new int[lugares];
		for (int k=0;k<lugares;k++)
		{
			cars.set(parking,k);
		}	
		
		int  coli,cant_coli,registro,nCoches,nVeces=0;
	
		
		nCoches = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE AUTOS A ESTACIONAR"));
		if ((nCoches > 0) & (nCoches <= lugares))
		{
			int patentes[] = new int[nCoches]; // Genero un arreglo de patentes de nCoches
			for(int p=0;p<=nCoches-1;p++)
			{
				
				cars.generar_patente(patentes,p);
				cars.mostrar_patentes(patentes,p);
						
			}	
				
			registro=cars.cantidad_cars_ingresados(parking,patentes);
			if (registro==-1) System.out.println("SE UBICARON TODOS LOS AUTOS INGRESADOS");
			else	
			System.out.println("SOLAMENTE SE PUDO UBICAR "+registro+" "+"AUTOS");
		}
		else
		{
			System.out.println("ERROR -- CAPACIDAD MAXIMA PERMITIDA PARA ESTACIONAR = 20 LUGARES");
		}
			
			// COMIENZO DEL PUNTO B DEL TPE
			
			float laplace=0;
			float epsilon= 0.0001f;
			cant_coli=0;
			coli=0;
			nVeces = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE REPETISIONES "));
			nCoches = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE COCHES A UBICAR "));
		    for(int m=0;m<nVeces;m++)
		    {
		    	cars.inicializar_vector(parking,lugares);
		    	    	
		    	int dominios[]=new int[nCoches];
		    	for(int p=0;p<=nCoches-1;p++)
				{
					
					cars.generar_patente(dominios,p);
					cars.mostrar_patentes(dominios,p);
							
				}	
		    		
		    	coli=cars.cantidad_cars_ingresados(parking,dominios);
		    	if (coli==-1) System.out.println("SE UBICARON TODOS LOS AUTOS INGRESADOS");
				else	
				 cant_coli++;
				System.out.println("CONTADOR"+cant_coli+"\t");    
			
		    }
		    
		    laplace=cars.probabilidad_laplace(nVeces,cant_coli);
		    cars.mostrar_resultados(laplace,"LAPLACE");
		    
		    // COMIENZO DEL PUNTO C
		    
		    nVeces = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE ITERACIONES > 10 "));
		    nCoches = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE COCHES A UBICAR "));
		    for(int m=0;m<nVeces;m++)
		    {
		    	cars.inicializar_vector(parking,lugares);
		    	    	
		    	int dominios[]=new int[nCoches];
		    	for(int p=0;p<=nCoches-1;p++)
				{
					
					cars.generar_patente(dominios,p);
					cars.mostrar_patentes(dominios,p);
							
				}	 
		    	coli=cars.cantidad_cars_ingresados(parking,dominios); 
		    	epsilon=cars.probabilidad_epsilon(coli,nVeces,nCoches,epsilon);	
		    	//cars.mostrar_resultados(epsilon,"EPSILON");
		    }
		    
		
	}

}
