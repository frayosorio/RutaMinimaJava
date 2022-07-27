package rutaminima;

public class ColaPrioridad {

    //Clase componente de la cola
    class NodoCola {

        Object elemento;
        double prioridad;
        NodoCola siguiente;
    }

    //Nodo al frente de la cola
    private NodoCola frente;

    //Metodo constructor
    public ColaPrioridad() {
        frente = null;
    }

    //Indica si la cola esta vacia
    public boolean vacia() {
        return (frente == null);
    }

    //devuelve el primer elemento de la cola
    public Object obtenerPrimero() {
        if (vacia()) {
            return null;
        } else {
            return frente.elemento;
        }
    }

    //devuelve la prioridad del primer elemento de la cola
    public double obtenerPrioridadPrimero() {
        if (vacia()) {
            return -1;
        } else {
            return frente.prioridad;
        }
    }

    //agrega un elemento y lo pone en la cola de acuerdo a la prioridad
    public void encolar(Object elemento, double prioridad) {
        NodoCola p, q;
        if (!vacia()) {
            boolean encontrado = false;
            p = frente;
            while (p.siguiente != null && !encontrado) {
                if (p.prioridad < prioridad) {
                    encontrado = true;
                } else {
                    p = p.siguiente;
                }
            }
            q = p.siguiente;
            p.siguiente = new NodoCola();
            p = p.siguiente;
            p.siguiente = q;
        } else {
            p = new NodoCola();
            frente = p;
        }
        p.elemento = elemento;
        p.prioridad = prioridad;
    }//encolar

    //elimina el primer elemento de la cola
    public Object desencolar() {
        if (vacia()) {
            return null;
        } else {
            Object elemento = frente.elemento;
            frente = frente.siguiente;
            return elemento;
        }
    }

    //indica si un elemento esta en la cola
    public boolean contiene(Object elemento) {
        boolean encontrado = false;
        NodoCola p = frente;
        while (p != null && !encontrado) {
            if (p.elemento.equals(elemento)) {
                encontrado = true;
            } else {
                p = p.siguiente;
            }
        }
        return encontrado;
    }

    //Elimina un elemento de la cola
    public void eliminar(Object elemento) {
        if (elemento != null && !vacia()) {
            //Buscar el elemento
            boolean encontrado = false;
            NodoCola p = frente;
            NodoCola q = null;
            while (p != null && !encontrado) {
                if (p.elemento.equals(elemento)) {
                    encontrado = true;
                } else {
                    q = p;
                    p = p.siguiente;
                }
            }
            if (encontrado) {
                if (q == null) {
                    frente = p.siguiente;
                } else {
                    q.siguiente = p.siguiente;
                }
            }
        }
    }

}
