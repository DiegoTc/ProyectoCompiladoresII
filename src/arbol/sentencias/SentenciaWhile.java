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
public class SentenciaWhile extends Sentencia{
    Sentencia bloque;
    Expresion expr1;

    public Sentencia getBloque() {
        return bloque;
    }

    public void setBloque(Sentencia bloque) {
        this.bloque = bloque;
    }

    public Expresion getExpr1() {
        return expr1;
    }

    public void setExpr1(Expresion expr1) {
        this.expr1 = expr1;
    }

    public SentenciaWhile(Sentencia bloque, Expresion expr1) {
        this.bloque = bloque;
        this.expr1 = expr1;
    }

    @Override
    public void validarSemantica() {
        Tipo condicion=null;
        try {
          condicion  =expr1.validarSemantica();
        } catch (Exception ex) {
            Logger.getLogger(SentenciaWhile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(condicion instanceof TipoBooleano){
            Sentencia tmp= bloque;
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
        String etiqueta1 = Info.getIntancia().getEtiqueta("While");
        String etiqueta2 = Info.getIntancia().getEtiqueta("EndWhile");
        String etiqueta3=Info.getIntancia().getEtiqueta("CONDICION");
        
        String inicio= "br "+etiqueta3+ "\n"+ etiqueta1+ ":\n"+bloque.generarCodigo();
        String cond= etiqueta3+":\n"+expr1.generarCodigo()+etiqueta1+"\n"+etiqueta2+":";
        
        return inicio+cond;
       
    }
    
    
}
