package TDAs;

public class Lista{

    private Nodo inicio;
    private int tamanio;

    public Lista(){
        inicio = null;
        tamanio = 0;
    }

    public boolean VACIA(){
        return inicio == null;
    }

    public int FIN(){
        return tamanio++;
    }

    public void INSERTA(int posicion, Object valor){
        if (posicion >= 0 && posicion <= tamanio) { // Verifica si la posicion ingresada se encuentre en el rango
            Nodo nuevo = new Nodo();
            nuevo.setValor(valor);
            if (posicion == 0){ //Consulta si el nuevo nodo a ingresar va al inicio de la lista
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else { //Si el nodo a inserta va al final de la lista.
                if (posicion == tamanio){
                    Nodo aux = inicio;
                    while (aux.getSiguiente() != null){
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo);
                } else{ //Si el nodo a insertar va en el medio de la lista.
                    Nodo aux = inicio;
                    for (int i = 0; i < (posicion - 1); i++){
                        aux = aux.getSiguiente();
                    }
                    Nodo siguiente = aux.getSiguiente(); // Guarda el nodo siguiente al nodo en la posición en la cual va a insertar el nevo nodo
                    aux.setSiguiente(nuevo);   //Inserta el nuevo nodo en la posición indicada
                    nuevo.setSiguiente(siguiente); //Une el nuevo nodo con el resto de la lista
                }
            }
            tamanio++;
        }
    }
 
    public int LOCALIZA(Object valor) {
    	int cont1= 0; //contador de la posici�n para el FIN()
    	int cont2= 0; //contador para la posicion del elemento a localizar
    	boolean comprobante= false; //comprobante de que el elemento este
    	Nodo aux= inicio;
    	
    	while(aux!=null) {
    		if(aux.getValor()==valor) { //pregunta si el elemento actual es el que se busca
    			cont2= cont1;
    			comprobante= true;
    		}
    		
    		cont1++;
    		aux= aux.getSiguiente();
    	}
    	
    	if(comprobante)
    		return cont1++;
    	else
    		return cont2;
    	
    }
    
    public Object RECUPERA(int posicion) {
    	Nodo aux= inicio;
    	int cont= 0;
    	
    	while(cont!= posicion) {
    		aux= aux.getSiguiente();
    		cont++;
    	}
    	
    	return aux.getValor();
    	
    }
    
    public void SUPRIME(int posicion){  //Elimina un nodo que se encuentre en la lista ubicado por su posición.

        if (posicion >= 0 && posicion < tamanio){
            if (posicion == 0){// Consulta si el nodo a eliminar es el primero
                inicio = inicio.getSiguiente();
            } else{ // En caso que el nodo a eliminar este por el medio o sea el ultimo
                Nodo aux = inicio;// Crea una copia de la lista.
                for (int i = 0; i < posicion - 1; i++){// Recorre la lista hasta lleger al nodo anterior al eliminar.
                    aux = aux.getSiguiente();
                }
                Nodo siguiente = aux.getSiguiente();// Guarda el nodo siguiente al nodo a eliminar.
                aux.setSiguiente(siguiente.getSiguiente());// Elimina la referencia del nodo apuntando al nodo siguiente.
            }
            tamanio--;
        }
    }
    
    public Nodo SIGUIENTE(int posicion) {
    	Nodo aux= inicio;
    	
    	for(int i= 0; i<posicion; i++) 
    		aux= aux.getSiguiente();
    	
    	
    	return aux.getSiguiente();
    }
    
    public Nodo ANTERIOR(int posicion) {
    	Nodo aux= inicio;
    	
    	if(posicion== 0) //en caso sea la posicion cero
    		return null;
    	
    	if(posicion== 1) // en caso se escoja esta posicion, se retorna el inicio (0 es el inicio y 1 el que sigue)
    		return inicio;
    	else {
    		if(posicion==2) // si es la 3ra posicion, retorna el siguiente de inicio
    			return inicio.getSiguiente();
    		else {
    	    	for(int i= 0; i<posicion - 2; i++) // para la posiciones >2 ( la 3ra posicion)
    	    		aux= aux.getSiguiente();

    	    	return aux.getSiguiente();
    		}
    	}
    }

    public void ANULA(){
        inicio = null;
        tamanio = 0;
    }
    
    public Nodo PRIMERO() {
    	return inicio;
    }

    public void verLista(){
        if (!VACIA()){
            Nodo aux = inicio; // Crea una copia de la lista
            while (aux != null){
                System.out.print("[ " + aux.getValor() + " ]" + " ->  ");
                aux = aux.getSiguiente();
            }
        }
    }
}
