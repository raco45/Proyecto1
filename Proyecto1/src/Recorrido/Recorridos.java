
package Recorrido;

import Clases.Usuario;
import graforedsocial.GrafoMatriz;
import graforedsocial.Lista;
import graforedsocial.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author raco1
 */
public class Recorridos {
    
//    public Queue BFS(GrafoMatriz g, String id) {
//        Nodo u = g.getUsuarios().buscarNodo(id);
//        int v, w;
//        Queue q = new Queue();
//        int[] m;
//        m = new int[g.getSizeUsers()];
//        v = g.getUsuarios().getPosicion(u);
//        if (v < 0) {
//            System.out.println("Error");
//        }
//        for (int i = 0; i < g.getSizeUsers(); i++) {
//            m[i] = 0;
//        }
//        m[v] = 0;
//        q.add(v);
//        while (!q.isEmpty()) {
//            int cw;
//            cw = q.delete();
//            w = cw;
//
//            for (int j = 0; j < g.getSizeUsers(); j++) {
//                if ((g.getMatriz()[w][j] != 0) && (m[j] == 0)) {
//                    m[j] = m[w] + 1;
//                    q.add(j);
//                }
//
//            }
//
//        }
//        return q;
//    }
    


    public Lista bfs(GrafoMatriz g, String id, boolean[] marcado){
        Nodo pos= g.getUsuarios().buscarNodo(id);
        int v=g.getUsuarios().getPosicion(pos);
        Lista orden= new Lista();
        //boolean [] marcado= new boolean[g.getSizeUsers()];
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
        //JOptionPane.showMessageDialog(null,"La cantidad de islas en el grafo es de: " + Integer.toString(contIslas) );
        return cantIslas;
        
        
    }
}
