
package lectura;

import graforedsocial.GrafoMatriz;

/**
 *Clase creada para poder sacar informacion de la funcion de cargar, guarda un grafo y la ruta del archivo txt
 * 
 * @author raco1
 */
public class GrafoRuta {
    private GrafoMatriz g;
    private String ruta;
    
    public GrafoRuta(GrafoMatriz g, String ruta){
        this.g=g;
        this.ruta=ruta;
    }
    /**
     * @return the g
     */
    public GrafoMatriz getG() {
        return g;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param g the g to set
     */
    public void setG(GrafoMatriz g) {
        this.g = g;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
