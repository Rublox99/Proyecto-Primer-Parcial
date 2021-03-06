package tda_lista;

public class Cursor {
    
    int cabeza; // contiene el indice del arreglo que almacena el elemento primero de la lista
    boolean memoria[] = new boolean[10000]; // verdadero -> memoria ocupada, falso -> memoria libre
    Nodo elementos[] = new Nodo[10000];

    public Cursor() {
        cabeza = -1; 
        
        for (int i = 0; i < memoria.length; i++) {
            memoria[i]=false;
        }
    }
    
    public int asignarMemoria()
    {
        int indice=0;
        //recorrer� cada elemento y al encontrar uno vac�o, regresar� esa posici�n y se tachar� como llena
        for (int i = 0; i < memoria.length; i++) 
            if (memoria[i]==false){
                indice = i;
                memoria[i]=true;
                break;
            }    
        return indice;
    }
    
    public void liberaMemoria(int indice)
    {
       memoria[indice]=false;
    }
    
    public int cubetaAnterior(int posicionLista)
    {
      int pos = cabeza;
      int cuenta =0;
        while (pos != -1) {            
            cuenta++;
            if (cuenta+1 == posicionLista)
                return pos;
            pos = elementos[pos].getSiguiente();
        }
        
       return -1; 
    }
    
    public int posicionCubeta(int posicion) {
    	int cuenta= 1;
    	int siguiente= cabeza;
    	
    	while(posicion!= cuenta) {
    		siguiente= elementos[siguiente].getSiguiente();
    		cuenta++;
    	}

    	return siguiente;
	}

    public int cuentaElementos() {
    	int contador= 0;
	
    	for(int i= 0; i<memoria.length; i++) {
    		if(memoria[i]== true)
    			contador++;
    	}
	
    	return contador;
    }
    
    public void setCabeza(int cabeza) {
    	this.cabeza= cabeza;
    }
    
    public int getCabeza() {
    	return cabeza;
    }
    
    public int getCubetasEncadenamiento(int enca) {
    	return elementos[enca].getSiguiente();
    }
    
    public void setCubetasEncadenamiento(int enca, int encadenamiento) {
    	elementos[enca].setSiguiente(encadenamiento);
    }
    
    public Object getCubetasCursorDato(int index) {
    	return elementos[index].getDato();
    }

}