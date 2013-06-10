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
public class ExpreEqual extends ExpreOperadorBinario{

    public ExpreEqual(Expresion izquierdo, Expresion derecho) {
        super(izquierdo, derecho);
    }
    
      @Override
    public Tipo validarSemantica() throws Exception {
        Tipo izq,der;
        izq=izquierdo.validarSemantica();
        der=derecho.validarSemantica();

            if (izq.esEquivalente(der)){
                return new TipoBooleano();
            }
            else{
                throw new Exception("Error Semantico no se puede comparar Tipo "+ izq.toString()+ " con Tipo "+ der.toString());
        }
     }
      
    @Override
    public String generarCodigo() {  
         String etiqueta1 = Info.getIntancia().getEtiqueta("Not Equal");
         return izquierdo.generarCodigo()+derecho.generarCodigo()+"bne.un "+etiqueta1+ "\n";
    } 
}
