
package Recorrido;

import Clases.Amistades;
import graforedsocial.GrafoMatriz;
import graforedsocial.Lista;
import graforedsocial.Nodo;

/**
 * Clase creada para implementar el metodo de identificacion de puentes dentro del grafo
 * @author raco1
 */
public class Puentes {
    /**
     * Este metodo se encarga de evaluar los casos en los que si una arista del grafo es eliminada genera 
     * mas islas dentro del grafo
     * @param g 
     */
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
