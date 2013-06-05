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
public class ExpreParam extends Expresion{
    
    Expresion exp;
    Tipo tip;

    public ExpreParam(Expresion exp, Tipo tip) {
        this.exp = exp;
        this.tip = tip;
    }

    public ExpreParam(Expresion exp) {
        this.exp = exp;
    }

    public Expresion getExp() {
        return exp;
    }

    public void setExp(Expresion exp) {
        this.exp = exp;
    }

    public Tipo getTip() {
        return tip;
    }

    public void setTip(Tipo tip) {
        this.tip = tip;
    }

    @Override
    public Tipo validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
