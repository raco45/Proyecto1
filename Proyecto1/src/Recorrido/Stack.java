/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recorrido;

import graforedsocial.Nodo;

/**
 *
 * @author AROMERO
 */
public class Stack {
    private Node top;
    Node base;
    private int size;
    
    public Stack() {
        top = null;
        size = 0;
    }
    /**
     * Funcion que verifica si la pila esta vacia
     * @return 
     */
    public boolean isEmpty() {
        return top == null;
    }
    /**
     * Funcion que apila un elemento a la pila 
     * @param user 
     */
    public void push(int user) {
        Node nuevo =new Node(user); 
        if (this.isEmpty()) {
        top = base = nuevo;
        }else{
        nuevo.setPnext(top);
        top = nuevo;
        }
        size++;

    }
    /**
     * Funcion que desapila un elemento de la pila
     * @return retorna el elemento desapilado
     */
    public int pop(){
        int n = 0;
        if (!this.isEmpty()) {
            n = top.getVertex();
            top = top.getPnext();
            size--;
        }
       return n; 
    }
    public int peek(){
        return top.getVertex();
    }

    /**
     * @return the top
     */
    public Node getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(Node top) {
        this.top = top;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
