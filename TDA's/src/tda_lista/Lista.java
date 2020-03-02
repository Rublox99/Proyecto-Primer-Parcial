package tda_lista;

public class Lista {
	Cursor lista=new Cursor();
	
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
	     int anterior = lista.cubetaAnterior(posicion);
	     lista.elementos[memoria].setDato(n);
	     lista.elementos[memoria].setSiguiente(lista.elementos[anterior].getSiguiente());
	     lista.elementos[anterior].setSiguiente(memoria);
	    }

	}	

	public void SUPRIME(int posicion) {
	    }

	public int LOCALIZA(Object n) {
		int localiza= 0;

		//revisará cada elemento de la lista y de localizarlo, se encontrara el siguiente y se le restara 1 para saber la posicion
		for(int i= 0; i<lista.elementos.length; i++) {
			if(lista.elementos[i].getDato()== n) {
				localiza++;
				return localiza;
			}
			
		}
		
		int cont=0;
		if(localiza== 0){//básicamente FIN()
	
			
			for(int i=0; i<lista.memoria.length; i++) 
				if(lista.memoria[i]= true)
					cont++;
		}

		return cont;
			
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
	
	public int SIGUIENTE(int n) {
		return n++;
	}
		
	public int ANTERIOR(int n) {
		return n--;
	}
	
	public void ANULA() {
		lista.cabeza=-1;
		
		for(int i=0; i<lista.elementos.length; i++)
			lista.memoria[i]=false;
	}
		
	public boolean LVACIA() {
		if(lista.cabeza!=-1)
			return false;
		else
			return true;
	}
	
	public int PRIMERO() {
		return 1;
	}

	public void verLista() {
		String cadena= " ";
		int posicion= lista.cabeza;
		
		while(posicion!=-1) {
			cadena+= lista.elementos[posicion].getDato() + " ";
			posicion= lista.elementos[posicion].getSiguiente();
		}
		System.out.println(cadena);
	}

	@Override
	public String toString() {
		return "Lista [lista=" + lista + "]";
	}
	
}
