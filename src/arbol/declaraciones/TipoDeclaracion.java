/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import arbol.tipos.Tipo;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class TipoDeclaracion extends Declaracion{
      String nombre;
    Tipo tipo;

    public TipoDeclaracion(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public void validarSemantica() {
        
        if(InfSemantica.getInstancia().tablaGlobal.containsKey(nombre))
        {
            try {
                throw new Exception("Error Semantico--- Ya existe una variable con ese nombre");
            } catch (Exception ex) {
                Logger.getLogger(TipoDeclaracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            InfSemantica.getInstancia().tablaGlobal.put(nombre, tipo);
        }
    }
}
