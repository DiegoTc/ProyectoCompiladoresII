/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

/**
 *
 * @author diego
 */
public class ExpreNot extends ExpreOperacionUnaria{
    Expresion expr1;

    public Expresion getExpr1() {
        return expr1;
    }

    public void setExpr1(Expresion expr1) {
        this.expr1 = expr1;
    }

    public ExpreNot(Expresion expr1) {
        this.expr1 = expr1;
    }
    
}
