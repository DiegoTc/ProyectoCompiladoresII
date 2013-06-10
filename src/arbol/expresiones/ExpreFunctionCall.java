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
public class ExpreFunctionCall extends Expresion{
    Expresion parametros;
    String nombre;

    public ExpreFunctionCall(Expresion parametros, String nombre) {
        this.parametros = parametros;
        this.nombre = nombre;
    }
    
    public Expresion getParametros() {
        return parametros;
    }

    public void setParametros(Expresion parametros) {
        this.parametros = parametros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Tipo validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
