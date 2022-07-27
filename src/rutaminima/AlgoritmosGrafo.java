package rutaminima;

import java.util.Stack;

public class AlgoritmosGrafo {

    // Halla la ruta más corta desde el nodo inicial a todos los demás 
    private static Resultado dijkstra(Grafo g, int inicio) {
        //declarar la lista resultante
        Resultado r = new Resultado();

        //Cola de nodos        
        ColaPrioridad cola = new ColaPrioridad();

        //Agregar el nodo inicial a la cola
        Nodo n = g.obtenerNodos().get(inicio);
        n.asignarPadre(null);
        n.asignarValor(0);
        cola.encolar(n, 0);

        //Iterar hasta que la cola este vacia 
        while (!cola.vacia()) {
            //Desencolar nodo
            n = (Nodo) cola.desencolar();
            //agregarlo al resultado
            r.agregar(n);

            //Recorrer los nodos vecinos
            for (int j = 0; j < n.obtenerVecinos().size(); j++) {
                Nodo nv = n.obtenerVecinos().get(j);
                if (!r.obtenerNodos().contains(nv)) {
                    double valor = n.obtenerValor() + n.obtenerAristas().get(j).obtenerValor();
                    // encolarlo si no esta en la cola
                    if (!cola.contiene(nv)) {
                        nv.asignarValor(valor);
                        nv.asignarPadre(n);
                        cola.encolar(nv, nv.obtenerValor());
                    } else {
                        if (nv.obtenerValor() > valor) {
                            nv.asignarValor(valor);
                            nv.asignarPadre(n);
                            cola.eliminar(nv);
                            cola.encolar(nv, valor);
                        }
                    }
                }
            }
        }
        return r;
    }

    // Halla la ruta más corta desde un nodo inicial a un nodo final
    public static Resultado dijkstra(Grafo g, int inicio, int fin) {
        //aplicar el algoritmo de dijkstra al grafo desde el punto inicial
        Resultado r = dijkstra(g, inicio);

        //Obtener el nodo de destino
        Nodo nd = g.obtenerNodos().get(fin);

        //Verificar que este en el resultado
        if (r.obtenerNodos().contains(nd)) {
            // crea una pila para almacenar la ruta desde el nodo destino al origen 
            Stack pila = new Stack();
            while (nd != null) {
                pila.add(nd);
                nd = nd.obtenerPadre();
            }
            
            r = new Resultado();
            // recorre la pila para armar la ruta en el orden correcto 
            while (!pila.isEmpty()) {
                r.agregar((Nodo) pila.pop());
            }
            return r;
        } else {
            return null;
        }
    }
    
}
