/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import Generacion.Info;
import arbol.expresiones.Expresion;
import arbol.tipos.Tipo;
import arbol.tipos.TipoBooleano;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class SentenciaIf extends Sentencia{
    Expresion expr1;
    Sentencia condicion;
    Sentencia conElse;

    public Sentencia getConElse() {
        return conElse;
    }

    public void setConElse(Sentencia conElse) {
        this.conElse = conElse;
    }

    public Sentencia getCondicion() {
        return condicion;
    }

    public void setCondicion(Sentencia condicion) {
        this.condicion = condicion;
    }

    public Expresion getExpr1() {
        return expr1;
    }

    public void setExpr1(Expresion expr1) {
        this.expr1 = expr1;
    }

    public SentenciaIf(Expresion expr1, Sentencia condicion) {
        this.expr1 = expr1;
        this.condicion = condicion;
    }

    public SentenciaIf(Expresion expr1, Sentencia condicion, Sentencia conElse) {
        this.expr1 = expr1;
        this.condicion = condicion;
        this.conElse = conElse;
    }

    @Override
    public void validarSemantica() {
        Tipo cond=null;
        try {
          cond  =expr1.validarSemantica();
        } catch (Exception ex) {
            Logger.getLogger(SentenciaWhile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cond instanceof TipoBooleano){
            Sentencia tmp= condicion;
            while(tmp!=null){
                tmp.validarSemantica();
                tmp=tmp.getSiguiente();
            }
            tmp=conElse;
            while(tmp!=null){
                tmp.validarSemantica();
                tmp=tmp.getSiguiente();
            }
        }
        else{
            try {
                throw new Exception("Error Semantico -- La condicion tiene que ser booleana");
            } catch (Exception ex) {
                Logger.getLogger(SentenciaWhile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String generarCodigoSentencia() {
         String etiqueta1 = Info.getIntancia().getEtiqueta("If");
         String etiqueta2 = Info.getIntancia().getEtiqueta("EndIf");
         
         String cVerdadero = this.condicion.generarCodigo();
         String cFalso = conElse!=null ? this.conElse.generarCodigo(): "";
         String etiqueta3=conElse!=null ? Info.getIntancia().getEtiqueta("Else"):"";
         String etiqueta4=conElse!=null ? Info.getIntancia().getEtiqueta("Else"):"";
         
         return expr1.generarCodigo()+ etiqueta3+"\n"+etiqueta1+": \n"+cVerdadero+ "br "+ etiqueta2+
                 "\n"+etiqueta3+ ":\n"+cFalso + "br "+etiqueta4+"\n"+ etiqueta2+ ":\n"+ etiqueta4+ ":\n";
    }
    
}
