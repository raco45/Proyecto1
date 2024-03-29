
package mostrarGrafo;
import graforedsocial.GrafoMatriz;
import graforedsocial.Nodo;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.*;
/**
 * Esta clase se encarga de representar graficamente el grafo creado, utiliza la libreia graphstream
 * 
 * @author raco1
 */
public class Mostrar {
    /**
     * Se encarga de crear un grafo con la libreria graphstream con la informacion del grafo creado para poder representarlo graficamente
     * el grafo creado por esta libreria es de uso unico y exclusivo para la representacion grafica del grafo
     * @param g 
     */
    public void mostrarGrafos(GrafoMatriz g){
        System.setProperty("org.graphstream.ui", "swing");
        Graph nuevo= new SingleGraph("prueba");
        
        
        Nodo aux=g.getUsuarios().getpFirst();
        nuevo.display();
        
        nuevo.setAttribute("ui.quality");
        nuevo.setAttribute("ui.antialias");
        nuevo.setAttribute("ui.stylesheet", "node { size-mode: fit; shape: rounded-box; text-color: white; fill-color: #222C; stroke-mode: plain; padding: 3px, 2px; }" );
        nuevo.setAttribute("ui.stylesheet", "edge { text-alignment: under; text-offset: 0px, 4px; text-color: #444; }" );
        for (int i = 0; i < g.getUsuarios().getSize(); i++) {
            nuevo.addNode(aux.getUser().getId());

            aux=aux.getpNext();
        }
        for (Node node : nuevo) {
        node.setAttribute("ui.label", node.getId());
        node.setAttribute("xy", 1, 3);
    }
        String ver="";
        String ver1="";
        String ver2="";
        aux=g.getAmigos().getpFirst();
        for (int i = 0; i < g.getAmigos().getSize(); i++) {
            ver=aux.getAmigos().getId1().getId();
            ver1=aux.getAmigos().getId2().getId();
            ver2=ver+ver1;
            Edge edgi;
            edgi=nuevo.addEdge(ver2, ver, ver1, false);
            edgi.setAttribute("ui.label", aux.getAmigos().getTiempoAmistad());
            aux=aux.getpNext();
        }
    }
    
        
        
        
                  
}
