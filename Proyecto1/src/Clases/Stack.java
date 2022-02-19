/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import graforedsocial.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author AROMERO
 */
public class Stack {
    private Nodo top;
    private int size;
    
    public Stack(){
        top = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public void add(Usuario user){
        Nodo node = new Nodo(user);
        node.setpNext(node);
        top = node;
    }
    
    public Usuario delete() throws Exception{
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Pila vacia");            
        }
        Usuario aux = top.getUser();
        top = top.getpNext();
        return aux;
    }
    
    public Usuario top(){
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Pila vacia");
        }
        return top.getUser();
    }
}
