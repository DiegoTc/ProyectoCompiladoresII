/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import arbol.expresiones.Expresion;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class SentenciaLlamadaFuncion extends Sentencia {
    Expresion parametros;
    String nombrefuncion;

    public SentenciaLlamadaFuncion(Expresion parametros, String nombrefuncion) {
        this.parametros = parametros;
        this.nombrefuncion = nombrefuncion;
    }

    public String getNombrefuncion() {
        return nombrefuncion;
    }

    public void setNombrefuncion(String nombrefuncion) {
        this.nombrefuncion = nombrefuncion;
    }

    public Expresion getParametros() {
        return parametros;
    }

    public void setParametros(Expresion parametros) {
        this.parametros = parametros;
    }

    @Override
    public void validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generarCodigoSentencia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
