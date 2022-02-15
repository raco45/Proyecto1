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
     * Atributo
     */
    private String rutaArchivo;
    
    /**
     * Constructor
     * Description: Se encarga de crear el objeto ArchivoTxt y recibe por parametro el string de la 
     * @param ruta 
     */
    public ArchivoTxt(String ruta){
        
        this.rutaArchivo=ruta;
    }
    
    /**
     * 
     * Desciprtion: Metodo que se encarga de leer la informacion de un archivo txt, meter los usuarios en la lista de 
     * usuarios y meter las relaciones de amistad en la lista de amistades
     * @param usuarios
     * @param amistades 
     */
    public void leerTxt(Lista usuarios, Lista amistades){
        File file= new File(rutaArchivo);
        
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
                            usuario= new Usuario(line.split(", ")[0],line.split(", ")[1]);
                            if(usuario!=null){
                                usuarios.insertarUsuario(usuario);
                            }
                        }else if (readMode==2){
                            usuario=usuarios.buscarUser(line.split(", ")[0]);
                            usuarioAux=usuarios.buscarUser(line.split(", ")[1]);
                            arco= new Amistades(usuario,usuarioAux,Integer.parseInt(line.split(", ")[2]));
                            if(arco!=null){
                                amistades.insertarAmistad(arco);
                            }
                        }
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null,"Lectura exitosa.");
                                
            }catch(IOException ex){
                Logger.getLogger(ArchivoTxt.class.getName()).log(Level.SEVERE, null, ex);
               
            }
            
            
            
        }catch(FileNotFoundException ex){
            
            Logger.getLogger(ArchivoTxt.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    /**
     * Description: Se encarga de tomar la informacion de las listas de usuarios y amistades y escribirlas en
     * un archivo txt
     * @param usuarios
     * @param amistades 
     */
    public void escribirTxt(Lista usuarios, Lista amistades){
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
        
       
       
        
                
        
    
    
    
    
    
    

    /**
     * @return the rutaArchivo
     */
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    /**
     * @param rutaArchivo the rutaArchivo to set
     */
    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    
}
