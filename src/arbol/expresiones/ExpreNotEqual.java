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
public class ExpreNotEqual extends ExpreOperadorBinario{

    public ExpreNotEqual(Expresion izquierdo, Expresion derecho) {
        super(izquierdo, derecho);
    }

    @Override
    public Tipo validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}