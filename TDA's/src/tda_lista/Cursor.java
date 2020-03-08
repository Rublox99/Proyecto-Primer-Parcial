package tda_lista;

public class Cursor {
    
    int cabeza; // contiene el indice del arreglo que almacena el elemento primero de la lista
    boolean memoria[] = new boolean[10000]; // verdadero -> memoria ocupada, falso -> memoria libre
    Nodo elementos[] = new Nodo[10000];

    public Cursor() {
        cabeza = -1; 
        
        for (int i = 0; i < memoria.length; i++) {
            memoria[i]=false;
        }
    }
    
    public int asignarMemoria()
    {
        int indice=0;
        //recorrerá cada elemento y al encontrar uno vacío, regresará esa posición y se tachará como llena
        for (int i = 0; i < memoria.length; i++) 
            if (memoria[i]==false){
                indice = i;
                memoria[i]=true;
                break;
            }    
        return indice;
    }
    
    public void liberaMemoria(int indice)
    {
       memoria[indice]=false;
    }
    
    public int cubetaAnterior(int posicionLista)
    {
      int pos = cabeza;
      int cuenta =0;
        while (pos != -1) {            
            cuenta++;
            if (cuenta+1 == posicionLista)
                return pos;
            pos = elementos[pos].getSiguiente();
        }
        
       return -1; 
    }
    
}