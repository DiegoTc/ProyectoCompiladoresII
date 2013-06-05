/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import arbol.sentencias.Sentencia;

/**
 *
 * @author diego
 */
public class Bloque {
    Declaracion d1;
    Sentencia s1;

    public Declaracion getD1() {
        return d1;
    }

    public void setD1(Declaracion d1) {
        this.d1 = d1;
    }

    public Sentencia getS1() {
        return s1;
    }

    public void setS1(Sentencia s1) {
        this.s1 = s1;
    }

    public Bloque(Declaracion d1, Sentencia s1) {
        this.d1 = d1;
        this.s1 = s1;
    }

    
    
}
