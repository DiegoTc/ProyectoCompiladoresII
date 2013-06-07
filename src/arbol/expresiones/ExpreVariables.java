/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.Tipo;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class ExpreVariables extends Expresion{
    String name;
    Access access;

    

    public Access getAccess() {
        return access;
    }

    public ExpreVariables(String name, Access access) {
        this.name = name;
        this.access = access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Tipo validarSemantica() {
        Tipo tip=null;
        if(InfSemantica.getInstancia().tablaGlobal.containsKey(name)){
            tip=InfSemantica.getInstancia().tablaGlobal.get(name);
        }
        return tip;
    }
}
