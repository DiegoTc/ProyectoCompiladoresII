/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import Generacion.TablaIds;
import arbol.tipos.Tipo;
import arbol.tipos.TipoId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class VarDeclaracion extends Declaracion{
    public ArrayList<String> nombre;
    Tipo tipo;

    public VarDeclaracion(ArrayList<String> nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void validarSemantica() {
        Collections.reverse(nombre);
        for(int i=0;i<nombre.size();i++)
        {
            if(InfSemantica.getInstancia().tablaGlobal.containsKey(nombre.get(i))&& TablaIds.getInstancia().getVariableNumber(nombre.get(i))==-1)
            {
                try {
                    throw new Exception("Error Semantico--- Ya existe una variable con ese nombre");
                } catch (Exception ex) {
                    Logger.getLogger(VarDeclaracion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                if(tipo instanceof TipoId)
                {
                    TipoId tid=((TipoId)tipo);
                    if(InfSemantica.getInstancia().tablaGlobal.containsKey(tid.getNombre())){
                        Tipo t=InfSemantica.getInstancia().tablaGlobal.get(tid.getNombre());
                        InfSemantica.getInstancia().tablaGlobal.put(nombre.get(i), t);
                        TablaIds.getInstancia().addVariable(nombre.get(i),t.toString());
                    }
                }
                else
                {
                    InfSemantica.getInstancia().tablaGlobal.put(nombre.get(i), tipo);
                    TablaIds.getInstancia().addVariable(nombre.get(i),tipo.toString());
                }
            }
        }
    }

   
    
    
}
