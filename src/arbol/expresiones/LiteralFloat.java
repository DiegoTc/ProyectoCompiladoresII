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
public class LiteralFloat extends Expresion{
    float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LiteralFloat(float valor) {
        this.valor = valor;
    }
    @Override
    public Tipo validarSemantica() {
        return InfSemantica.getInstancia().tablaTipos.get("float");
    }
    
}
