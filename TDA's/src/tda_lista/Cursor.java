package tda_lista;

public class Cursor {
	int cabeza;
	boolean memoria[]= new boolean[10000];
	Nodo elementos[]= new Nodo[10000];
	
	public Cursor() {
		cabeza=-1;
		for(int i=0; i<memoria.length; i++)
			memoria[i]= false;
	}
	
	public void liberarMemoria(int n) {
		memoria[n]=false;
	}
	
	public int asignarMemoria() {
		int indiceAux= 0;
		
		for (int i=0; i<memoria.length; i++) 
			if(memoria[i]= false) {
				indiceAux= i;
				memoria[i]= true;
				break;
			}
		
		return indiceAux;
	}
	
    public int nodoAnterior(int posicion)
    {
      int pos= cabeza;
      int cuenta=0 ;
        while (pos != -1) {            
            cuenta++;
            if (cuenta+1 == posicion)
                return pos;
            pos = elementos[pos].getSiguiente();
        }
        
       return -1; 
    }
}
