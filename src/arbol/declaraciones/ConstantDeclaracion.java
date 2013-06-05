/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import arbol.expresiones.Expresion;
import arbol.tipos.Tipo;

/**
 *
 * @author diego
 */
public class ConstantDeclaracion extends Declaracion{
    String nombre;
    Expresion tipo;

    public ConstantDeclaracion(String nombre, Expresion tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Expresion getTipo() {
        return tipo;
    }

    public void setTipo(Expresion tipo) {
        this.tipo = tipo;
    }

    @Override
    public void validarSemantica() {
       
    }


    
    
}
