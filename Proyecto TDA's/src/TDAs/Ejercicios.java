package TDAs;

public class Ejercicios {
	
	public Ejercicios() {
	}
	//EJERCICIO 1, INCISO a)
	public Lista intercalarDosListas(Lista L1, Lista L2) {
		
		Lista L3= new Lista();
		Nodo pos1= L1.PRIMERO(); //movimientos que habran en las listas
		Nodo pos2= L2.PRIMERO();
			
		while(pos1== L1.SIGUIENTE(L1.FIN()) && pos2== L2.SIGUIENTE(L2.FIN())){//seguira mientras ambos nodos auxiliares lleguen al final de sus listas
			if(pos1!= L1.SIGUIENTE(L1.FIN())) {
				L3.INSERTA(L3.FIN(), pos1.getValor());//insertara el valor del nodo actual pos1 en L3
				pos1= pos1.getSiguiente();//hara que pos1 se mueva hasta llegar a nulo
			}
			//intercala las listas siempre y cuando no lleguen al final
			if(pos2!= L2.SIGUIENTE(L2.FIN())) {
				L3.INSERTA(L3.FIN(), pos2.getValor());
				pos2= pos2.getSiguiente();
					
			}
				
		}
		
		return L3;
	}
		
	//EJERCICIO 2
	public void intercambiarElementos(Lista L1) {
		Object aux1;
		Object aux2;
			
		if(!L1.VACIA()) {
			//guardara una copia de los dos primeros datos para invocar la recursion
			aux1= L1.PRIMERO().getValor();
			aux2= L1.SIGUIENTE(0).getValor();//obtiene el valor del 2do, por eso SIGUIENTE(0)
			L1.SUPRIME(0);//suprimira las dos primeras posiciones para volver a insertarlas con orden cambiado
			L1.SUPRIME(1);
			
			intercambiarElementos(L1);//esto cambiara las posiciones en pares de la lista
				
			L1.INSERTA(0, aux1);
			L1.INSERTA(1, aux2);
		}
	}
		
	//EJERCICIO 3
	public void invertirColaConPila(Lista L) {
		Cola C1 = new Cola();
		int x = 0; //contador desde la primera posicion de la lista

		while(x!=L.FIN()){//se pasan los datos de la lista a la cola
			C1.PONE_EN_COLA(L.RECUPERA(x));
			x++;
		}
			
		L.ANULA(); //formatea la lista para ingresar los datos invertidos desde la cola
		while(!C1.VACIA()) {
			L.INSERTA(L.FIN(), C1.FRENTE());
			C1.QUITA_DE_COLA();
				
			}
	}
	
	//EJERCICIO 4
	public void invertirPilaConCola(Pila P){

		Cola C= new Cola();

		while (!P.VACIA()){
			C.PONE_EN_COLA(P.TOPE());//pondrá el primer elemento de la pila a la cola
			P.SACA();//sacará el primer elemento de la pila para que vaya avanzando el ciclo
		}
		
		while (!C.VACIA()) {
			P.METE(C.FRENTE());//meterá en la pila, el ultimo elemento de la cola
			C.QUITA_DE_COLA();//sacara el ultimo elemento de la cola
		}
			
	}
		
	//EJERCICIO 5
	public Lista concatenarListas(Lista L1, Lista L2) {
		Lista L3= new Lista();
		
		Nodo aux1= L1.PRIMERO(); //Nodos que simularan el movimiento dentro de las listas
		Nodo aux2= L2.PRIMERO();
		
		while(aux1!= null && aux2!= null) {//mientras ambos nodos no lleguen al nulo de sus listas
			
			if(aux1!=null) { //si aun no llega al final de la lista, seguirá este ciclo
			L3.INSERTA(L3.FIN()-1, aux1.getValor());//insertara al final de L3 el valor del nodo actual
			
			aux1= aux1.getSiguiente(); //se mueve hacia el siguiente nodo
			}
			
			if(aux2!=null) {
			L3.INSERTA(L3.FIN()-1, aux2.getValor());
						
			aux2= aux2.getSiguiente();
			}
		}
		
		return L3;
	}
	
	//EJERCICIO 6, INCISO b)
	public void invertirConPila(Lista L) {
		Pila P1= new Pila();
		int x= 0;
			
		while(x!=L.FIN()){//mete los elementos de la lista en la pila
			P1.METE(L.RECUPERA(x));
			x++;
		}
			
		L.ANULA();//vacia la lista para volver a ingresar los datos
		while(!P1.VACIA()) { //va metiendo el del tope de la pila a la lista y borrando para que se vaya "moviendo"
			L.INSERTA(L.FIN(), P1.TOPE());
			P1.SACA();
		}
	}
			
	
}
