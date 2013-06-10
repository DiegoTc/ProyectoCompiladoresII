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
public class LiteralBooleana extends Expresion{
    Boolean valor;

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }

    public LiteralBooleana(Boolean valor) {
        this.valor = valor;
    }

    @Override
    public Tipo validarSemantica() {
        return InfSemantica.getInstancia().tablaTipos.get("Boolean");
    }
     @Override
    public String generarCodigo() {
         String value="";
         if(this.valor){
             value="1";
         }else{
             value="0";
         }
        return "ldc.i4 " +value+"\n";
                
    }
    
       @Override
    public String toString(){
        return "bool";
    }
}
