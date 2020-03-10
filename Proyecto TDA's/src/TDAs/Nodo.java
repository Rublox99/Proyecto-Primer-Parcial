package TDAs;

public class Nodo {

    private Object valor; // Variable en la cual se va a guardar el valor.
    private Nodo siguiente; // Variable para enlazar los nodos.

    public Nodo() {
        this.valor = 0;
        this.siguiente = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
