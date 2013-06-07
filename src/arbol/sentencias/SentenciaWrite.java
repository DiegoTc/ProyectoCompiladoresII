/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import arbol.expresiones.Expresion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class SentenciaWrite extends Sentencia{
    Expresion expre1;

    public Expresion getExpre1() {
        return expre1;
    }

    public void setExpre1(Expresion expre1) {
        this.expre1 = expre1;
    }

    public SentenciaWrite(Expresion expre1) {
        this.expre1 = expre1;
    }

    @Override
    public void validarSemantica() {
        try {
            expre1.validarSemantica();
        } catch (Exception ex) {
            Logger.getLogger(SentenciaWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
