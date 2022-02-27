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
    private int size;
    
    public Stack() {
        top = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return getTop() == null;
    }
    
    public void push(int user) {
        Node node = new Node(user);
        node.setPnext(node);
        setTop(node);
        size++;
    }
    
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
