/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;

import arbol.declaraciones.Declaracion;
import semantica.TablaSimbolos;

/**
 *
 * @author diego
 */
public class TipoRecord extends Tipo{
    Declaracion decl;
    public TablaSimbolos tbsimbolo;
    public TipoRecord(Declaracion decl) {
        this.decl = decl;
        tbsimbolo= new TablaSimbolos();
    }
     @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoRecord;
    }
     @Override
    public String toString(){
        return "Record";
    }

    public Declaracion getDecl() {
        return decl;
    }
     
}
