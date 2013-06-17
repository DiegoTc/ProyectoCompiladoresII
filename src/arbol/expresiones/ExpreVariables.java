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
                throw new Exception("Error Semantico, la variable "+name+" no a sido declarada");
            } catch (Exception ex) {
                Logger.getLogger(ExpreVariables.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       Access a=null;
       AccessMiembro miembro=null;
       AccessArreglo arreglo=null;
       TipoRecord record=null;
       TipoArray tarray=null;
        for(int i=0;i<lista.size();i++)
        {
            a=lista.get(i);
            if(a instanceof AccessMiembro){
                miembro=((AccessMiembro)a);
            }
            else if(a instanceof AccessArreglo){
                arreglo=((AccessArreglo)a);
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
                tarray=((TipoArray)tip);
                LiteralEntero lit1=null,lit2=null;
                if(tarray.sizearreglos.get(i) instanceof LiteralEntero){
                    lit1=((LiteralEntero)tarray.sizearreglos.get(i));
                    if(arreglo.lista instanceof LiteralEntero){
                        lit2=((LiteralEntero)arreglo.lista);
                    }
                    else{
                        try {
                            throw new Exception("Error Semantico el valor del arreglo no es de tipo INT");
                        } catch (Exception ex) {
                            Logger.getLogger(ExpreVariables.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    try {
                            throw new Exception("Error Semantico el valor del arreglo no es de tipo INT");
                        } catch (Exception ex) {
                            Logger.getLogger(ExpreVariables.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                if(lit2.getValor() < 0 && lit2.getValor() >= lit1.getValor() ){
                     try {
                            throw new Exception("Error Semantico Los valores no estan van de acuerdo al rango");
                        } catch (Exception ex) {
                            Logger.getLogger(ExpreVariables.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                tip=tarray.getT();
                
            }
            
         }
       
        if(tip instanceof TipoArray){
            tarray=((TipoArray)tip);
            return tarray.getT();
        }
        else{
            return tip;
        }
    }
    
    @Override
    public String generarCodigo() {
        Tipo t=InfSemantica.getInstancia().tablaGlobal.get(name);
        TipoRecord trecord=null;
        String recordname="";
        StringBuilder builder= new StringBuilder();
        int id;
        
        Access ac=null;
        AccessMiembro acm=null;
        AccessArreglo acarr=null;
        if(lista.size()>0){
            Tipo tipo=null;
            TipoInt tint=null;
            TipoFloat tfloat=null;
            TipoString tstring=null;
            TipoChar tchar=null;
            TipoBooleano tbool=null;
            TipoArray tarray=null;
            //TipoRecord trecor=null;
            id=TablaIds.getInstancia().getVariableNumber(name);
            if(t instanceof TipoRecord)
            {
                trecord=((TipoRecord)t);
                recordname=trecord.nombre;
                builder.append("ldloca.s ").append(id).append("\n");
            }
            else if(t instanceof TipoArray){
                tarray=((TipoArray)t);
            }
            
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
                        tfloat=((TipoFloat)tipo);
                        builder.append("ldfld ").append(tfloat.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(tipo instanceof TipoChar){
                        tchar=((TipoChar)tipo);
                        builder.append("ldfld ").append(tchar.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(tipo instanceof TipoString){
                        tstring=((TipoString)tipo);
                        builder.append("ldfld ").append(tstring.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(tipo instanceof TipoBooleano){
                        tbool=((TipoBooleano)tipo);
                        builder.append("ldfld ").append(tbool.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(tipo instanceof TipoRecord){
                       trecord=((TipoRecord)tipo);
                       String tre=recordname;
                       recordname=trecord.nombre;
                       builder.append("ldflda valuetype Ejemplo.").append(recordname).append(" Ejemplo.");
                      
                       builder.append(tre).append("::").append(acm.getId()).append("\n");
                    }
                    else if(tipo instanceof TipoArray){
                        tarray =((TipoArray)tipo);
                        //builder.append("ldloc.").append(TablaIds.getInstancia().getVariableNumber(name));
                        
                    }
                }
                else if(ac instanceof AccessArreglo){
                    acarr=((AccessArreglo)ac);
                    if(i==0){
                        builder.append("ldloc ").append(TablaIds.getInstancia().getVariableNumber(name)).append("\n");
                    }
                    builder.append(acarr.lista.generarCodigo());
                     if(lista.size()==1){
                        if(tarray.getT() instanceof TipoInt){
                            builder.append("ldelem.i4\n");
                        }
                        else if(tarray.getT() instanceof TipoFloat){
                            builder.append("ldelem.r4\n");
                        }
                     }
                }
            }
            if(ac instanceof AccessArreglo && lista.size()>1){
                builder.append("call instance ");
                for(int ii=0;ii<lista.size();ii++){
                    acarr=((AccessArreglo)lista.get(ii));
                    builder.append(tarray.getT().toString()).append(" ");
                }
                builder.append("[");
                for(int ii=1;ii<lista.size();ii++){
                    acarr=((AccessArreglo)lista.get(ii));
                    builder.append(",");
                }
                builder.append("]::Get(");
                for(int ii=0;ii<lista.size();ii++){
                    acarr=((AccessArreglo)lista.get(ii));
                    builder.append(tarray.getT().toString());
                    if(ii<lista.size()-1){
                        builder.append(",");
                    }
                }
                builder.append(")\n");
            }
            return builder.toString();
        }else{
            return "ldloc " +TablaIds.getInstancia().getVariableNumber(name) +"\n";
        }
    }
}
