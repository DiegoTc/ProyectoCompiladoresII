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
public class SentenciaRepeat extends Sentencia{
    Expresion condicion;
    Sentencia bloque;

    public Sentencia getBloque() {
        return bloque;
    }

    public void setBloque(Sentencia bloque) {
        this.bloque = bloque;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public SentenciaRepeat(Expresion condicion, Sentencia bloque) {
        this.condicion = condicion;
        this.bloque = bloque;
    }

   @Override
    public void validarSemantica() {
        Tipo cond=null;
        try {
          cond  =condicion.validarSemantica();
        } catch (Exception ex) {
            Logger.getLogger(SentenciaWhile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cond instanceof TipoBooleano){
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
        String etiqueta1=Info.getIntancia().getEtiqueta("Repeat");
        String etiqueta2=Info.getIntancia().getEtiqueta("FinRepeat");
        return etiqueta1+": \n"+bloque.generarCodigo()+condicion.generarCodigo()+etiqueta1+"\n"+etiqueta2+":\n";
    }
    
    
}
