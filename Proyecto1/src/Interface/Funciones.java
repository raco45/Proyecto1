
package Interface;

import Clases.Usuario;
import graforedsocial.GrafoMatriz;
import javax.swing.JOptionPane;

/**
 *
 * @author raco1
 */
public class Funciones {
    
    
    
    
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
                        }else if(id2!=id1||id2!=null){
                            int peso;
                            String input2=JOptionPane.showInputDialog(null,"Indique el tiempo de amistad que tiene con su amigo");
                            while(true){
                                if(this.isNumeric(input2)){
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,"Debe ingresar un numero valido");
                                }
                            }
                            peso=Integer.parseInt(input2);
                            g.añadirAmistad(id, id2.getId(), peso);
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
    
    
}
                
        
        