/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recorrido;

import graforedsocial.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author AROMERO
 */
//Implementacion de Cola con lista enlazada
public class Queue { //Clase Cola

    private Node head;
    private Node tail;
    private int size;

     public Queue() { //Constructor de la Cola
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Funcion para comprobar si la cola esta vacia
    public boolean isEmpty() {
        return head == null;
    }

    //Funcion para a;adir elemento a la cola
    public void add(int user) {
        Node node = new Node(user);
        if (this.head==null) {
            head=node;
        } else {
            this.tail.setPnext(node);
        }
        tail=node;
        size+=1;
    }
    


    //Funcion para eliminar elemento de la cola
    public int delete() {
        Node temp=head;
        head=head.getPnext();
        //temp=null;
        size-=1;
        
        
        
        if(head==null){
            head=null;   
        }
        
        return temp.getVertex();
    }

    //Funcion que retorna el primero de la cola
    public int peek() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Cola vacia");
        }
        return head.getVertex();
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
