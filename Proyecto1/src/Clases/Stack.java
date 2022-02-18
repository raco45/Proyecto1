/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import graforedsocial.Nodo;

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
    
    public void add(Amistades a){
        Nodo node = new Nodo(a);
        node.setpNext(node);
        top = node;
    }
    
    public Amistades delete() throws Exception{
        if (this.isEmpty()) {
            throw new Exception ("Pila vacía, no se puede extraer.");            
        }
        Amistades aux = top.getAmigos();
        top = top.getpNext();
        return aux;
    }
    
    public Amistades top() throws Exception{
        if (this.isEmpty()) {
            throw new Exception ("Pila vacía, no se puede leer cima.");
        }
        return top.getAmigos();
    }
}
