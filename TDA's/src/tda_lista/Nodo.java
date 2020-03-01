package tda_lista;

public class Nodo {
	private Object dato;
	private int siguiente;
	
	public Nodo() {
	}
	
	public Nodo(Object dato, int siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}
	

	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public int getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(int siguiente) {
		this.siguiente = siguiente;
	}
	
	
}
