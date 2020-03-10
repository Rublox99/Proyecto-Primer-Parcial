package TDAs;

public class Main {

    public static void main(String[] args) throws Exception {
    	
        Lista lista = new Lista();
        
        //0 es el primer de la lista
        lista.INSERTA(0, 79);
        lista.INSERTA(1, 779);
        lista.INSERTA(2, 7779);

        System.out.println("**-- Lista --**");
        lista.verLista();
        
        Cola cola= new Cola();
        
        cola.PONE_EN_COLA(1);
        cola.PONE_EN_COLA(2);
        cola.PONE_EN_COLA(3);
        cola.QUITA_DE_COLA();
        
        System.out.println("\n\n**-- Cola --** ");
        cola.verCola();
        
        Pila pila= new Pila();
        
        pila.METE(1);
        pila.METE(2);
        pila.METE(3);
        pila.SACA();
        
        System.out.println("\n\n**-- Pila --** ");
        pila.verPila();
    }
}
