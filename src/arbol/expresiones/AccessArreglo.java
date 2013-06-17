/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

/**
 *
 * @author diego
 */
public class AccessArreglo extends Access{
    public Expresion lista;
    public Access nombre;

    public AccessArreglo(Expresion lista) {
        this.lista = lista;
    }

    public Expresion getLista() {
        return lista;
    }

    public void setLista(Expresion lista) {
        this.lista = lista;
    }

    public Access getNombre() {
        return nombre;
    }

    public void setNombre(Access nombre) {
        this.nombre = nombre;
    }
    
}
