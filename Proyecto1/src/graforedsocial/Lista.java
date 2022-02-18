
package graforedsocial;


import Clases.Usuario;
import Clases.Amistades;
import javax.swing.JOptionPane;

/**
 *Clase Lista
 * Se utiliza para guardar un conjunto de datos
 * @author raco1
 */
public class Lista {
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    
    
    public Lista(){
        this.pFirst=null;
        this.pLast=null;
        this.size=0;
                
        
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
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
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
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }
    
    /**
     * Determina si la lista esta vacia
     * @return Retorna un boolean que indica el estado de la lista
     */
    public boolean isVacio(){
        return pFirst==null;
    }
    
    /**
     * Agrega un elemento al final de la lista 
     * @param user
     */
    public void insertarUsuario(Usuario user){
        Usuario help=this.buscarUser(user.getId());
        if(help==null){
            
            Nodo nuevo= new Nodo(user);
            if(isVacio()){
                pFirst=nuevo;
                pLast=nuevo;
            }else{
                Nodo aux = pLast;
                aux.setpNext(nuevo);
                pLast=nuevo;
            }
            size+=1;
        }else if(help!=null){
            JOptionPane.showMessageDialog(null,"Este usuario ya existe");
        }
    }

    /**
     * se encarga de insertar una amistad a la lista de amistades
     * @param amistad 
     */
    public void insertarAmistad(Amistades amistad){
        Nodo nuevo= new Nodo(amistad);
        if(isVacio()){
            pFirst=nuevo;
            pLast=nuevo;
        }else{
            Nodo aux = pLast;
            aux.setpNext(nuevo);
            pLast=nuevo;
        }
        size+=1;
    }
    
    public void eliminarUsuario(String id){
        Nodo actual, anterior;
        boolean encontrado;
        
        actual=pFirst;
        anterior= null;
        encontrado = false;
        while((actual!=null)&&!encontrado){
            encontrado= actual.getUser().getId().equals(id);
            
            if(!encontrado){
                anterior=actual;
                actual=actual.getpNext();
            }
        }
        if(actual!=null){
            if(actual==pFirst){
                pFirst=actual.getpNext();
            }
            else{
                anterior.setpNext(actual.getpNext());
            }
            actual=null;
        }
        size--;
    }
    public void eliminarAmistad(String id){
        int cont=0;
        Nodo aux=pFirst;
        for (int i = 0; i < this.getSize(); i++) {
            if(aux.getAmigos().getId1().getId().equals(id)||aux.getAmigos().getId2().getId().equals(id)){
            cont++;
            }
            aux=aux.getpNext();
           
        }
            Nodo actual, anterior;
            boolean encontrado;
            actual=pFirst;
            anterior= null;
            encontrado = false;
            while((actual!=null)&&!encontrado){
                String id1=actual.getAmigos().getId1().getId();
                String id2=actual.getAmigos().getId2().getId();
                encontrado= id1.equals(id)||id2.equals(id);

                if(!encontrado){
                    anterior=actual;
                    actual=actual.getpNext();
                }
            }
            if(actual!=null){
                if(actual==pFirst){
                    pFirst=actual.getpNext();
                    size--;
                }
                else{
                    anterior.setpNext(actual.getpNext());
                    size--;
                }
                actual=null;
            }
            
            
        if(cont!=0){
            this.eliminarAmistad(id);
        }else{
            JOptionPane.showMessageDialog(null,"Borrado con exito");
        }
    }
        
        
    public Nodo buscarNodo(String id){
        Nodo aux;
        for (aux = pFirst; aux !=null  ; aux=aux.getpNext()) {
            if(id.equals(aux.getUser().getId())){
                return aux;
            }
        }
        return null;
    }

//            
       /**
        * Se encarga de imprimir la lista de usarios
        */         
     public void imprimir(){
        String mostrar="";
        if(!isVacio()){
            Nodo aux = pFirst;
            for (int i = 0; i < size; i++) {
                mostrar+=aux.getUser().getId()+"\n";
                //System.out.print(aux.getDato()+ "\n ");
                aux = aux.getpNext();
            }
            JOptionPane.showMessageDialog(null,mostrar );
        } else{
            System.out.println("Lista vacia");
        }
    }

                
    /**
     * Se encarga de imprimir la lista de Amistades
     */            
     public void imprimirAmistades(){
        String mostrar="";
        if(!isVacio()){
            Nodo aux = pFirst;
            for (int i = 0; i < size; i++) {
                mostrar+=aux.getAmigos().getId1().getId()+", "+ aux.getAmigos().getId2().getId()+ ", "+ aux.getAmigos().getTiempoAmistad() +"\n";
                
                aux = aux.getpNext();
            }
            JOptionPane.showMessageDialog(null,mostrar );
        } else{
            System.out.println("Lista vacia");
        }
    }

/**
 * Busca el elemento de la lista indicaco por el id
 * @param id
 * @return retorna el objeto usuario si fue encontrado
 */    
    public Usuario buscarUser(String id){
        Nodo aux;
        for (aux = pFirst; aux !=null  ; aux=aux.getpNext()) {
            if(id.equals(aux.getUser().getId())){
                return aux.getUser();
            }
        }
        return null;
    }       
//    
    /**
     * Busca el elemento de la lista indicado por indice
     * @param pos
     * @return Retorna el usuario que se pide
     */
    public Usuario getUsuario(int pos){
        if(!isVacio()&& pos<=size ){
            Nodo aux=pFirst;
            for (int i = 0; i < pos; i++) {
                aux=aux.getpNext();
            }
            return (Usuario) aux.getUser();
        }else{
            return null;
        }
        
        
    }
}
                
    
    
        
            
                
               
                
                
                
            
        
        
   
    
    
    
        
        
        
        
        
        
    
    
