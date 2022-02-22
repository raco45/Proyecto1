
package mostrarGrafo;
import graforedsocial.GrafoMatriz;
import graforedsocial.Nodo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.spriteManager.*;
/**
 *
 * @author raco1
 */
public class Mostrar {
    
    public void mostrarGrafos(GrafoMatriz g){
        System.setProperty("org.graphstream.ui", "swing");
        Graph nuevo= new SingleGraph("prueba");
        SpriteManager sman = new SpriteManager(nuevo);
        Nodo aux=g.getUsuarios().getpFirst();
        Sprite s;
        for (int i = 0; i < g.getUsuarios().getSize(); i++) {
            nuevo.addNode(aux.getUser().getId());
            s= sman.addSprite(aux.getUser().getId());
            s.attachToNode(aux.getUser().getId());
            aux=aux.getpNext();
        }
        String ver="";
        String ver1="";
        String ver2="";
        aux=g.getAmigos().getpFirst();
        for (int i = 0; i < g.getAmigos().getSize(); i++) {
            ver=aux.getAmigos().getId1().getId();
            ver1=aux.getAmigos().getId2().getId();
            ver2=ver+ver1;
            nuevo.addEdge(ver2, ver, ver1, false);
            aux=aux.getpNext();
        }
       
            
        nuevo.display();
    }
}
