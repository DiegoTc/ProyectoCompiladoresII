/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;



/**
 *
 * @author diego
 */
public class TipoId extends Tipo{
   @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoId;
    }
    String nombre;

    public TipoId(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString()
    {
        return nombre;
    }
    
    
}
