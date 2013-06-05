/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import arbol.expresiones.Expresion;

/**
 *
 * @author diego
 */
public class SentenciaWhile extends Sentencia{
    Sentencia bloque;
    Expresion expr1;

    public Sentencia getBloque() {
        return bloque;
    }

    public void setBloque(Sentencia bloque) {
        this.bloque = bloque;
    }

    public Expresion getExpr1() {
        return expr1;
    }

    public void setExpr1(Expresion expr1) {
        this.expr1 = expr1;
    }

    public SentenciaWhile(Sentencia bloque, Expresion expr1) {
        this.bloque = bloque;
        this.expr1 = expr1;
    }

    @Override
    public void validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
