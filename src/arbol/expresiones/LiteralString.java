/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.Tipo;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class LiteralString extends Expresion{
    String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LiteralString(String valor) {
        this.valor = valor;
    }
    @Override
    public Tipo validarSemantica() {
        return InfSemantica.getInstancia().tablaTipos.get("String");
    }
    
   
}
