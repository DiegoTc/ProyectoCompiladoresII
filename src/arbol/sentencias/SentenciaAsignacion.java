/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import arbol.expresiones.ExpreVariables;
import arbol.expresiones.Expresion;
import arbol.tipos.Tipo;
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
        Tipo var=null;
        if(id instanceof ExpreVariables)
        {
            ExpreVariables tmp=((ExpreVariables)id);
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
            Tipo val=valor.validarSemantica();
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
            
            /* Falta hacer las validaciones para arrays y records */
        }
       
    }
    
    
}
