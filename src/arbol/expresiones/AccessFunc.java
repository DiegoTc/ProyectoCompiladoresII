/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

/**
 *
 * @author diego
 */
public class AccessFunc extends Access{
    public ExpreList lista;

    public AccessFunc(ExpreList lista) {
        this.lista = lista;
    }

    public ExpreList getLista() {
        return lista;
    }

    public void setLista(ExpreList lista) {
        this.lista = lista;
    }
    
}
