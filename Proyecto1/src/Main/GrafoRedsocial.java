
package Main;
import Clases.Amistades;
import graforedsocial.GrafoMatriz;
import graforedsocial.Lista;
import Clases.Usuario;
import graforedsocial.Nodo;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import lectura.ArchivoTxt;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.spriteManager.*;

/**
 *
 * @author raco1
 */
public class GrafoRedsocial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista listaUsuarios= new Lista();
        Lista listaAmistades= new Lista();
        String ruta;
        JFileChooser archivo= new JFileChooser();
        archivo.showOpenDialog(archivo);
        ruta=archivo.getSelectedFile().getAbsolutePath();
        //JOptionPane.showMessageDialog(null,"Archivo cargado correctamente");
        ArchivoTxt file = new ArchivoTxt(ruta);
        
        file.leerTxt(listaUsuarios, listaAmistades);
        listaUsuarios.imprimir();
        JOptionPane.showMessageDialog(null,listaUsuarios.getpLast().getUser().getId());
        listaAmistades.imprimirAmistades();
        file.escribirTxt(listaUsuarios, listaAmistades);
        
        
        System.setProperty("org.graphstream.ui", "swing");
        GrafoMatriz grafo= new GrafoMatriz(listaUsuarios, listaAmistades);
        
        grafo.generarM();
        grafo.llenarMatriz();
        grafo.imprimirGrafo();
        
        Graph nuevo= new SingleGraph("prueba");
        SpriteManager sman = new SpriteManager(nuevo);
        Nodo aux=listaUsuarios.getpFirst();
        for (int i = 0; i < listaUsuarios.getSize(); i++) {
            nuevo.addNode(aux.getUser().getId());
            aux=aux.getpNext();
        }
        String ver="";
        String ver1="";
        String ver2="";
        aux=listaAmistades.getpFirst();
        for (int i = 0; i < listaAmistades.getSize(); i++) {
            ver=aux.getAmigos().getId1().getId();
            ver1=aux.getAmigos().getId2().getId();
            ver2=ver+ver1;
            nuevo.addEdge(ver2, ver, ver1, false);
            aux=aux.getpNext();
        }
       
            
        nuevo.display();
    }
    
}
