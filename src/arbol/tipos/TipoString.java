/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;

/**
 *
 * @author diego
 */
public class TipoString extends Tipo{
     @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoString;
    }
}
