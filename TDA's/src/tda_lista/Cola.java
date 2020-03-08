package tda_lista;

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
		L1.INSERTA(n, L1.PRIMERO());
	}
	
	public void QUITA_DE_COLA() {
		L1.SUPRIME(L1.FIN()-1);
	}
	
	public boolean VACIA() {
		return L1.LVACIA();
	}
	
	public void verCola() {
		System.out.println("<-Entrada     Salida->");
		L1.verLista();
	}
}
