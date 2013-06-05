/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

/**
 *
 * @author diego
 */
public abstract class Declaracion {
    Declaracion siguiente;

    public Declaracion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Declaracion siguiente) {
        this.siguiente = siguiente;
    }
    
    public abstract void validarSemantica();
  
    
}
