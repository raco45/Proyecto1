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
//Implementacion de Cola con lista enlazada
public class Queue { //Clase Cola

    private Nodo head;
    private Nodo tail;
    private int size;

    public Queue() { //Constructor de la Cola
        head = tail = null;
        size = 0;
    }

    //Funcion para comprobar si la cola esta vacia
    public boolean isEmpty() {
        return head == null;
    }

    //Funcion para a;adir elemento a la cola
    public void add(Usuario user) {
        Nodo node = new Nodo(user);
        if (this.isEmpty()) {
            head = node;
        } else {
            tail.getpNext();
        }
        tail = node;
        size++;
    }

    //Funcion para eliminar elemento de la cola
    public Usuario delete() {
        Usuario aux = null;
        if (!this.isEmpty()) {
            aux = head.getUser();
            head = head.getpNext();

        } else {
            JOptionPane.showMessageDialog(null, "Error. Cola vacia");
        }
        size--;
        return aux;
    }

    //Funcion que retorna el primero de la cola
    public Usuario peek() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Cola vacia");
        }
        return (head.getUser());
    }
    
    //Funcion tama;o
    public int getSize(){
        return size;
    }
    
}
