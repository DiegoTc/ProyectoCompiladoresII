/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;

/**
 *
 * @author diego
 */
public class TipoBooleano extends Tipo{
     @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoBooleano;
    }
     @Override
    public String toString(){
        return "bool";
    }
}
