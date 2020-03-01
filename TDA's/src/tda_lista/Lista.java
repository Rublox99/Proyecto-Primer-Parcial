package tda_lista;

public class Lista {
	Cursor lista=new Cursor();
	
	public int PRIMERO() {
		return 1;
	}
	
	public int SIGUIENTE(int n) {
		return n++;
	}
	
	public int ANTERIOR(int n) {
		return n--;
	}
	
	public int LOCALIZA(Object n) {
		boolean verificante=false;
		
		int cont=0;
		while(cont!=lista.memoria.length || verificante==true) { //revisará cada elemento de la lista hasta que coincida con uno o llegue al final
			if(lista.elementos[cont].getDato()==n) {
				verificante=true;
				return cont;
			}
			cont++;
		}

		if(verificante=false){//básicamente FIN()
			cont=0;
			
			for(int i=0; i<lista.memoria.length; i++) 
				if(lista.memoria[i]=true)
					cont++;
		}
		return cont;
			
	}
	
	public int FIN() {
		int contador=0;
		
		for(int i=0; i<lista.memoria.length; i++) {
			if(lista.memoria[i]==true)
				contador++;
		}
		return contador+1;
	}
	
	public void INSERTA(Object n, int posicion) {	
		int memoria = lista.asignarMemoria();
		lista.elementos[memoria]=new Nodo();
	    
	    if (posicion == 1){
	    	lista.elementos[memoria].setDato(n);
	        lista.elementos[memoria].setSiguiente(lista.cabeza);
	        lista.cabeza = memoria;
	    } else {
	     int anterior = lista.nodoAnterior(posicion);
	     lista.elementos[memoria].setDato(n);
	     lista.elementos[memoria].setSiguiente(lista.elementos[anterior].getSiguiente());
	     lista.elementos[anterior].setSiguiente(memoria);
	    }

	}
	   /*if(tamaño>0 && tamaño<=posicion) {
	   Nodo nuevo= new Nodo();
	   nuevo.setDato(n);
	   if(posicion== 1) {//si se inserta en la primera posición
		   nuevo.setSiguiente(lista.cabeza);
	   }
}*/

	public void SUPRIMRE(int posicion) {
		
	}
	
	public Object RECUPERA(int posicion) {
	       int puntero = lista.cabeza;
	       int contador = 0;
	        while (contador+1 != posicion) {            
	            puntero = lista.elementos[puntero].getSiguiente();
	            contador++;
	        }
	      return lista.elementos[puntero].getDato();
	}
	
	public void ANULA() {
		lista.cabeza=-1;
		
		for(int i=0; i<lista.elementos.length; i++)
			lista.memoria[i]=false;
	}
	
	public void verLista() {
		int posicion= lista.cabeza;
		
		while(posicion!=-1) {
			System.out.println(lista.elementos[posicion].getDato());
			posicion= lista.elementos[posicion].getSiguiente();
		}
	}
	
	public boolean LVACIA() {
		if(lista.cabeza!=-1)
			return false;
		else
			return true;
	}
}
