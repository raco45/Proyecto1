
package Recorrido;

import Clases.Amistades;
import graforedsocial.GrafoMatriz;
import graforedsocial.Lista;
import graforedsocial.Nodo;

/**
 *
 * @author raco1
 */
public class Puentes {
    
    public void identificarPuentes(GrafoMatriz g){
        Recorridos reco=new Recorridos();
        Lista puentes= new Lista();
        Nodo aux= g.getAmigos().getpFirst();
        int cont= reco.recorridoDeAnchura(g).getSize();
        for (int i = 0; i < g.getAmigos().getSize(); i++) {
            Amistades help= aux.getAmigos();
            g.getAmigos().eliminarRelacion(help);
            g.actualizarMatriz();
            int prueba= reco.recorridoDeAnchura(g).getSize();
            if(prueba>cont){
                puentes.insertarAmistad(help);
            }
            g.getAmigos().insertarAmistad(help);
            g.actualizarMatriz();
            aux=aux.getpNext();
        }
        puentes.imprimirAmistades();
        
            
    }
}
