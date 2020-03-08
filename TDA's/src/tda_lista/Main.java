package tda_lista;

public class Main {

	public static void main(String[] args) {
		Lista L1= new Lista();
		
		L1.INSERTA("Carro", L1.PRIMERO());
		L1.INSERTA("Moto", L1.PRIMERO());
		L1.INSERTA("Bike", L1.PRIMERO());
		L1.verLista();

		Pila P1= new Pila();
		System.out.println("\n");
		P1.METE(1);
		P1.METE(2);
		P1.METE(3);
		P1.verPila();
		
		Cola C1= new Cola();
		System.out.println("\n");
		C1.PONE_EN_COLA(4);
		C1.PONE_EN_COLA(5);
		C1.PONE_EN_COLA(6);
		
		C1.verCola();
	
	}
	
//EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS EJERCICIOS
	
	public Lista intercalarDosListas(Lista L1, Lista L2) {
		Lista L3= new Lista();
		int pos1= L1.PRIMERO();//movimientos que habran en las listas
		int pos2= L2.PRIMERO();
		
		while(pos1== L1.FIN() && pos2== L2.FIN()){//seguira mientras ambos auxiliares lleguen al final de sus listas
			
			if(pos1!= L1.FIN()) {
				L3.INSERTA(L1.RECUPERA(pos1), L3.FIN());
				pos1= L1.SIGUIENTE(pos1);
			}
			//intercala las listas siempre y cuando no lleguen al final
			if(pos2!= L2.FIN()) {
				L3.INSERTA(L2.RECUPERA(pos2), L3.FIN());
				pos2= L2.SIGUIENTE(pos2);
				
			}
			
		}
		
		return L3;
	}
	
	public void intercambiarElementos(Lista L1) {
		Object aux1;
		Object aux2;
		
		if(!L1.LVACIA()) {
			//guardara una copia de los dos primeros datos para invocar la recursion
			aux1= L1.RECUPERA(L1.PRIMERO());
			aux2= L1.RECUPERA(L1.SIGUIENTE(L1.PRIMERO()));
			L1.SUPRIME(L1.PRIMERO());//suprimira las dos primeras posiciones para volver a insertarlas con orden cambiado
			L1.SUPRIME(L1.SIGUIENTE(L1.PRIMERO()));
			
			intercambiarElementos(L1);//esto cambiara las posiciones en pares de la lista
			
			L1.INSERTA(aux1, L1.PRIMERO());
			L1.INSERTA(aux2, L1.PRIMERO());
		}
	}
	
	public void invertirConPila(Lista L ) {
		Pila P1= new Pila();
		int x= L.PRIMERO();
		
		while(x!=L.FIN()){//mete los elementos de la lista en la pila
			P1.METE(L.RECUPERA(x));
			x=L.SIGUIENTE(x);
		}
		
		L.ANULA();//vacia la lista para volver a ingresar los datos
		while(!P1.PVACIA()) { //va metiendo el del tope de la pila a la lista y borrando para que se vaya "moviendo"
			L.INSERTA(P1.TOPE(), L.FIN());
			P1.SACA();
		}
	}
	
}
