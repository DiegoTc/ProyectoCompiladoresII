/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;


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
        compound.s1.validarSemantica();
    }
    
}   
