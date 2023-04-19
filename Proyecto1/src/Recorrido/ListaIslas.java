
package Recorrido;

import Clases.Usuario;
import graforedsocial.Lista;
import graforedsocial.Nodo;

/**
 *Lista que guarda la lista con usuarios que conforman una isla 
 * @author raco1
 */
public class ListaIslas {
    private NodoIsla pFirst;
    private NodoIsla pLast;
    private int size;
    
    
    public ListaIslas(){
        this.pFirst=null;
        this.pLast=null;
        this.size=0;
    }
    
    public void insertarUsuario(Lista isla){
        
        NodoIsla nuevo= new NodoIsla(isla);
        if(isVacio()){
            pFirst=nuevo;
            pLast=nuevo;
        }else{
            NodoIsla aux = pLast;
            aux.setpNext(nuevo);
            pLast=nuevo;
        }
        size+=1;
        }

        public boolean isVacio(){
            return pFirst==null;
        }
        
            
        
                
        

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the pFirst
     */
    public NodoIsla getpFirst() {
        return pFirst;
    }

    /**
     * @return the pLast
     */
    public NodoIsla getpLast() {
        return pLast;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoIsla pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(NodoIsla pLast) {
        this.pLast = pLast;
    }
}
