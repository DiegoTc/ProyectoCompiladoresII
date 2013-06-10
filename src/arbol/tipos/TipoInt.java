/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;



/**
 *
 * @author diego
 */
public class TipoInt extends Tipo{

    @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoInt;
    }
    
    @Override
    public String toString(){
        return "int32";
    }
}
