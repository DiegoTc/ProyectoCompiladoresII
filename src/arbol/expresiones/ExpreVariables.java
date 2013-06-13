/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import Generacion.TablaIds;
import arbol.tipos.Tipo;
import java.util.ArrayList;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class ExpreVariables extends Expresion{
    String name;
    ;
    public ArrayList<Access> lista= new ArrayList<>();
    
    private void converttoList(Access access){
        Access tmp= access;
        while(tmp!=null){
            lista.add(tmp);
            tmp=tmp.next;
        }
    }

   

    public ExpreVariables(String name, Access access) {
        this.name = name;
        converttoList(access); 
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
    
    @Override
    public String generarCodigo() {
        return "ldloc " +TablaIds.getInstancia().getVariableNumber(name) +"\n";
    }
}
