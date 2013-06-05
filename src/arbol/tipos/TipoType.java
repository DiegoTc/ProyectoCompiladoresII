/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;

/**
 *
 * @author diego
 */
public class TipoType extends Tipo{
     @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoType;
    }
}
