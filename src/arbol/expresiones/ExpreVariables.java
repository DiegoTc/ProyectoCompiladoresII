/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import Generacion.TablaIds;
import arbol.tipos.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        else{
            try {
                throw new Exception("Error Semantico, la variable"+name+" no a sido declarada");
            } catch (Exception ex) {
                Logger.getLogger(ExpreVariables.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       Access a=null;
       AccessMiembro miembro=null;
       TipoRecord record=null;
        for(int i=0;i<lista.size();i++)
        {
            a=lista.get(i);
            if(a instanceof AccessMiembro){
                miembro=((AccessMiembro)a);
            }
            if(tip instanceof TipoRecord){
                record=((TipoRecord)tip);
                if(record.tbsimbolo.tablaLocal.containsKey(miembro.getId())){
                    tip= record.tbsimbolo.tablaLocal.get(miembro.getId());
                }
                else{
                    try {
                        throw new Exception("Error semantico El tipo"+ miembro.getId() + " no fue declardo");
                    } catch (Exception ex) {
                        Logger.getLogger(ExpreVariables.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else if(tip instanceof TipoArray){
                /*FALTA PROGRAMAR LOS ARREGLOS  **/
            }
            else{
                
            }
         }
       
        
        return tip;
    }
    
    @Override
    public String generarCodigo() {
        Tipo t=InfSemantica.getInstancia().tablaGlobal.get(name);
        TipoRecord trecord=null;
        String recordname="";
        StringBuilder builder= new StringBuilder();
        int id;
        if(t instanceof TipoRecord)
        {
            trecord=((TipoRecord)t);
            recordname=trecord.nombre;
        }
        Access ac=null;
        AccessMiembro acm=null;
        if(lista.size()>0){
            Tipo tipo=null;
            TipoInt tint=null;
            TipoFloat tfloat=null;
            TipoString tstring=null;
            TipoChar tchar=null;
            TipoBooleano tbool=null;
            //TipoRecord trecor=null;
            id=TablaIds.getInstancia().getVariableNumber(name);
            builder.append("ldloca.s ").append(id).append("\n");
            for(int i=0;i<lista.size();i++)
            {
                
                ac=lista.get(i);
                if(ac instanceof AccessMiembro){
                    acm=((AccessMiembro)ac);
                    tipo=trecord.tbsimbolo.tablaLocal.get(acm.getId());
                    if(tipo instanceof TipoInt){
                        tint=((TipoInt)tipo);
                        builder.append("ldfld ").append(tint.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(tipo instanceof TipoFloat){
                        
                    }
                    else if(tipo instanceof TipoChar){
                        
                    }
                    else if(tipo instanceof TipoString){
                        
                    }
                    else if(tipo instanceof TipoBooleano){
                        
                    }
                    else if(tipo instanceof TipoRecord){
                       trecord=((TipoRecord)tipo);
                       String tre=recordname;
                       recordname=trecord.nombre;
                       builder.append("ldflda valuetype Ejemplo.").append(recordname).append(" Ejemplo.");
                      
                       builder.append(tre).append("::").append(acm.getId()).append("\n");
                    }
                }
            }
            return builder.toString();
        }else{
            return "ldloc " +TablaIds.getInstancia().getVariableNumber(name) +"\n";
        }
    }
}
