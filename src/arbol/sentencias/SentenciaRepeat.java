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
public class SentenciaRepeat extends Sentencia{
    Expresion condicion;
    Sentencia bloque;

    public Sentencia getBloque() {
        return bloque;
    }

    public void setBloque(Sentencia bloque) {
        this.bloque = bloque;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public SentenciaRepeat(Expresion condicion, Sentencia bloque) {
        this.condicion = condicion;
        this.bloque = bloque;
    }

    @Override
    public void validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
