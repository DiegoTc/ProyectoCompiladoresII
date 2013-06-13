/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import Generacion.TablaIds;
import arbol.tipos.Tipo;
import arbol.tipos.TipoInt;
import arbol.tipos.TipoRecord;
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
        Tipo t=InfSemantica.getInstancia().tablaGlobal.get(name);
        TipoRecord trecord=null;
        StringBuilder builder= new StringBuilder();
        int id;
        if(t instanceof TipoRecord)
        {
            trecord=((TipoRecord)t);   
        }
        Access ac=null;
        AccessMiembro acm=null;
        if(lista.size()>0){
            Tipo tipo=null;
            for(int i=0;i<lista.size();i++)
            {
                id=TablaIds.getInstancia().getVariableNumber(name);
                builder.append("ldloca.s ").append(id).append("\n");
                ac=lista.get(i);
                if(ac instanceof AccessMiembro){
                    acm=((AccessMiembro)ac);
                }
                tipo=trecord.tbsimbolo.tablaLocal.get(acm.getId());
                
                if(tipo instanceof TipoInt){
                    TipoInt tint=((TipoInt)tipo);
                    builder.append("ldfld ").append(tint.toString()).append(" Ejemplo.").append(trecord.nombre).append("::").append(acm.getId()).append("\n");
                }                
            }
            return builder.toString();
        }else{
            return "ldloc " +TablaIds.getInstancia().getVariableNumber(name) +"\n";
        }
    }
}
