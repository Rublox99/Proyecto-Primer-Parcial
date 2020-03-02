package tda_lista;

public class Main {

	public static void main(String[] args) {
		Lista L1= new Lista();
		
		L1.INSERTA("Carro", L1.PRIMERO());
		L1.INSERTA("Pito\n", 2);
		L1.verLista();
		
		System.out.println("Tamaño de la lista: " + L1.FIN()); //falta suprimir y de cola y pila
	
		Pila P1= new Pila();
		
		P1.METE(1);
		P1.METE(2);
		P1.METE(3);
		
		P1.verPila();
	
	}

}
