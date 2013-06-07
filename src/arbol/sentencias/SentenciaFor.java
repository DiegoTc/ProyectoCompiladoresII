/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import arbol.expresiones.Expresion;
import arbol.tipos.Tipo;
import arbol.tipos.TipoBooleano;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class SentenciaFor extends Sentencia{
    String id;
    Expresion condicion,condicion2;
    Sentencia compound;

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sentencia getCompound() {
        return compound;
    }

    public void setCompound(Sentencia compound) {
        this.compound = compound;
    }

    public Expresion getCondicion2() {
        return condicion2;
    }

    public void setCondicion2(Expresion condicion2) {
        this.condicion2 = condicion2;
    }

    public SentenciaFor(String id, Expresion condicion, Expresion condicion2, Sentencia compound) {
        this.id = id;
        this.condicion = condicion;
        this.condicion2 = condicion2;
        this.compound = compound;
    }

    @Override
    public void validarSemantica() {
        Tipo var=null;
        if(InfSemantica.getInstancia().tablaGlobal.containsKey(id))
        {
            var=InfSemantica.getInstancia().tablaGlobal.get(id);
        }
        else{
            try {
                    throw new Exception("Error Semantico, la variable"+id+" no a sido declarada");
            } catch (Exception ex) {
                    Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Tipo val=null;
        try {
            val = condicion.validarSemantica();
        } catch (Exception ex) {
            Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
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
        Tipo val1=null;
        try {
            val1 = condicion2.validarSemantica();
        } catch (Exception ex) {
            Logger.getLogger(SentenciaAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(val1 instanceof TipoBooleano){
            Sentencia tmp= compound;
            while(tmp!=null){
                tmp.validarSemantica();
                tmp=tmp.getSiguiente();
            }
        }
            
    }
    

    


    
    
}
