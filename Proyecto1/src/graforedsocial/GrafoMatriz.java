package graforedsocial;

import Clases.Stack;
import Clases.Queue;
import Clases.Stack;
import Clases.Usuario;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Clase GrafoMatriz
 *
 * Contiene la matriz de adyacencia
 *
 * @author raco1
 */
public class GrafoMatriz {
    //Atributos

    /**
     * Lista de Usuarios
     */
    private Lista usuarios;
    /**
     * array de amistades (probablemente se vaya a cambiar )
     */
    private Lista amigos;
    /**
     * arreglo bidimensional
     */
    private int[][] matriz;
    /**
     * Cantidad de usuarios
     */
    private int sizeUsers;

    // Constructores
    /**
     * Constructor con 2 parametros
     *
     * @param almacenes
     * @param arcos
     */
    public GrafoMatriz(Lista usuarios, Lista amigos) {
        this.usuarios = usuarios;
        this.amigos = amigos;
        this.sizeUsers = usuarios.getSize();

    }

    //Metodos
    /**
     * Se encarga de iniciar la matriz
     */
    public void generarM() {
        int tam = getSizeUsers();
        setMatriz(new int[tam][tam]);
        for (int i = 0; i < getSizeUsers(); i++) {
            for (int j = 0; i < getSizeUsers(); i++) {
                getMatriz()[i][j] = 0;
            }
        }
    }

    /**
     * Se encarga de llenar la matriz con la distancia de los caminos entre los
     * grafos
     */
    public void llenarMatriz() {
        String inicio;
        String fina;
        int peso;
        int numAl = 0;
        int numIl = 0;

        String verde = "\033[32m";
        String amarillo = "\033[33m";
        try {

            for (Nodo amigo = getAmigos().getpFirst(); amigo != null; amigo = amigo.getpNext()) {
                inicio = amigo.getAmigos().getId1().getId();
                fina = amigo.getAmigos().getId2().getId();
                peso = amigo.getAmigos().getTiempoAmistad();

                for (int i = 0; i < getUsuarios().getSize(); i++) {
                    String id = getUsuarios().getUsuario(i).getId();
                    if (inicio.equals(id)) {
                        numAl = i;
                    }
                }
                for (int k = 0; k < getUsuarios().getSize(); k++) {
                    String id = getUsuarios().getUsuario(k).getId();
                    if (fina.equals(id)) {
                        numIl = k;
                    }
                }
                getMatriz()[numAl][numIl] = peso;
                getMatriz()[numIl][numAl] = peso;
            }

        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Una lista esta vacia");
        }
    }

    /**
     * Imprime la matriz de adyacencia (Esta aqui temporalmente)
     */
    public void imprimirGrafo() {
        String verde = "\033[32m";
        String amarillo = "\033[33m";

//        for(int i=0; i <matriz.length; i++ ){
//            for(int j=0; j< matriz[i].length;j++){
//                if(matriz[i][j]!=0){
//                    System.out.print(verde+matriz[i][j]+ " | ");
//                }else{
//                    System.out.print(amarillo+matriz[i][j]+ " | ");
//                    
//                }
//            }
//            System.out.println();
//        }
        System.out.print(" ");
        for (int i = 0; i < getSizeUsers(); i++) {
            System.out.printf("    | " + getUsuarios().getUsuario(i).getId() + "| ");
        }
        System.out.println();
        for (int i = 0; i < getSizeUsers(); i++) {
            System.out.print(verde + getUsuarios().getUsuario(i).getId());
            for (int j = 0; j < getSizeUsers(); j++) {
                if (getMatriz()[i][j] == 0) {
                    System.out.printf(verde + "   %3d     ", getMatriz()[i][j]);
                } else if (getMatriz()[i][j] != 0) {
                    System.out.printf(amarillo + "   %3d     ", getMatriz()[i][j]);
                }

            }
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

    }


    /**
     * @return the amigos
     */
    public Lista getAmigos() {
        return amigos;
    }

    /**
     * @return the matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
     * @return the sizeUsers
     */
    public int getSizeUsers() {
        return sizeUsers;
    }

    /**
     * @return the usuarios
     */
    public Lista getUsuarios() {
        return usuarios;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(Lista amigos) {
        this.amigos = amigos;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * @param sizeUsers the sizeUsers to set
     */
    public void setSizeUsers(int sizeUsers) {
        this.sizeUsers = sizeUsers;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Lista usuarios) {
        this.usuarios = usuarios;
    }

    //A PARTIR DE AQUI///////////////////////////////////////////////////////
 

    public int[] BFS(GrafoMatriz g, String id) {
        Nodo u = g.getUsuarios().buscarNodo(id);
        int v, w;
        Queue q = new Queue();
        int[] m;
        m = new int[this.getSizeUsers()];
        v = g.getUsuarios().getPosicion(u);
        if (v < 0) {
            System.out.println("Error");
        }
        for (int i = 0; i < g.getSizeUsers(); i++) {
            m[i] = 0;
        }
        m[v] = 0;
        q.add(v);
        while (!q.isEmpty()) {
            int cw;
            cw = q.delete();
            w = cw;

            for (int j = 0; j < g.getSizeUsers(); j++) {
                if ((g.getMatriz()[w][j] != 0) && (m[j] == 0)) {
                    m[j] = m[w] + 1;
                    q.add(j);
                }

            }

        }
        return m;
    }

}
