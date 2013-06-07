 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.Tipo;
import arbol.tipos.TipoBooleano;
import arbol.tipos.TipoFloat;
import arbol.tipos.TipoInt;

/**
 *
 * @author diego
 */
public class ExpreLessEqual extends ExpreOperadorBinario{

    public ExpreLessEqual(Expresion izquierdo, Expresion derecho) {
        super(izquierdo, derecho);
    }

    @Override
    public Tipo validarSemantica() throws Exception {
        Tipo izq,der;
        izq=izquierdo.validarSemantica();
        der=derecho.validarSemantica();
        if (izq instanceof TipoInt || der instanceof TipoFloat){
            if (der instanceof TipoInt || der instanceof TipoFloat ){
                return new TipoBooleano();
            }
            else{
                throw new Exception("Error Semantico no se puede comparar un Tipo Int o Float con un Tipo "+ der.toString());
            }
        }
        else{
                throw new Exception("Error Semantico no se puede comparar un Tipo Int o Float con un Tipo "+ der.toString());
        }
     }
    
}
