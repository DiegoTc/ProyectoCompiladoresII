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
public class ExpreMultiplicacion extends ExpreOperadorBinario {

    public ExpreMultiplicacion(Expresion izquierdo, Expresion derecho) {
        super(izquierdo, derecho);
    }

        @Override
    public Tipo validarSemantica() {
        Tipo izq,der;
        izq=izquierdo.validarSemantica();
        der=derecho.validarSemantica();
        return izq;
    }
    
}
