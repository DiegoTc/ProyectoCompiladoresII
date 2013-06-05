/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;

import arbol.declaraciones.Declaracion;

/**
 *
 * @author diego
 */
public class TipoRecord extends Tipo{
    Declaracion decl;

    public TipoRecord(Declaracion decl) {
        this.decl = decl;
    }
     @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoRecord;
    }
     @Override
    public String toString(){
        return "Record";
    }
}
