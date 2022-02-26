
package Main;
import Clases.Amistades;
import graforedsocial.GrafoMatriz;
import graforedsocial.Lista;
import Clases.Usuario;
import graforedsocial.Nodo;
import java.util.Arrays;
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
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Lista listaUsuarios= new Lista();
        Lista listaAmistades= new Lista();
        Usuario user1=new Usuario("121","armando");
        Usuario user2=new Usuario("254","pepe");
        Usuario user3=new Usuario("365","julio");
        Usuario user4=new Usuario("412","pedro");
        Usuario user5=new Usuario("512","pablo");
        Usuario user6=new Usuario("231","enrique");
        Usuario user7=new Usuario("123","juan");
        Usuario user8=new Usuario("129","ricardo");
        Usuario user9=new Usuario("870","alfonso");
        Usuario user10=new Usuario("758","eugenio");
        Usuario user11=new Usuario("909","roberto");
        Usuario user12=new Usuario("893","gabriel");
        Usuario user13=new Usuario("467","armonia");
        Usuario user14=new Usuario("788","paz");
        Usuario user15=new Usuario("239","manuel");
        Usuario user16=new Usuario("443","luis");
        Usuario user17=new Usuario("907","andrea");
        Usuario user18=new Usuario("578","dayana");
        
        
        listaUsuarios.insertarUsuario(user1);
        listaUsuarios.insertarUsuario(user2);
        listaUsuarios.insertarUsuario(user3);
        listaUsuarios.insertarUsuario(user4);
        listaUsuarios.insertarUsuario(user5);
        listaUsuarios.insertarUsuario(user6);
        listaUsuarios.insertarUsuario(user7);
        listaUsuarios.insertarUsuario(user8);
        listaUsuarios.insertarUsuario(user9);
        listaUsuarios.insertarUsuario(user10);
        listaUsuarios.insertarUsuario(user11);
        listaUsuarios.insertarUsuario(user12);
        listaUsuarios.insertarUsuario(user13);
        listaUsuarios.insertarUsuario(user14);
        listaUsuarios.insertarUsuario(user15);
        listaUsuarios.insertarUsuario(user16);
        listaUsuarios.insertarUsuario(user17);
        listaUsuarios.insertarUsuario(user18);
        
        
        Amistades ami1=new Amistades(user1,user2,7);
        Amistades ami2=new Amistades(user1,user11,8);
        Amistades ami3=new Amistades(user2,user11,5);
        Amistades ami4=new Amistades(user11,user12,5);
        Amistades ami5=new Amistades(user2,user12,1);
        Amistades ami6=new Amistades(user12,user8,3);
        Amistades ami7=new Amistades(user8,user5,10);
        Amistades ami8=new Amistades(user5,user4,2);
        Amistades ami9=new Amistades(user12,user4,4);
        Amistades ami10=new Amistades(user6,user9,5);
        Amistades ami11=new Amistades(user6,user7,1);
        Amistades ami12=new Amistades(user7,user9,15);
        Amistades ami13=new Amistades(user7,user13,6);
        Amistades ami14=new Amistades(user14,user15,7);
        Amistades ami15=new Amistades(user14,user16,11);
        Amistades ami16=new Amistades(user15,user16,6);
        Amistades ami17=new Amistades(user15,user17,3);
        Amistades ami18=new Amistades(user16,user17,9);
        Amistades ami19=new Amistades(user14,user4,7);
        Amistades ami20=new Amistades(user9,user18,7);
        Amistades ami21=new Amistades(user9,user10,1);
        Amistades ami22=new Amistades(user10,user3,9);
        Amistades ami23=new Amistades(user18,user3,4);
        listaAmistades.insertarAmistad(ami1);
        listaAmistades.insertarAmistad(ami2);
        listaAmistades.insertarAmistad(ami3);
        listaAmistades.insertarAmistad(ami4);
        listaAmistades.insertarAmistad(ami5);
        listaAmistades.insertarAmistad(ami6);
        listaAmistades.insertarAmistad(ami7);
        listaAmistades.insertarAmistad(ami8);
        listaAmistades.insertarAmistad(ami9);
        listaAmistades.insertarAmistad(ami10);
        listaAmistades.insertarAmistad(ami11);
        listaAmistades.insertarAmistad(ami12);
        listaAmistades.insertarAmistad(ami13);
        listaAmistades.insertarAmistad(ami14);
        listaAmistades.insertarAmistad(ami15);
        listaAmistades.insertarAmistad(ami16);
        listaAmistades.insertarAmistad(ami17);
        listaAmistades.insertarAmistad(ami18);
        listaAmistades.insertarAmistad(ami19);
        listaAmistades.insertarAmistad(ami20);
        listaAmistades.insertarAmistad(ami21);
        listaAmistades.insertarAmistad(ami22);
        listaAmistades.insertarAmistad(ami23);
        System.setProperty("org.graphstream.ui", "swing");
        GrafoMatriz grafo= new GrafoMatriz(listaUsuarios, listaAmistades);
        
        grafo.generarM();
        grafo.llenarMatriz();
        grafo.imprimirGrafo();
        
    //AQUI

        System.out.println(Arrays.toString(grafo.BFS(grafo, "254")));
        //System.out.println(grafo.countIslands(grafo));
        //System.out.println(grafo.count(grafo.getMatriz()));;
        //grafo.befs(grafo, "254");


        
        //System.setProperty("org.graphstream.ui", "swing");
        
        Graph nuevo= new SingleGraph("prueba");
        
        //SpriteManager sman = new SpriteManager(nuevo);
        Nodo aux=listaUsuarios.getpFirst();
        for (int i = 0; i < listaUsuarios.getSize(); i++) {
            //nuevo.addNode(aux.getUser().getId());
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
