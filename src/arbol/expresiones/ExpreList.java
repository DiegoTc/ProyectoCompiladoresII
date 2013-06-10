/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.Tipo;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ExpreList extends Expresion{
    public ArrayList<Expresion> lista= new ArrayList<>();

    public ArrayList<Expresion> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Expresion> lista) {
        this.lista = lista;
    }

    public ExpreList() {
        
    }

    @Override
    public Tipo validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    
    
}
