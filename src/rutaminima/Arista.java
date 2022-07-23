package rutaminima;

public class Arista {

    private Nodo nodo1, nodo2;
    private double valor;

    public Arista(Nodo nodo1, Nodo nodo2, double valor) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.valor = valor;
    }

    //Devuelve el valor de la arista
    public double obtenerValor() {
        return valor;
    }

    //Devuelve el primer nodo de la arista
    public Nodo obtenerNodo1() {
        return nodo1;
    }

    //Devuelve el segundo nodo de la arista
    public Nodo obtenerNodo2() {
        return nodo2;

    }
}
