import java.util.Arrays;

public class Garage {
	

	public  int ubicacion[] ; // Defino un arreglo ubicacion sin tamaño
	
	// defino el constructor garage
	 
		  public Garage(int lugares)
		 {
			 ubicacion = new int[lugares];
			 Arrays.fill(ubicacion,1);
			 	 
		 }
		  
		  public void mostrar_patentes(Garage.parking[],int ind)
		 {
				 System.out.println("POSICION :"+Garage.parking[ind]);
		 }
		  
		  public void set(int ubicacion[],int ind)
		  {
			  this.ubicacion[ind]=1;
		  }

}
