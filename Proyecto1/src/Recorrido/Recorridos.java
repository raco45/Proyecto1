
package Recorrido;

import Clases.Usuario;
import graforedsocial.GrafoMatriz;
import graforedsocial.Lista;
import graforedsocial.Nodo;

/**
 *Clase que se encarga de llamar a los recorridos de Anchura y profundidad en el grafo
 * @author raco1
 */
public class Recorridos {

    

    /**
     * Funcion que se encarga de recorrer en anchura todos los nodos conectados en el grafo si no han sido recorridos todavia
     * @param g
     * @param id(usuario desde donde se quiere empezar a recorrer)
     * @param marcado
     * @return retorna una lista de los usuarios que forman una isla en el grafo
     */
    public Lista bfs(GrafoMatriz g, String id, boolean[] marcado){
        Nodo pos= g.getUsuarios().buscarNodo(id);
        int v=g.getUsuarios().getPosicion(pos);
        Lista orden= new Lista();
        Queue cola= new Queue();
        marcado[v]=true;
        cola.add(v);
        while(!cola.isEmpty()){
            int ac= cola.delete();
            Usuario help = g.getUsuarios().getUsuario(ac);
            orden.insertarUsuario(help);
            for (int i = 0; i < g.getSizeUsers(); i++) {
                if(i!=ac && g.getMatriz()[ac][i]!=0&&marcado[i]!=true){
                    help=g.getUsuarios().getUsuario(i);
                    orden.insertarUsuario(help);
                    cola.add(i);
                    marcado[i]=true;
                }
            }
        }
        return orden;
    }
    
    /**
     * Funcion que se encarga de encontrar las islas dentro del grafo usando el recorrido de anchura y guardarlas en una lista
     * @param g
     * @return Retorna una lista con las islas encontradas
     */
    public ListaIslas recorridoDeAnchura(GrafoMatriz g){
        ListaIslas cantIslas= new ListaIslas();
        int contIslas=0;
        boolean[] marcado= new boolean[g.getSizeUsers()];
        for (int i = 0; i < marcado.length; i++) {
            marcado[i]=false;
        }
        String idNoVisitado;
        boolean fin=true;
        while(fin==true){
            for (int i = 0; i < marcado.length; i++) {
                if(marcado[i]==false){
                    idNoVisitado=g.getUsuarios().getUsuario(i).getId();
                    cantIslas.insertarUsuario(this.bfs(g, idNoVisitado, marcado));
                }
            }
            fin=false;
            
        }
        contIslas=cantIslas.getSize();
        
        return cantIslas;
    }
        
    /**
     * Funcion que se encarga de recorrer en profundidad todos los nodos conectados que hay en el grafo si no han sido recorridos todavia 
     * @param g
     * @param id
     * @param marcado
     * @return Retorna una lista de usuarios que forman una isla en el grafo
     */
    public Lista dfs(GrafoMatriz g, String id, boolean[] marcado){
        Nodo pos= g.getUsuarios().buscarNodo(id);
        int v=g.getUsuarios().getPosicion(pos);
        Lista orden= new Lista();
        //boolean [] marcado= new boolean[g.getSizeUsers()];
        Stack pila= new Stack();
        marcado[v]=true;
        pila.push(v);
        while(!pila.isEmpty()){
            int ac= pila.pop();
            Usuario help = g.getUsuarios().getUsuario(ac);
            orden.insertarUsuario(help);
            for (int i = 0; i < g.getSizeUsers(); i++) {
                if(i!=ac && g.getMatriz()[ac][i]!=0&&marcado[i]!=true){
                    help=g.getUsuarios().getUsuario(i);
                    orden.insertarUsuario(help);
                    pila.push(i);
                    marcado[i]=true;
                    
                }
            }
        }
        return orden;
    }
    /**
     * Funcion que se encarga de encontrar las islas dentro del grafo usando el recorrido de profundidad y guardarlas en una lista
     * @param g
     * @return Retorna una lista con las islas encontradas
     */
    public ListaIslas recorridoDeProfundidad(GrafoMatriz g){
        ListaIslas cantIslas= new ListaIslas();
        int contIslas=0;
        boolean[] marcado= new boolean[g.getSizeUsers()];
        for (int i = 0; i < marcado.length; i++) {
            marcado[i]=false;
        }
        String idNoVisitado;
        boolean fin=true;
        while(fin==true){
            for (int i = 0; i < marcado.length; i++) {
                if(marcado[i]==false){
                    idNoVisitado=g.getUsuarios().getUsuario(i).getId();
                    cantIslas.insertarUsuario(this.dfs(g, idNoVisitado, marcado));
                }
            }
            fin=false;
            
        }
        contIslas=cantIslas.getSize();
        
        return cantIslas;
        
        
    }
}
