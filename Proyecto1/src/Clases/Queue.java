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
public class Queue {
    private Node head;
    private Node tail;
    private int size;

    public Queue() { //Constructor de la Cola
        head = null;
        tail = null;
        size = 0;
    }

    //Funcion para comprobar si la cola esta vacia
    public boolean isEmpty() {
        return getHead() == null;
    }

    //Funcion para a;adir elemento a la cola
    public void add(int user) {
        Node node = new Node(user);
        if (this.isEmpty()) {
            setHead(node);
        } else {
            getTail().getPnext();
        }
        setTail(node);
        setSize(getSize() + 1);
    }
    


    //Funcion para eliminar elemento de la cola
    public int delete() {
        int v = getHead().getVertex();
        setHead(getHead().getPnext());
        if (this.isEmpty()) {
            setTail(null);
        } else {
            //JOptionPane.showMessageDialog(null, "Error. Cola vacia");
        }
        setSize(getSize() - 1);
        return v;
    }

    //Funcion que retorna el primero de la cola
    public int peek() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Cola vacia");
        }
        return (getHead().getVertex());
    }
    
    //Funcion tama;o
    public int getSize(){
        return size;
    }

    /**
     * @return the head
     */
    public Node getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public Node getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
