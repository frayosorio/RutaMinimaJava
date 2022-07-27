package rutaminima;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Resultado {

    private List<Nodo> nodos;

    public Resultado() {
        nodos = new ArrayList<>();
    }

    //agrega un nodo al nodos
    public void agregar(Nodo n) {
        nodos.add(n);
    }

    //mostrar nodos del nodos
    public void mostrar(JTable tbl, boolean mostrarTotal) {
        //hay nodos en el nodos?
        if (nodos != null) {
            //Crear el modelo de datos de la tabla
            //Listar los nombres de los nodos y su peso
            String[][] datos;
            if (mostrarTotal) {
                datos = new String[nodos.size() + 1][2];
            } else {
                datos = new String[nodos.size()][2];
            }
            double valorTotal = 0;
            for (int i = 0; i < nodos.size(); i++) {
                datos[i][0] = nodos.get(i).obtenerNombre();
                datos[i][1] = String.valueOf(nodos.get(i).obtenerValor());
                valorTotal += nodos.get(i).obtenerValor();
            }
            if (mostrarTotal) {
                //Mostrar el valor total del nodos
                datos[nodos.size()][0] = "Valor Total";
                datos[nodos.size()][1] = String.valueOf(valorTotal);
            }
            //definir las columnas
            DefaultTableModel dtm = new DefaultTableModel(datos,
                    new String[]{"Nombre", "valor"});
            //Asignar el modelo a la tabla
            tbl.setModel(dtm);
        }
    }

    public List<Nodo> obtenerNodos() {
        return nodos;
    }

}
