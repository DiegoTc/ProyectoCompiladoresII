/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import arbol.tipos.Tipo;
import java.util.ArrayList;
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
        for(int i=0;i<nombre.size();i++)
        {
            if(InfSemantica.getInstancia().tablaGlobal.containsKey(nombre.get(i)))
            {
                try {
                    throw new Exception("Error Semantico--- Ya existe una variable con ese nombre");
                } catch (Exception ex) {
                    Logger.getLogger(VarDeclaracion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                InfSemantica.getInstancia().tablaGlobal.put(nombre.get(i), tipo);
            }
        }
    }

   
    
    
}
