/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class SentenciaList extends Sentencia{
    ArrayList<Sentencia> lista;

    public ArrayList<Sentencia> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Sentencia> lista) {
        this.lista = lista;
    }

    public SentenciaList(ArrayList<Sentencia> lista) {
        this.lista = lista;
    }

    @Override
    public void validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    
    
}
