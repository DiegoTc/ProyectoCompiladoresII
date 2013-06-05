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
public class SentenciaIf extends Sentencia{
    Expresion expr1;
    Sentencia condicion;
    Sentencia conElse;

    public Sentencia getConElse() {
        return conElse;
    }

    public void setConElse(Sentencia conElse) {
        this.conElse = conElse;
    }

    public Sentencia getCondicion() {
        return condicion;
    }

    public void setCondicion(Sentencia condicion) {
        this.condicion = condicion;
    }

    public Expresion getExpr1() {
        return expr1;
    }

    public void setExpr1(Expresion expr1) {
        this.expr1 = expr1;
    }

    public SentenciaIf(Expresion expr1, Sentencia condicion) {
        this.expr1 = expr1;
        this.condicion = condicion;
    }

    public SentenciaIf(Expresion expr1, Sentencia condicion, Sentencia conElse) {
        this.expr1 = expr1;
        this.condicion = condicion;
        this.conElse = conElse;
    }

    @Override
    public void validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
