/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import Generacion.TablaIds;
import arbol.expresiones.Access;
import arbol.expresiones.AccessMiembro;
import arbol.expresiones.ExpreVariables;
import arbol.expresiones.Expresion;
import arbol.tipos.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class SentenciaAsignacion extends Sentencia{
    Expresion id;
    Expresion valor;

    public SentenciaAsignacion(Expresion id, Expresion valor) {
        this.id = id;
        this.valor = valor;
    }

    public Expresion getId() {
        return id;
    }

    public void setId(Expresion id) {
        this.id = id;
    }

    public Expresion getValor() {
        return valor;
    }

    public void setValor(Expresion valor) {
        this.valor = valor;
    }

    @Override
    public void validarSemantica() {
        try {
            Tipo izquierdo=id.validarSemantica();
            Tipo derecho=valor.validarSemantica();
            
            if(!izquierdo.esEquivalente(derecho)){
                    try {
                        StringBuilder message=new StringBuilder("Error Semantico, el tipo ");
                        message.append(izquierdo.toString());
                        message.append(" no coincide con el valor asignado");
                        throw new Exception(message.toString());
                    } catch (Exception ex) {
                        Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
        } catch (Exception ex) {
            Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
            /*
            if(id instanceof ExpreVariables)
            {
                tmp=((ExpreVariables)id);
                if(InfSemantica.getInstancia().tablaGlobal.containsKey(tmp.getName()))
                {
                    var=InfSemantica.getInstancia().tablaGlobal.get(tmp.getName());
                }
                else{
                    try {
                        throw new Exception("Error Semantico, la variable"+tmp.getName()+" no a sido declarada");
                    } catch (Exception ex) {
                        Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Access a=null;
                AccessMiembro miembro=null;
                TipoRecord record=null;
                for(int i=0;i<tmp.lista.size();i++)
                {
                    a=tmp.lista.get(i);
                    if(a instanceof AccessMiembro)
                    {
                        miembro=((AccessMiembro)a);
                    }
                    if(var instanceof TipoRecord)
                    {
                        record=((TipoRecord)var);
                        if(record.tbsimbolo.tablaLocal.containsKey(miembro.getId()))
                        {
                            var= record.tbsimbolo.tablaLocal.get(miembro.getId());
                        }
                        else{
                            try {
                                throw new Exception("Error semantico El tipo"+ miembro.getId() + " no fue declardo");
                            } catch (Exception ex) {
                                Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    else if(var instanceof TipoArray)
                    {
                        //FALTA PROGRAMAR LOS ARREGLOS  
                    }
                    else
                    {
                        
                    }
                }
                
                
                //  La validacion semantica del valor
                Tipo val=null;
                if(valor instanceof ExpreVariables){
                    tmp=((ExpreVariables)valor);
                    if(InfSemantica.getInstancia().tablaGlobal.containsKey(tmp.getName()))
                    {
                        var1=InfSemantica.getInstancia().tablaGlobal.get(tmp.getName());
                    }
                    else{
                        try {
                            throw new Exception("Error Semantico, la variable"+tmp.getName()+" no a sido declarada");
                        } catch (Exception ex) {
                            Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    for(int i=0;i<tmp.lista.size();i++)
                    {
                        a=tmp.lista.get(i);
                        if(a instanceof AccessMiembro)
                        {
                            miembro=((AccessMiembro)a);
                        }
                        if(var1 instanceof TipoRecord)
                        {
                            record=((TipoRecord)var1);
                            if(record.tbsimbolo.tablaLocal.containsKey(miembro.getId()))
                            {
                                var1= record.tbsimbolo.tablaLocal.get(miembro.getId());
                            }
                            else{
                                try {
                                    throw new Exception("Error semantico El tipo"+ miembro.getId() + " no fue declardo");
                                } catch (Exception ex) {
                                    Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        else if(var1 instanceof TipoArray)
                        {
                           
                        }
                        else
                        {
                            
                        }
                    }
                    val=var1;
                }
                else{
                     
                    try {
                        val = valor.validarSemantica();
                    } catch (Exception ex) {
                        Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(!val.esEquivalente(var)){
                    try {
                        StringBuilder message=new StringBuilder("Error Semantico, el tipo ");
                        message.append(var.toString());
                        message.append(" no coincide con el valor asignado");
                        throw new Exception(message.toString());
                    } catch (Exception ex) {
                        Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
               
            }*/
      
       
    }

    @Override
    public String generarCodigoSentencia() {
        ExpreVariables tmp=((ExpreVariables)id);
        Tipo tipo=null;
        TipoRecord record=null;
        if(InfSemantica.getInstancia().tablaGlobal.containsKey(tmp.getName())){
            tipo=InfSemantica.getInstancia().tablaGlobal.get(tmp.getName());
        }
        if(tipo instanceof TipoRecord)
        {
            record=((TipoRecord)tipo);
            String recordname=record.nombre;
            int id=TablaIds.getInstancia().getVariableNumber(tmp.getName());
            StringBuilder builder= new StringBuilder();
            builder.append("ldloca.s ").append(id).append("\n");
            AccessMiembro acm=null;
            Tipo t=null;
            for(int i=0;i<tmp.lista.size();i++)
            {
                Access ac=tmp.lista.get(i);
                if(ac instanceof AccessMiembro){
                    acm=((AccessMiembro)ac);
                    t= record.tbsimbolo.tablaLocal.get(acm.getId());
                }
                if(record.tbsimbolo.tablaLocal.containsKey(acm.getId())){
                    
                    if(t instanceof TipoInt)
                    {
                        builder.append(valor.generarCodigo());
                        TipoInt tint=((TipoInt)t);
                        builder.append("stfld ").append(tint.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                        
                    }
                    else if(t instanceof TipoFloat){
                        builder.append(valor.generarCodigo());
                        TipoFloat tfloat=((TipoFloat)t);
                        builder.append("stfld ").append(tfloat.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(t instanceof TipoString){
                        builder.append(valor.generarCodigo());
                        TipoString tstring=((TipoString)t);
                        builder.append("stfld ").append(tstring.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(t instanceof TipoBooleano){
                        builder.append(valor.generarCodigo());
                        TipoBooleano tbool=((TipoBooleano)t);
                        builder.append("stfld ").append(tbool.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(t instanceof TipoChar){
                        builder.append(valor.generarCodigo());
                        TipoChar tchar=((TipoChar)t);
                        builder.append("stfld ").append(tchar.toString()).append(" Ejemplo.").append(recordname).append("::").append(acm.getId()).append("\n");
                    }
                    else if(t instanceof TipoRecord){
                        record=((TipoRecord)t);
                        String tmstring=recordname;
                        recordname=record.nombre;
                        builder.append("ldflda valuetype Ejemplo.").append(recordname).append(" Ejemplo.");
                        
                        builder.append(tmstring).append("::").append(acm.getId()).append("\n");
                    }
                }
            }
            //builder.append(record.);
            return builder.toString();
        }
        else{
            return valor.generarCodigo() + "stloc "+ TablaIds.getInstancia().getVariableNumber(tmp.getName())+ "\n";
        }
    }
    
    
}
