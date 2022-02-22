
package Clases;

/**
 * Description: Clase que se encarga de  crear la relacion de amistad que existe entre dos usarios
 * 
 * @author raco1
 */
public class Amistades {
    private Usuario id1;
    private Usuario id2;
    private int tiempoAmistad;
    
    /**
     * Constructor de la clase Amistades 
     * @param id1
     * @param id2
     * @param tiempo 
     */
    public Amistades(Usuario id1, Usuario id2, int tiempo){
        this.id1=id1;
        this.id2=id2;
        this.tiempoAmistad=tiempo;
        
    }
    

    /**
     * @return the id1
     */
    public Usuario getId1() {
        return id1;
    }

    /**
     * @return the id2
     */
    public Usuario getId2() {
        return id2;
    }

    /**
     * @return the tiempoAmistad
     */
    public int getTiempoAmistad() {
        return tiempoAmistad;
    }

    /**
     * @param id1 the id1 to set
     */
    public void setId1(Usuario id1) {
        this.id1 = id1;
    }

    /**
     * @param id2 the id2 to set
     */
    public void setId2(Usuario id2) {
        this.id2 = id2;
    }

    /**
     * @param tiempoAmistad the tiempoAmistad to set
     */
    public void setTiempoAmistad(int tiempoAmistad) {
        this.tiempoAmistad = tiempoAmistad;
    }
    
    
}
