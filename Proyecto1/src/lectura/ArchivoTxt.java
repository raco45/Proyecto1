/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import Clases.Amistades;
import Clases.Usuario;
import graforedsocial.Lista;
import graforedsocial.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *Clase ArchivoTxt
 * 
 * Description: Clase creada para manejar los archivos de texto
 * 
 * @author raco1
 */
public class ArchivoTxt {
   
    
    
    /**
     * Constructor
     * Description: Se encarga de crear el objeto ArchivoTxt 
      
     */
    public ArchivoTxt(){
        
    }
        
    
    /**
     * 
     * Desciprtion: Metodo que se encarga de leer la informacion de un archivo txt, meter los usuarios en la lista de 
     * usuarios y meter las relaciones de amistad en la lista de amistades
     * @param usuarios
     * @param amistades 
     */
    public UsersArcos leerTxt(String rutaArchivo){
        File file= new File(rutaArchivo);
        Lista usuarios = new Lista();
        Lista amistades= new Lista();
        try{
            FileReader fileReader;
            fileReader= new FileReader(file);
            BufferedReader br= new BufferedReader(fileReader);
            
            String line;
            try{
                int readMode=0;
                
                Usuario usuario=null;
                Usuario usuarioAux=null;
                Amistades arco=null;
                
                while ((line=br.readLine())!=null){
                    if(line.equals("Usuarios")){
                        readMode=1;
                    }else if(line.equals("Relaciones")){
                        readMode=2;
                    }else{
                        if(readMode==1){
                            usuario= new Usuario(line.replace(" ", "").split(",")[0],line.replace(" ", "").split(",")[1]);
                            if(usuario!=null){
                                usuarios.insertarUsuario(usuario);
                            }
                        }else if (readMode==2){
                            usuario=usuarios.buscarUser(line.replace(" ", "").split(",")[0]);
                            usuarioAux=usuarios.buscarUser(line.replace(" ", "").split(",")[1]);
                            arco= new Amistades(usuario,usuarioAux,Integer.parseInt(line.replace(" ", "").split(",")[2]));
                            if(arco!=null){
                                amistades.insertarAmistad(arco);
                            }
                        }
                    }
                }
                br.close();
                UsersArcos help= new UsersArcos(usuarios,amistades);
                JOptionPane.showMessageDialog(null,"Lectura exitosa.");
                return help;
                
                                
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null,"Error de lectura, se procedera a cargar un archivo por default");
                
                return null;
            }
        }catch(FileNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,"No se encontro el archivo, se procedera a cargar un archivo por default");
            return null;
            
            
        }
         
    }
            
            
            
    
    /**
     * Description: Se encarga de tomar la informacion de las listas de usuarios y amistades y escribirlas 
     * en un archivo txt
     * @param usuarios
     * @param amistades 
     */
    public void escribirTxt(Lista usuarios, Lista amistades, String rutaArchivo){
        String users="Usuarios"+"\n";
        String frends="Relaciones"+"\n";
        String escritura;
        if(!usuarios.isVacio()&&!amistades.isVacio()){
            Nodo temp= usuarios.getpFirst();
            for (int i = 0; i < usuarios.getSize(); i++) {
                users+=temp.getUser().getId()+", "+temp.getUser().getUserName()+"\n";
                temp=temp.getpNext();
            }
            Nodo aux=amistades.getpFirst();
            for (int i = 0; i < amistades.getSize(); i++) {
                frends+=aux.getAmigos().getId1().getId()+", "+aux.getAmigos().getId2().getId()+", "+Integer.toString(aux.getAmigos().getTiempoAmistad())+"\n";
                aux=aux.getpNext();
            }
        }
        try{
            escritura=users+frends;
            PrintWriter pw = new PrintWriter(rutaArchivo);
            pw.print(escritura);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error de lectura");
        }
    }
        
       
       
        
                
        
    
    
    
    
    
}
