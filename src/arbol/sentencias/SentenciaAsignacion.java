/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import Generacion.TablaIds;
import arbol.expresiones.*;
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
           
      
       
    }

    @Override
    public String generarCodigoSentencia() {
        ExpreVariables tmp=((ExpreVariables)id);
        Tipo tipo=null;
        TipoRecord record=null;
        TipoArray tarray=null;
        Access ac=null;
        AccessMiembro acm=null;
        AccessArreglo acarr=null;
        Tipo t=null;
         StringBuilder builder= new StringBuilder();
        if(InfSemantica.getInstancia().tablaGlobal.containsKey(tmp.getName())){
            tipo=InfSemantica.getInstancia().tablaGlobal.get(tmp.getName());
        }
        if(tipo instanceof TipoRecord)
        {
            record=((TipoRecord)tipo);
            String recordname=record.nombre;
            int id=TablaIds.getInstancia().getVariableNumber(tmp.getName());
           
            builder.append("ldloca.s ").append(id).append("\n");
            
            
            for(int i=0;i<tmp.lista.size();i++)
            {
                ac=tmp.lista.get(i);
                if(ac instanceof AccessMiembro){
                    acm=((AccessMiembro)ac);
                    t= record.tbsimbolo.tablaLocal.get(acm.getId());
                }
                else if(ac instanceof AccessArreglo){
                    acarr=((AccessArreglo)ac);
                    t=record.tbsimbolo.tablaLocal.get(acarr.getNombre());
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
        else if(tipo instanceof TipoArray){
            tarray=((TipoArray)tipo);
            
            builder.append("ldloc ").append(TablaIds.getInstancia().getVariableNumber(tmp.getName())).append("\n");
            for(int i=0;i<tmp.lista.size();i++){
                if(tmp.lista.get(i) instanceof AccessArreglo){
                    acarr=((AccessArreglo)tmp.lista.get(i));
                    builder.append(acarr.lista.generarCodigo());
                }
                else if(tmp.lista.get(i) instanceof AccessMiembro){
                    acm=((AccessMiembro)tmp.lista.get(i));
                     
                }
            }
            
            
            

            builder.append(valor.generarCodigo());
             if(tarray.getT() instanceof TipoInt && tmp.lista.size() <=1){
                builder.append("stelem.i4\n");
             }
             else if(tarray.getT() instanceof TipoFloat && tmp.lista.size() <=1){
                builder.append("stelem.r4\n");
             }
             else if(tarray.getT() instanceof TipoInt && tmp.lista.size() >1){
                builder.append("call instance void ");
                TipoInt tmpint=((TipoInt)tarray.getT());
                builder.append(tmpint.toString()).append("[");
                for( int ii=1;ii<tarray.sizearreglos.size();ii++){
                    builder.append(",");
                }
                builder.append("]::Set(").append(tmpint.toString());
                for( int ii=0;ii<tarray.sizearreglos.size();ii++){
                builder.append(",").append(tarray.sizearreglos.get(ii).toString());
                }
                builder.append(")\n");
             }
             else if(tarray.getT() instanceof TipoFloat && tmp.lista.size() >1){
                builder.append("call instance void ");
                TipoFloat tmpint=((TipoFloat)tarray.getT());
                builder.append(tmpint.toString()).append("[");
                for( int ii=1;ii<tarray.sizearreglos.size();ii++){
                    builder.append(",");
                }
                builder.append("]::Set(").append(tmpint.toString());
                for( int ii=0;ii<tarray.sizearreglos.size();ii++){
                builder.append(",").append(tarray.sizearreglos.get(ii).toString());
                }
                builder.append(")\n");
             }
            /*Tipo derecho=null;
            try {
                derecho=valor.validarSemantica();
            } catch (Exception ex) {
                Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(derecho instanceof TipoInt){
                builder.append("stelem.i4\n");
            }
            else if(derecho instanceof TipoFloat){
                builder.append("stelem.r4\n");
            }*/
            return builder.toString();
            
        }
        else{
            return valor.generarCodigo() + "stloc "+ TablaIds.getInstancia().getVariableNumber(tmp.getName())+ "\n";
        }
    }
    
    
}
