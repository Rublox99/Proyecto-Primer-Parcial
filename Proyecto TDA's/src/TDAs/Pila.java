package TDAs;

public class Pila {
	Lista L1= new Lista();
	
	public Pila() {
	}
	
	public void ANULA() {
		L1.ANULA();
	}
		
	public Object TOPE() {
		return L1.RECUPERA(0);
	}
		
	public void SACA() {
		L1.SUPRIME(0);
	}
		
	public void METE(Object n) {
		L1.INSERTA(0, n);
	}
		
	public boolean VACIA() {
		return L1.VACIA();
	}
		
	public void verPila() {
		System.out.println("<-TOPE");
		L1.verLista();
	}
}

