package graforedsocial;

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
//    /**
//     * Asigna un nuevo arco 
//     * @param salida
//     * @param llegada
//     * @param peso 
//     */
//    private void addArco(Almacen salida, Almacen llegada, int peso){
//        //En construccion 
//        try{
//            if(getAlmacenes().buscar(salida.getId())!=null && getAlmacenes().buscar(llegada.getId())!=null ){
//                 Ruta nueva= new Ruta(salida,llegada,peso);
//                 getArcos().insertarRuta(nueva);
//            }else{
//                JOptionPane.showMessageDialog(null, "El almacen no pertenece a la lista");
//            }
//        }catch(Exception error) {
//            
//        }
//    }
//    
//    
//    /**
//     * Agrega un nuevo almacen al grafo
//     * @param id
//     * @param stock 
//     */
//    public void addAlmacen(String id, Lista stock){
//        try{
//            if(getAlmacenes().buscar(id)==null){
//                Almacen nuevo= new Almacen(id, stock);
//                getAlmacenes().insertarAlmacen(nuevo);
//                setSizeAlm(getSizeAlm() + 1);
//                while(true){
//                    Almacen llegada=elegirAlm();
//                    int peso=pedirPeso();
//                    Almacen llegada2=elegirAlm();
//                    int peso2=pedirPeso();
//                    if (llegada!=null ){
//                        if(peso!=0){
//                            addArco(nuevo, llegada, peso);
//                            addArco(nuevo, llegada2, peso2);
//                            generarM();
//                            llenarMatriz();
//                            break;
//                        }else{
//                            JOptionPane.showMessageDialog(null, "No es un input correcto ");
//                        }
//                    }else{
//                        JOptionPane.showMessageDialog(null, "Error al colocar el almacen ");
//                    }
//                }
//                JOptionPane.showMessageDialog(null,"Se agrego un nuevo almacen");
//            }else{
//                JOptionPane.showMessageDialog(null,"Ese almacen ya existe");
//            }
//        }catch (Exception err){
//            JOptionPane.showMessageDialog(null,"Ese almacen ya existe");
//        }
//      }
//    
//   /**
//    * Se encarga de pedir un almacen de llegada para generar una nueva ruta
//    * @return el almacen a donde queremos llegar
//    */
//     public Almacen elegirAlm(){
//         try{
//             
//            String[] cadena = new String[getAlmacenes().getSize()-1];
//            int count=0;
//
//            for(Nodo aux=getAlmacenes().getpFirst();aux!=null; aux=aux.getpNext()){
//                if(aux==getAlmacenes().getpLast()){
//                    count++;
//                }else{
//                   cadena[count]=aux.getAlmacen().getId();
//                   count++;
//                }
//            }
//            Icon icono = new ImageIcon(getClass().getResource("almacen.jpg"));
//            String resp = (String) JOptionPane.showInputDialog(null, "Seleccione el almacen de llegada", "Almacen", JOptionPane.DEFAULT_OPTION,icono , cadena, cadena[0]);
//            return getAlmacenes().buscar(resp).getAlmacen();
//                 
//         }catch(Exception err){
//             JOptionPane.showMessageDialog(null,"Error");
//             return null;
//         }
//         
//     }   
//     
//     /**
//      * Se encarga de pedir el la distancia entre dos almacenes
//      * @return la distancia entre los almacenes
//      */
//    public int pedirPeso(){
//        String peso;
//        try{
//            while(true){
//                peso = JOptionPane.showInputDialog(null, "¿Cual es la distancia entre los almacenes?", "redondee");
//                if(Integer.parseInt(peso)<=0){
//                    JOptionPane.showMessageDialog(null, "No es un numero valido", "Error", JOptionPane.WARNING_MESSAGE);
//                    continue;
//                }else{
//                    return Integer.parseInt(peso);
//                }
//            }
//        }catch(Exception err){
//                JOptionPane.showMessageDialog(null, "No es un numero valido", "Error", JOptionPane.WARNING_MESSAGE);
//        }
//        return 0;
//    }  
//    
//    
//    /**
//     * Se encarga de eliminar un almacen y sus rutas
//     * @param id 
//     */
//    public void eliminarAlmacen(String id){
//        getAlmacenes().removerPorReferencia(id);
//        getArcos().removerRuta(id);
//        getArcos().removerRuta(id);
//        getAlmacenes().imprimir();
//        getArcos().imprimirRuta();
//        
//    }

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

    /*
}
        int peso = 0;

        for (Nodo amigo = getAmigos().getpFirst(); amigo != null; amigo = amigo.getpNext()) {
            peso = amigo.getAmigos().getTiempoAmistad();
        }
        return peso;
     */
    //A PARTIR DE AQUI///////////////////////////////////////////////////////
    //Funcion para encontrar usuarios adyacentes. Retorna una lista
    public Lista findAdj(int adj[][], Usuario user) {

        int peso = 0;
        Lista l = new Lista();

        for (Nodo amigo = getAmigos().getpFirst(); amigo != null; amigo = amigo.getpNext()) {
            peso = amigo.getAmigos().getTiempoAmistad();

            int index = -1;
            for (int i = 0; i < getSizeUsers(); i++) {
                if (usuarios.getUsuario(i) == user) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = 0; i < adj[index].length; i++) {
                    if (adj[index][i] == peso) {////////////////////////////////
                        l.insertarUsuario(usuarios.getUsuario(i));
                    }
                }
            }

        }
        return l;
    }

    //Funcion de recorrido de anchura
    public void BFS(int[][] matrix, Usuario user) {
        Queue q = new Queue();
        q.add(user);
        user.setVisited(true);
        while (!q.isEmpty()) {
            Usuario u = q.delete();
            Lista l = findAdj(this.getMatriz(), u);
            for (int i = 0; i < l.getSize(); i++) {
                Usuario a = l.getUsuario(i);
                if (a != null && !a.isVisited()) {
                    q.add(a);
                    a.setVisited(true);
                }
            }
        }

    }

    public void bfs(GrafoMatriz g, int v, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < getSizeUsers(); i++) {
            if ((v != i) && (!visited[i])) {
                bfs(g, i, visited);
            }
        }
    }

    public void bf(GrafoMatriz g) {
        boolean visited[] = new boolean[getSizeUsers()];
        for (int i = 0; i < getSizeUsers(); i++) {
            visited[i] = false;
        }
        for (int i = 0; i < getSizeUsers(); i++) {
            if (!visited[i]) {
                bfs(g, i, visited);
            }
        }

    }

    public void DFS(GrafoMatriz g) throws Exception {
        Stack s = new Stack();
        boolean visited[] = new boolean[getSizeUsers()];
        for (int i = 0; i < getSizeUsers(); i++) {
            visited[i] = false;
        }
        for (int i = 0; i < getSizeUsers(); i++) {
            if (!visited[i]) {
                s.add(usuarios.getUsuario(i));
                visited[i] = true;
                while (!s.isEmpty()) {
                    Usuario v = s.delete();
                    for (int j = 0; j < getSizeUsers(); j++) {
                        if (v!=usuarios.getUsuario(j) && !visited[j]) {
                            s.add(usuarios.getUsuario(j));
                            visited[j] = true;
                        }
                    }
                }

            }
        }
    }

    //Funcion para contar islas
    public int countIslands(int mat[][], Usuario user) {

        //int peso = 0;
        boolean[][] vis = new boolean[getSizeUsers()][getSizeUsers()];
        int count = 0;
        for (int i = 0; i < getSizeUsers(); i++) {
            for (int j = 0; j < getSizeUsers(); j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {////////////////////////
                    BFS(mat, user);
                    count++;
                }
            }
        }
        return count;
    }

    //Tambien cuenta las islas
    public int count(int[][] mat, GrafoMatriz g) throws Exception {
        // base case
        if (mat == null || mat.length == 0) {
            return 0;
        }

        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;

        // stores if a cell is processed or not
        boolean[][] processed = new boolean[M][N];

        int island = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // start BFS from each unprocessed node and
                // increment island count
                if (mat[i][j] == 1 && !processed[i][j]) {
                    DFS(g);
                    island++;
                }
            }
        }

        return island;
    }
}
