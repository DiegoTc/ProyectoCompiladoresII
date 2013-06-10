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
public abstract class Expresion {
    public Expresion siguiente;
    public abstract Tipo validarSemantica() throws Exception;
    public abstract String generarCodigo();
}
