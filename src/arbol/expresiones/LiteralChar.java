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
public class LiteralChar extends Expresion{
    char valor;

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public LiteralChar(char valor) {
        this.valor = valor;
    }
    @Override
    public Tipo validarSemantica() {
        return InfSemantica.getInstancia().tablaTipos.get("char");
    }
    
    @Override
    public String generarCodigo() {
        char[] c;
        c= new char[0];
        c[1]=this.valor;
        String charvalue= new String(c);       
        return "ldc.i4.s " +charvalue.format("%1$04x", ('c' & 0xFFFF))+"\n";
                
    }
    
      @Override
    public String toString(){
        return "char";
    }
}
