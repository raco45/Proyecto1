
package Clases;

import graforedsocial.Lista;

/**
 *
 * @author raco1
 */
public class Usuario {
    private String id;
    private String userName;
    private Lista listaAmigos;
    private boolean visited;
    
    
    public Usuario(String id, String userName){
        this.id=id;
        this.userName=userName;
        this.listaAmigos=null;
        this.visited = false;
        
    }
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the listaAmigos
     */
    public Lista getListaAmigos() {
        return listaAmigos;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param listaAmigos the listaAmigos to set
     */
    public void setListaAmigos(Lista listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    
}
