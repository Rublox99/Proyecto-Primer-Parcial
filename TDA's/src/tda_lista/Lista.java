package tda_lista;


public class Lista {
	Cursor lista=new Cursor();
	
	public int FIN() {
		int contador=0;
		
		for(int i=0; i<lista.memoria.length; i++) {
			if(lista.memoria[i]==true)
				contador++;
		}//cuenta cada elemento que no esté vacío y le suma uno a la cantidad final
		return contador+1;
	}
	
	public void INSERTA(Object n, int posicion) {	
		int memoria = lista.asignarMemoria(); //es el nodo libre luego del ultimo elemento de la lista
		lista.elementos[memoria]=new Nodo(); //se creará un nuevo nodo al final para poder hacer el corrimiento
	    
	    if (posicion == 1){ //si se inserta en el primer lugar
	    	lista.elementos[memoria].setDato(n);
	        lista.elementos[memoria].setSiguiente(lista.cabeza);//se define este primer elemento como cabeza
	        lista.cabeza = memoria; 
	    } else {//si es mayor a uno, tomará en cuenta el nodo anterior a la posicion deseada
	     int anterior = lista.cubetaAnterior(posicion);
	     lista.elementos[memoria].setDato(n);
	     //el siguiente se define como la posicion del elemento de la memoria
	     lista.elementos[memoria].setSiguiente(lista.elementos[anterior].getSiguiente());
	     lista.elementos[anterior].setSiguiente(memoria);
	    }

	}	

	public int SUPRIME(int posicion) {
		
		int elemento= lista.cuentaElementos();
		
		if(posicion>elemento && posicion<1)
			return -1;
		
		int eliminar= lista.posicionCubeta(posicion);
		
		if(posicion== 1 && elemento== 1) {
			lista.cabeza= -1;
			lista.liberaMemoria(eliminar);
		}else {
			if(posicion== 1) {
				lista.setCabeza(lista.getCubetasEncadenamiento(eliminar));
				lista.liberaMemoria(eliminar);
			}
			else {
				int anterior= lista.cubetaAnterior(posicion);
				lista.setCubetasEncadenamiento(anterior, lista.getCubetasEncadenamiento(eliminar));
				lista.liberaMemoria(eliminar);
			}
		}
		
		
		return eliminar;
		/*lista.liberaMemoria(posicion);
		
		if(posicion==1) {
			lista.cabeza= lista.elementos[posicion].getSiguiente();
			lista.elementos[posicion]= null;
			
		} else {
			int anterior= lista.cubetaAnterior(posicion);
			lista.elementos[anterior].setSiguiente(lista.elementos[posicion].getSiguiente());
			lista.elementos[posicion]= null;
		}*/
		
		/*if(posicion== 1) {// para suprimir en caso sea la primera posicion
			lista.memoria[posicion]= false;
			lista.cabeza= lista.elementos[posicion].getSiguiente();
		}
		else //para suprimir en caso no sea la primera posicion
			lista.memoria[posicion]= false;
			
			*/
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
		//inicia en la cabeza y va de uno en uno hasta llegar a la posicion
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
		String cadena= "";
		int posicion= lista.cabeza;
		
		while(posicion!=-1) {//la cadena juntará todos los elementos separados por un espacio
			cadena+= lista.elementos[posicion].getDato() + " ";	
			posicion= lista.elementos[posicion].getSiguiente();
		}
		System.out.println(cadena);
	}
	
}
