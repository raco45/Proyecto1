/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author AROMERO
 */
public class Node {
    private int vertex;
    private Node pnext;
    
    public Node(int n){
        this.vertex = n;
        this.pnext = null;
    }

    /**
     * @return the vertex
     */
    public int getVertex() {
        return vertex;
    }

    /**
     * @param n the vertex to set
     */
    public void setVertex(int n) {
        this.vertex = n;
    }

    /**
     * @return the pnext
     */
    public Node getPnext() {
        return pnext;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setPnext(Node pnext) {
        this.pnext = pnext;
    }
}
