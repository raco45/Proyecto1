
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
    public void añadir(GrafoMatriz g,String id, String userName){
        userName.replace(" ", "");
        if(id.isBlank()||userName.isBlank()){
            JOptionPane.showMessageDialog(null,"Alguno de los campos esta vacio");
        }else{
            if(this.isNumeric(id)&& !this.isNumeric(userName)){
                if(g.getUsuarios().buscarUser(id)!=null){
                    JOptionPane.showMessageDialog(null,"Este id ya esta asignado a otro usuario");
                }else if(g.getUsuarios().buscarUsarName("@"+userName)!=null){
                    JOptionPane.showMessageDialog(null,"Este nombre de usuario no esta disponible");
                }else{
                    g.añadirUsuario(id, userName);
                    JOptionPane.showMessageDialog(null,"Indique las relaciones de amistad con otros usuarios");
                    boolean var=true;
                    while(var==true){
                        Usuario id1= g.getUsuarios().buscarUser(id);
                        String input= JOptionPane.showInputDialog(null,"Indica el usuario del que quieres ser amigo (No es necesario poner @)");
                        Usuario id2=g.getUsuarios().buscarUsarName("@"+input);
                        if(id2==null){
                            JOptionPane.showMessageDialog(null,"El usuario ingresado no existe");
                            var=true;
                        }else if(id2==id1){
                            JOptionPane.showMessageDialog(null,"No puedes ser amigo de ti mismo");
                        }else if(g.getAmigos().buscarAmistad(id1, id2)){
                             JOptionPane.showMessageDialog(null, "Este usuario ya es amigo de "+id1.getUserName());
                        }
                        else if(id2!=id1||id2!=null){
                            int peso;
                            String input2;
                            while(true){
                                input2=JOptionPane.showInputDialog(null,"Indique el tiempo de amistad que tiene con su amigo");
                                if(this.isNumeric(input2)&& Integer.parseInt(input2)>0){
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,"Debe ingresar un numero valido");
                                }
                            }
                            peso=Integer.parseInt(input2);
                            g.añadirAmistad(id, id2.getUserName(), peso);
                            JOptionPane.showMessageDialog(null,userName+ " ahora es amigo de "+id2.getUserName());
                            int sele= JOptionPane.showOptionDialog(null,"¿Desea añadir mas amigos al usuario creado?", " ", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "SI", "NO" }, "SI");
                            if(sele==0){
                                var=true;
                            }else{
                                var=false;
                                JOptionPane.showMessageDialog(null,"El usuario "+ userName +" y sus relaciones de amistad fueron creadas con exito");
                            }
                        }
                    }
                }
        }else{
                 JOptionPane.showMessageDialog(null,"Error al ingresar los datos, por favor ingresa informacion valida ");   
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
                
        
        