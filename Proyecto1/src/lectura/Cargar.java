
package lectura;

import graforedsocial.GrafoMatriz;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *Clase creada para boton de lectura de la interfaz grafica 
 * @author raco1
 */
public class Cargar {
    /**
     * Metodo que se encarga de que todo los datos leidos por el txt se guarden correctamente 
     * @return retorna un objeto que guarda el grafo y la ruta de donde se leyo el txt para la creacion del mismo
     */
    public GrafoRuta cargarTxt(){
        ArchivoTxt leer =new ArchivoTxt();
        try{
        JFileChooser archivo= new JFileChooser();
        archivo.showOpenDialog(archivo);
        String path=archivo.getSelectedFile().getAbsolutePath();
        UsersArcos nuevo= leer.leerTxt(path);
        GrafoMatriz g= new GrafoMatriz(nuevo.getUsers(),nuevo.getArcos());
        GrafoRuta help= new GrafoRuta(g,path);
        return help;
        }catch(Exception err){
        JOptionPane.showMessageDialog(null,"Error al cargar el txt, se procedera a cargar un archivo por default");
        UsersArcos nuevo=leer.leerTxt("test\\archivo.txt");
        GrafoMatriz g= new GrafoMatriz(nuevo.getUsers(),nuevo.getArcos());
        GrafoRuta help= new GrafoRuta(g,"test\\archivo.txt");
        return help;
        }
        
    }
}
