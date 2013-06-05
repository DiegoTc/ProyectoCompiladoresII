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
public class SentenciaFor extends Sentencia{
    String id;
    Expresion condicion,condicion2;
    Sentencia compound;

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sentencia getCompound() {
        return compound;
    }

    public void setCompound(Sentencia compound) {
        this.compound = compound;
    }

    public Expresion getCondicion2() {
        return condicion2;
    }

    public void setCondicion2(Expresion condicion2) {
        this.condicion2 = condicion2;
    }

    public SentenciaFor(String id, Expresion condicion, Expresion condicion2, Sentencia compound) {
        this.id = id;
        this.condicion = condicion;
        this.condicion2 = condicion2;
        this.compound = compound;
    }

    @Override
    public void validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    


    
    
}
