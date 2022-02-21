
package graforedsocial;


import Clases.Amistades;
import Clases.Usuario;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *Clase GrafoMatriz
 * 
 * Description: Clase utilizada para crear un grafo
 * 
 * @author raco1
 */
public class GrafoMatriz {
    //Atributos
    
    /**
     * Lista de Usuarios
     */
    private Lista usuarios;
    /**
     * Lista de amistades 
     */
    private Lista amigos;
    /**
     * arreglo bidimensional
     */
    private  int [][] matriz;
    /**
     * Cantidad de usuarios
     */
    private int sizeUsers;
    
    // Constructores
    /**
     * Constructor con 2 parametros
     * @param Usuarios(Lista de usuarios)
     * @param Amigos(Lista de las relaciones de amistad de los usuarios) 
     */
    public GrafoMatriz(Lista usuarios, Lista amigos ){
        this.usuarios=usuarios;
        this.amigos=amigos;
        this.sizeUsers=usuarios.getSize();
        
    }
    
    //Metodos
    /**
    Se encarga de iniciar la matriz
    */
    public void generarM(){
        int tam=getSizeUsers();
        setMatriz(new int [tam][tam]);
        for (int i = 0; i < getSizeUsers(); i++){
            for (int j = 0; i < getSizeUsers(); i++){
                getMatriz()[i][j] = 0;
            }
        }
    }
    /**
     * Se encarga de llenar la matriz con el tiempo de amistad entre las relaciones de amistad
     */
    public void llenarMatriz(){
        String inicio;
        String fina;
        int peso;
        int numAl=0;
        int numIl=0;
        
        
        try{
            
        for (Nodo amigo=getAmigos().getpFirst(); amigo!=null; amigo=amigo.getpNext()  ) {
            inicio=amigo.getAmigos().getId1().getId();
            fina=amigo.getAmigos().getId2().getId();
            peso=amigo.getAmigos().getTiempoAmistad();
            
            for (int i = 0; i < getUsuarios().getSize(); i++) {
                String id= getUsuarios().getUsuario(i).getId();
                if(inicio.equals(id)){
                    numAl=i;
                }
            }
            for (int k = 0; k < getUsuarios().getSize(); k++) {
                String id=getUsuarios().getUsuario(k).getId();
                if(fina.equals(id)){
                    numIl=k;
                }
            }
                getMatriz()[numAl][numIl]=peso;
                getMatriz()[numIl][numAl]=peso;
        }
        }catch (Exception err){
            JOptionPane.showMessageDialog(null, "Una lista esta vacia");
        }
    }

        
        
    /**
     * Imprime la matriz de adyacencia (Esta aqui temporalmente)
     */
    public void imprimirGrafo(){
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        

        

        System.out.print(" ");
        for(int i = 0; i < getSizeUsers(); i++)
        {
                System.out.printf("    | "+getUsuarios().getUsuario(i).getId()+"| " );
        }
        System.out.println();
        for( int i = 0; i < getSizeUsers(); i++){
                System.out.print(verde+getUsuarios().getUsuario(i).getId());
                for(int j = 0; j < getSizeUsers(); j++){
                    if(getMatriz()[i][j]==0){
                        System.out.printf(verde+"   %3d     " , getMatriz()[i][j]);
                    }else if (getMatriz()[i][j]!=0){
                        System.out.printf(amarillo+"   %3d     " , getMatriz()[i][j]);
                    }
                        
                }
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }        
}
    
    public void añadirAmistad(String id, String userName2, int peso){
        Usuario user1= usuarios.buscarUser(id);
        Usuario user2=usuarios.buscarUsarName(userName2);
        Amistades amistad= new Amistades(user1, user2, peso);
        amigos.insertarAmistad(amistad);
        
    }
    public void añadirUsuario(String id, String userName){
        Usuario user= new Usuario(id,"@"+userName);
        usuarios.insertarUsuario(user);
        sizeUsers=usuarios.getSize();
        JOptionPane.showMessageDialog(null,"El usuario se creo con exito");
    }
    public void eliminarUsuario(String userName){
        Usuario aux= usuarios.buscarUsarName(userName);
        if(aux!=null){
            usuarios.eliminarUsuario(aux.getId());
            amigos.eliminarAmistad(aux.getId());
            JOptionPane.showMessageDialog(null,"El usuario y sus relaciones de amistad fueron eliminadas");
        }else{
            JOptionPane.showMessageDialog(null,"No se encontro el usuario");
        }
    }

        
        
            
        

    public void actualizarMatriz(){
        this.generarM();
        this.llenarMatriz();
    }
    
        
        
 

     
     
  



    /**
     * @return the amigos
     */
    public Lista getAmigos() {
        return amigos;
    }

    /**
     * @return the matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
     * @return the sizeUsers
     */
    public int getSizeUsers() {
        return sizeUsers;
    }

    /**
     * @return the usuarios
     */
    public Lista getUsuarios() {
        return usuarios;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(Lista amigos) {
        this.amigos = amigos;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * @param sizeUsers the sizeUsers to set
     */
    public void setSizeUsers(int sizeUsers) {
        this.sizeUsers = sizeUsers;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Lista usuarios) {
        this.usuarios = usuarios;
    }

    
    
    
    
 }   
                    
                    
                
                            
                            
                              
                                
                                
                                
                            
                            
                    
                    
    
                
                
        
      
      
      

        
        