
package lectura;

import graforedsocial.GrafoMatriz;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author raco1
 */
public class Cargar {
    
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
