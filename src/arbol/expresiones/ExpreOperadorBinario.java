/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.Tipo;

/**
 *
 * @author diego
 */
public abstract class ExpreOperadorBinario  extends Expresion{
    Expresion izquierdo;
    Expresion derecho;

    public Expresion getDerecho() {
        return derecho;
    }

    public void setDerecho(Expresion derecho) {
        this.derecho = derecho;
    }

    public Expresion getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Expresion izquierdo) {
        this.izquierdo = izquierdo;
    }

    public ExpreOperadorBinario(Expresion izquierdo, Expresion derecho) {
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    @Override
    public Tipo validarSemantica() throws Exception {
        Tipo izq,der;
        izq=izquierdo.validarSemantica();
        der=derecho.validarSemantica();
        return izq;
    }
}
