/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import Generacion.Info;
import arbol.tipos.Tipo;
import arbol.tipos.TipoBooleano;

/**
 *
 * @author diego
 */
public class ExpreAnd extends ExpreOperadorBinario{

    public ExpreAnd(Expresion izquierdo, Expresion derecho) {
        super(izquierdo, derecho);
    }

    @Override
    public Tipo validarSemantica() throws Exception {
        Tipo izq,der;
        izq=izquierdo.validarSemantica();
        der=derecho.validarSemantica();

            if (der instanceof TipoBooleano || der instanceof TipoBooleano ){
                return izq;
            }
            else{
                throw new Exception("Error Semantico no se puede comparar Tipo "+ izq.toString()+ " con Tipo "+ der.toString());
        }
     }
    
    @Override
    public String generarCodigo() {  
        return izquierdo.generarCodigo()+derecho.generarCodigo();
    } 
}
