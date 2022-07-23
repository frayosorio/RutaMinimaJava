package rutaminima;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Grafo {

    private List<Nodo> nodos;
    private List<Arista> aristas;

    public List<Nodo> obtenerNodos() {
        return nodos;
    }

    public List<Arista> obtenerAristas() {
        return aristas;
    }

    //agrega un nodo al grafo
    public Nodo agregarNodo(String nombre) {
        //instanciar el nuevo nodo
        Nodo n = new Nodo(nombre);
        nodos.add(n);
        return n;
    }

    //agrega una arista al grafo
    public void agregarArista(Nodo n1, Nodo n2, double valor) {
        //instanciar la nueva arista
        Arista a = new Arista(n1, n2, valor);
        //agregarla a la lista
        aristas.add(a);
        //actualiza los vecinos del primer nodo
        n1.agregarVecino(n2, a);
        //actualiza los vecinos del segundo nodo
        n2.agregarVecino(n1, a);
    }

    //devuelve un nodo dado su nombre, si existe
    public Nodo buscarNodo(String nombre) {
        for (Nodo n : nodos) {
            if (n.obtenerNombre().equals(nombre)) {
                return n;
            }
        }
        return null;
    }

    //Llena el grafo desde un archivo
    public void desdeArchivo(String nombreArchivo) {
        //Limpiar el grafo
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
        //Abrir el archivo con los datos
        BufferedReader br = Archivo.abrirArchivo(nombreArchivo);
        //Se pudo leer algo?
        if (br != null) {
            try {
                //Leer la primer linea de texo
                String linea = br.readLine();
                //Mientras se hayan leido lineas
                while (linea != null) {
                    //Partir la linea en los datos componentes
                    String[] textos = linea.split(",");

                    //verificar que no exista el primer nodo
                    Nodo n1 = buscarNodo(textos[0].trim());
                    if (n1 == null) {
                        n1 = agregarNodo(textos[0].trim());
                    }

                    //verificar que no exista el segundo nodo
                    Nodo n2 = buscarNodo(textos[1].trim());
                    if (n2 == null) {
                        n2 = agregarNodo(textos[1].trim());
                    }

                    //Convertir el valor numérico almacenado
                    double valor = 0;
                    try {
                        valor = Double.parseDouble(textos[2]);
                    } catch (Exception ex) {
                    }

                    //Agregar la arista
                    agregarArista(n1, n2, valor);

                    //Leer la siguiente linea
                    linea = br.readLine();
                }

            } catch (IOException ex) {
            }
        }
    }//desdeArchivo

    //muestra la lista de nodos
    public void mostrarNodos(JTable tbl) {
        //Verificar si hay nodos en el grafo
        if (nodos.size() > 0) {
            //Crear el modelo de datos de la tabla
            //Listar los nombres de los nodos
            String[][] datos = new String[nodos.size()][1];
            for (int i = 0; i < nodos.size(); i++) {
                datos[i][0] = nodos.get(i).obtenerNombre();
            }
            //definir las columnas
            DefaultTableModel dtm = new DefaultTableModel(datos,
                    new String[]{"Nombre"});
            //Asignar el modelo a la tabla
            tbl.setModel(dtm);
        }
    }

    //muestra la lista de nodos
    public void mostrarNodos(JComboBox cmb) {
        cmb.removeAllItems();
        for (Nodo n : nodos) {
            cmb.addItem(n.obtenerNombre());
        }
    }

    //muestra la lista de nodos
    public void mostrarAristas(JTable tbl) {
        //Verificar si hay aristas en el grafo
        if (aristas.size() > 0) {
            //Crear el modelo de datos de la tabla
            //Listar los nombres de los nodos
            String[][] datos = new String[aristas.size()][3];
            for (int i = 0; i < aristas.size(); i++) {
                datos[i][0] = aristas.get(i).obtenerNodo1().obtenerNombre();
                datos[i][1] = aristas.get(i).obtenerNodo2().obtenerNombre();
                datos[i][2] = String.valueOf(aristas.get(i).obtenerValor());
            }
            //definir las columnas
            DefaultTableModel dtm = new DefaultTableModel(datos,
                    new String[]{"Origen", "Destino", "Distancia Km"});
            //Asignar el modelo a la tabla
            tbl.setModel(dtm);
        }
    }
}
