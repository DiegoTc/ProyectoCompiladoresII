/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import arbol.expresiones.*;
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
            if(InfSemantica.getInstancia().tablaGlobal.containsKey(tmp.getName()))
            {
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
