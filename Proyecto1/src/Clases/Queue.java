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

    public void add(Amistades a) {
        Nodo node = new Nodo(a);
        if (this.isEmpty()) {
            head = node;
        } else {
            tail.getpNext();
        }
        tail = node;
        size++;
    }
    
    //Funcion para eliminar elemento de la cola

    public Amistades delete() throws Exception {
        Amistades aux;
        if (!this.isEmpty()) {
            aux = head.getAmigos();
            head = head.getpNext();

        } else {
            throw new Exception("Eliminar de una cola vacia");
        }
        size--;
        return aux;

    }
    
    //Funcion que retorna el primero de la cola
    
    public Amistades peek() throws Exception{
        if (this.isEmpty()) {
            throw new Exception("Error: cola vacía");
        }
        return (head.getAmigos());
    }
}
