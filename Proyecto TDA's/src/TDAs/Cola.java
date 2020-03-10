package TDAs;

public class Cola {
	Lista L1= new Lista();
	
	public Cola() {
	}
	
	public void ANULA() {
		L1.ANULA();
	}
	
	public Object FRENTE() {
		return L1.RECUPERA(L1.FIN()-1);
	}
	
	public void PONE_EN_COLA(Object n) {
		L1.INSERTA(0, n);
	}
	
	public void QUITA_DE_COLA() {
		L1.SUPRIME(L1.FIN()-1);
	}
	
	public boolean VACIA() {
		return L1.VACIA();
	}
	
	public void verCola() {
		System.out.println("<-ENTRADA     SALIDA->");
		L1.verLista();
	}
}
