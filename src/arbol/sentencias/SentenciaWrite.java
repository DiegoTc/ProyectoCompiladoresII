/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import arbol.expresiones.*;
import arbol.tipos.Tipo;
import arbol.tipos.TipoArray;
import arbol.tipos.TipoRecord;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class SentenciaWrite extends Sentencia{
    Expresion expre1;

    public Expresion getExpre1() {
        return expre1;
    }

    public void setExpre1(Expresion expre1) {
        this.expre1 = expre1;
    }

    public SentenciaWrite(Expresion expre1) {
        this.expre1 = expre1;
    }

    @Override
    public void validarSemantica() {
        try {
            expre1.validarSemantica();
        } catch (Exception ex) {
            Logger.getLogger(SentenciaWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String generarCodigoSentencia() {
        String tipo=getTipo(expre1);
        return expre1.generarCodigo()+ "call void [mscorlib]System.Console::WriteLine (" + tipo+")\n";
    }
    
    private String getTipo(Expresion expre1)
    {
        if(expre1 instanceof LiteralChar){
            LiteralChar c=((LiteralChar)expre1);
            return c.toString();
        }
        else if(expre1 instanceof LiteralEntero)
        {
            LiteralEntero c=((LiteralEntero)expre1);
            return c.toString();
        }
        else if(expre1 instanceof LiteralFloat)
        {
            LiteralFloat c=((LiteralFloat)expre1);
            return c.toString();
        }
        else if(expre1 instanceof LiteralString)
        {
            LiteralString c=((LiteralString)expre1);
            return c.toString();
        }
        else if(expre1 instanceof LiteralBooleana)
        {
            LiteralBooleana c=((LiteralBooleana)expre1);
            return c.toString();
        }
        else if(expre1 instanceof ExpreVariables)
        {
            ExpreVariables tmp= ((ExpreVariables)expre1);
            Tipo t=null;
            TipoRecord trecord=null;
            
            if(InfSemantica.getInstancia().tablaGlobal.containsKey(tmp.getName()))
            {
                t=InfSemantica.getInstancia().tablaGlobal.get(tmp.getName());
                if(t instanceof TipoRecord)
                {
                    trecord=((TipoRecord)t);
                    StringBuilder builder=new StringBuilder();
                    Access ac=null;
                    AccessMiembro acm=null;
                    AccessArreglo acarreglo=null;
                    for(int i=0;i<tmp.lista.size();i++)
                    {
                        ac=tmp.lista.get(i);
                        if(ac instanceof AccessMiembro)
                        {
                            acm=((AccessMiembro)ac);
                            if(trecord.tbsimbolo.tablaLocal.get(acm.getId()) instanceof TipoRecord){
                                t=trecord.tbsimbolo.tablaLocal.get(acm.getId());
                                trecord=((TipoRecord)t);
                            }
                            else{   
                                builder.append(trecord.tbsimbolo.tablaLocal.get(acm.getId()).toString());
                            }
                        }
                    }
                    return builder.toString();
                }
                else if(t instanceof TipoArray){
                    TipoArray tar=((TipoArray)t);
                    StringBuilder builder=new StringBuilder();
                    builder.append(tar.getT().toString());
                    return builder.toString();
                }
                return InfSemantica.getInstancia().tablaGlobal.get(tmp.getName()).toString();
            }
            else{
                return "-1";
            }
        }
            
        else
        {
            return "-1";
        }
    }
    
}
