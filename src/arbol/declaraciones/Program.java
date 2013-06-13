/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import Generacion.TablaIds;
import arbol.sentencias.Sentencia;


/**
 *
 * @author diego
 */
public class Program {
    Bloque compound;

    public Bloque getCompound() {
        return compound;
    }

    public void setCompound(Bloque compound) {
        this.compound = compound;
    }

    public Program(Bloque compound) {
        this.compound = compound;
    }

    public void ValidarSemantica()
    {
        compound.d1.validarSemantica();
        Sentencia tmp=compound.s1;
        while(tmp!=null){
            tmp.validarSemantica();
            tmp=tmp.getSiguiente();
        }
    }
    
    public String GenerarCodigo()
    {
        if(compound.d1 instanceof DeclaracionSecuencia){
            DeclaracionSecuencia tmp= ((DeclaracionSecuencia)compound.d1);
            String classes=tmp.getRecords();
            return classes+ TablaIds.getInstancia().getVariables()+compound.s1.generarCodigo();
        }
        return TablaIds.getInstancia().getVariables()+ compound.s1.generarCodigo();
    }
    
}   
