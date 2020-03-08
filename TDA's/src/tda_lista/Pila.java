package tda_lista;

public class Pila {
	Lista L1= new Lista();
	
	public Pila() {
	}
	
	public void ANULA() {
		L1.ANULA();
	}
	
	public Object TOPE() {
		return L1.RECUPERA(L1.PRIMERO());
	}
	
	public void SACA() {
		L1.SUPRIME(1);
	}
	
	public void METE(Object n) {
		L1.INSERTA(n, 1);
	}
	
	public boolean PVACIA() {
		return L1.LVACIA();
	}
	
	public void verPila() {
		System.out.println("<-Tope");
		L1.verLista();
	}
}
