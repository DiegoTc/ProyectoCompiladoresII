/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.Tipo;
import arbol.tipos.TipoFloat;
import arbol.tipos.TipoInt;

/**
 *
 * @author diego
 */
public class ExpreDivision extends ExpreOperadorBinario{

    public ExpreDivision(Expresion izquierdo, Expresion derecho) {
        super(izquierdo, derecho);
    }
    
    @Override
    public Tipo validarSemantica() throws Exception {
        Tipo izq,der;
        izq=izquierdo.validarSemantica();
        der=derecho.validarSemantica();
        if (izq instanceof TipoInt){
            if (der instanceof TipoInt || der instanceof TipoFloat ){
                return izq;
            }
            else{
                throw new Exception("Error Semantico no se puede dividir un Tipo Int con un Tipo "+ der.toString());
            }
        }
        else if(izq instanceof TipoFloat){
            if(der instanceof TipoFloat || der instanceof TipoInt){
                return izq;
            }
            else{
                throw new Exception("Error Semantico no se puede dividir un Tipo Float con un Tipo "+ der.toString());
            }
        }
        else{
            throw new Exception("Error Semantico no se puede dividir Tipo "+ izq.toString()+ " con Tipo "+ der.toString());
        }
     }
}
