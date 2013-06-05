/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ListaConstantDeclaracion extends Declaracion {
    public ArrayList<Declaracion> lista;

    public ListaConstantDeclaracion() {
        lista= new ArrayList<Declaracion>();
    }

    @Override
    public void validarSemantica() {
       
    }
    
}
