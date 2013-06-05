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
public class LiteralBooleana extends Expresion{
    Boolean valor;

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }

    public LiteralBooleana(Boolean valor) {
        this.valor = valor;
    }

    @Override
    public Tipo validarSemantica() {
        return InfSemantica.getInstancia().tablaTipos.get("Boolean");
    }
    
}
