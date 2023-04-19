
package Recorrido;

import graforedsocial.Lista;

/**
 *
 * @author raco1
 */
public class NodoIsla {
    private Lista isla;
    private NodoIsla pNext;
    
    public NodoIsla(Lista isla){
        this.isla=isla;
        this.pNext=null;
    }

    /**
     * @return the isla
     */
    public Lista getIsla() {
        return isla;
    }

    /**
     * @return the pNext
     */
    public NodoIsla getpNext() {
        return pNext;
    }

    /**
     * @param isla the isla to set
     */
    public void setIsla(Lista isla) {
        this.isla = isla;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoIsla pNext) {
        this.pNext = pNext;
    }
}
