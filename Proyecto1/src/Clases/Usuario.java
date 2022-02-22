
package Clases;

import graforedsocial.Lista;

/**
 * Description: Clase que guarda la informacion del usuario 
 * 
 * @author raco1
 */
public class Usuario {
    private String id;
    private String userName;
    private Lista listaAmigos;
    
    /**
     * Constructor de la clase usuario
     * @param id
     * @param userName 
     */
    public Usuario(String id, String userName){
        this.id=id;
        this.userName=userName;
        this.listaAmigos=null; 
        
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
    
    
}
