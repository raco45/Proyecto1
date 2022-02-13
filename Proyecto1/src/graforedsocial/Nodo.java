
package graforedsocial;

import Clases.Usuario;
import Clases.Amistades;

/**
 *
 * @author raco1
 */
public class Nodo {
    private Amistades amigos;
    private Usuario user;
    private Nodo pNext;
    
    
    public Nodo(Amistades element){
        this.amigos= element;
        this.pNext=null;
    }
    public Nodo(Usuario user){
        this.user= user;
        this.pNext=null;
    }

    /**
     * @return the amigos
     */
    public Amistades getAmigos() {
        return amigos;
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @return the pNext
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(Amistades amigos) {
        this.amigos = amigos;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    

    
    
}
