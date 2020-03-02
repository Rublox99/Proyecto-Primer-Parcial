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

}
