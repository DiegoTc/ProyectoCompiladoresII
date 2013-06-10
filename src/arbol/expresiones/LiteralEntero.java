/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.Tipo;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class LiteralEntero extends Expresion{
    int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LiteralEntero(int valor) {
        this.valor = valor;
    }
    @Override
    public Tipo validarSemantica() {
        return InfSemantica.getInstancia().tablaTipos.get("int");
    }
    
    @Override
    public String generarCodigo() {
        return "ldc.i4 " +this.valor+"\n";
                
    }
    
      @Override
    public String toString(){
        return "int32";
    }
    
}
