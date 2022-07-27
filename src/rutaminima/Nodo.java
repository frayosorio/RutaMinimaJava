package rutaminima;

import java.util.*;

public class Nodo {

    private String nombre;

    private double valor; //almacenamiento temporal para procesos
    private Nodo padre; //almacenamiento temporal para procesos
    private boolean activo; //almacenamiento temporal para procesos

    private List<Nodo> vecinos;
    private List<Arista> aristas;

    public Nodo(String nombre) {
        this.nombre = nombre;
        activo = false;
        vecinos = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public String obtenerNombre() {
        return nombre;
    }

    //asignar valor al nodo
    public void asignarValor(double valor) {
        this.valor = valor;
    }

    //Devuelve el valor del nodo
    public double obtenerValor() {
        return valor;
    }

    //asignar padre al nodo
    public void asignarPadre(Nodo n) {
        padre = n;
    }

    //Devuelve el padre del nodo
    public Nodo obtenerPadre() {
        return padre;
    }

    public List<Nodo> obtenerVecinos() {
        return vecinos;
    }

    public List<Arista> obtenerAristas() {
        return aristas;
    }

    //Agrega un nodo vecino del actual
    public void agregarVecino(Nodo n, Arista a) {
        //asignar el nuevo vecino
        vecinos.add(n);
        aristas.add(a);
    }

    //Verificar si un nodo es padre del actual nodo
    public boolean esPadre(Nodo n) {
        if (padre.equals(n)) {
            return true;
        } else {
            return false;
        }
    }

    //Verifica si un nodo es adyacente del actual
    public boolean esVecino(Nodo n) {
        return vecinos.contains(n);
    }
}
