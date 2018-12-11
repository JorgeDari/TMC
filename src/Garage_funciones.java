
public class Garage_funciones {
	
	public Garage_funciones()
	{
		
	}
	
	 public void set(int ubicacion[],int ind)
	  {
		  ubicacion[ind]=1; // Inicializo el arreglo con 1
	  }
	 
	 public void generar_patente(int patentes[],int indice)
	 {
		 int dominio=0;
		 dominio=(int) (Math.random()*1000);
		 patentes[indice]=dominio;
	 }
	  
	 public void mostrar_patentes(int patentes[],int ind)
	 {
		 System.out.println("DOMINIO :"+patentes[ind]+"\t");
	 }

	 
	 public int asignar_lugar(int p)
	 {
		int pos=0; 
		pos=p%20;
		return pos;
	 }
	 
	 public int obtener_patente(int patentes[],int p)
	 {
		 return patentes[p];
	 }
	 
	 public void mostrar_ubicacion(int ubi)
	 {
		 System.out.println("UBICACION ASIGNADA:"+ubi);
	 }
	 
	 public boolean colision(int parking[],int posicion)
	 {
		boolean libre=true;
		if (parking[posicion]==1)
		{
		  parking[posicion]=0;
		  libre=false;
		  
		}
		return libre;
	 }
	 
	 public int cantidad_cars_ingresados(int parking[],int patentes[])
	 {
		int i=patentes.length-1;
		int asignacion,cant=0;
		boolean bol = false;
		do
		{
			System.out.println("UBICACION ASIGNADA:"+asignar_lugar(patentes[i]));
			asignacion=asignar_lugar(patentes[i]);
			bol=colision(parking,asignacion);
			cant++;
			i--;
		}while ((i>=0)&&(!bol));
		if (bol=true) cant--;
		if (i<0) cant=-1;
		return cant;
	 }
	 
	 public void inicializar_vector(int parking[],int lugares)
	 {
		for (int pos=0;pos<lugares;pos++) parking[pos]=1; 
	 }
	 
	 public float probabilidad_laplace(int nVeces, int cantColi)
	 {
		 float resultado=0.0f;
		 resultado=((float)cantColi/(float)nVeces)*100;
		 return resultado;
	 }
	 
	 public float probabilidad_epsilon(int coli, int nVeces, int cantCoches, float epsilon)
	 {
		 
		    int i=1;
			int aciertos = 0;
			float probabilidad1 = 0;
			float probabilidad2 = 0;
			float resultado = 0.01f;
			while (i <= nVeces || resultado > epsilon)
			{
				
				if (coli == -1) {
					aciertos=cantCoches;
				}
				if (i==1) {
					probabilidad1=((float)aciertos/(float)i);
				} else {
					probabilidad2=((float)aciertos/(float)i);
				}
				resultado = probabilidad2-probabilidad1;
				if (resultado < 0) {
					resultado = resultado*(-1);
				} 
//				
				System.out.println(i + ") probabilidad: " + probabilidad2 + " diferencia: " + resultado);
				probabilidad1=probabilidad2;
				i++;

			}
		 return resultado;
	 }
	 
	 public void  mostrar_resultados(float resultado, String msj)
	 {
		 System.out.println("LA PROBABILIDAD DE "+msj+" ES :"+resultado); 
	 }
}
