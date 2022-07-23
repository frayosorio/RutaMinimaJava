
package rutaminima;

import java.io.*;

public class Archivo {
    
        public static BufferedReader abrirArchivo(String nombreArchivo) {
        //instancia de objeto archivo
        File f = new File(nombreArchivo);
        //existe el archivo
        if (f.exists()) {
            try {
                //instancia del objerto lector archivo
                FileReader fr = new FileReader(f);
                //abrir el archivo y retornar su contenido
                return new BufferedReader(fr);
            } catch (Exception ex) {

            }
        }
        return null;
    }
    
}
