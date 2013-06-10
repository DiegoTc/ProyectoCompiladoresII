/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;

/**
 *
 * @author diego
 */
public class TipoChar extends Tipo{
     @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoChar;
    }
     
    @Override
    public String toString(){
        return "char";
    } 
}
