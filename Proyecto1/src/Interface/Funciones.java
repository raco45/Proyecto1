
package Interface;

import Clases.Usuario;
import graforedsocial.GrafoMatriz;
import javax.swing.JOptionPane;

/**
 *Description: En esta clase se encuentran diferentes funcionalidades de validacion de datos y metodos a ser 
 * implementados en la iterfaz grafica 
 * 
 * @author raco1
 */
public class Funciones {
    
    
    
    /**
     * Funcion que verifica si un string es un numero 
     * @param cadena
     * @return retorna true si la cadena es string, false si no lo es 
     */
    public  boolean isNumeric(String cadena){

        try {
                Integer.parseInt(cadena);
                return true;
        } catch (NumberFormatException nfe){
                return false;
        }
    }
    
    public void whiteSpace(String cadena){
        cadena.replace(" ", "");
    }
    
    
    /**
     * Funcionalidad para botn añadir elementos del grafo de la interfaz, crea un nuevo usuario y verifica si es los datos 
     * son validos, tambien añade las relaciones  de amistad del nuevo usuario creado a la matriz del grafo
     * @param g
     * @param id
     * @param userName 
     */
    public boolean añadir(GrafoMatriz g,String id, String userName){
        userName.replace(" ", "");
        if(id.isBlank()||userName.isBlank()){
            JOptionPane.showMessageDialog(null,"Alguno de los campos esta vacio");
            return false;
        }else{
            if(this.isNumeric(id)&& !this.isNumeric(userName)){
                if(g.getUsuarios().buscarUser(id)!=null){
                    JOptionPane.showMessageDialog(null,"Este id ya esta asignado a otro usuario");
                    return false;
                }else if(g.getUsuarios().buscarUsarName("@"+userName)!=null){
                    JOptionPane.showMessageDialog(null,"Este nombre de usuario no esta disponible");
                    return false;
                }else{
                    //g.añadirUsuario(id, userName);
                    
                    Usuario aux= new Usuario(id, "@"+userName);
                    g.getUsuarios().insertarUsuario(aux);
                    JOptionPane.showMessageDialog(null,"Indique las relaciones de amistad con otros usuarios");
                    return true;
                }
        }else{
                 JOptionPane.showMessageDialog(null,"Error al ingresar los datos, por favor ingresa informacion valida ");   
                 return false;
            }
        }
    }
    
    public boolean añadirAmistad(GrafoMatriz g,String id, String userName, String peso){
        int tiempoAmis;
        userName.replace(" ", "");
        if(peso.isBlank()||userName.isBlank()){
            JOptionPane.showMessageDialog(null,"Alguno de los campos esta vacio");
            return false;
        }else {
             if(!this.isNumeric(peso)){
                JOptionPane.showMessageDialog(null,"Ingrese un numero valido");
                return false;
            }else if(Integer.parseInt(peso)<=0){
                JOptionPane.showMessageDialog(null,"El numero debe ser mayor que 0");
                return false;
            }
            tiempoAmis=Integer.parseInt(peso);
            Usuario creado=g.getUsuarios().buscarUser(id);
            Usuario amigo=g.getUsuarios().buscarUsarName("@"+userName);
            if(amigo==null){
                JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                return false;
            }else if(g.getAmigos().buscarAmistad(creado, amigo)==true){
                JOptionPane.showMessageDialog(null,"Este usuario ya es amigo de "+ creado.getUserName());
                return false;
            }else{
                g.setSizeUsers(g.getUsuarios().getSize());
             
                g.añadirAmistad(id, "@"+userName, tiempoAmis);
                g.actualizarMatriz();
                return true;
            }
        }
    }                    
     
    /**
     * Elimina un usuario y sus relaciones de amistad del grafo 
     * @param g
     * @param userElimar 
     */
    
    public void eliminar(GrafoMatriz g, String userElimar){
        g.eliminarUsuario("@"+userElimar);
        g.actualizarMatriz();
    }
    
    
}
                
        
        