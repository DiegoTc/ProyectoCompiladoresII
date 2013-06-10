/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import arbol.tipos.*;

/**
 *
 * @author diego
 */
public class ExpreSuma extends ExpreOperadorBinario{

    public ExpreSuma(Expresion izquierdo, Expresion derecho) {
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
                throw new Exception("Error Semantico no se puede sumar un Tipo Int con un Tipo "+ der.toString());
            }
        }
        else if(izq instanceof TipoFloat){
            if(der instanceof TipoFloat || der instanceof TipoInt){
                return izq;
            }
            else{
                throw new Exception("Error Semantico no se puede sumar un Tipo Float con un Tipo "+ der.toString());
            }
        }
        else if(izq instanceof TipoString){
            if(der instanceof  TipoString || der instanceof TipoChar || der instanceof TipoFloat || der instanceof TipoInt){
                return izq;
            }
             else{
                throw new Exception("Error Semantico no se puede sumar un Tipo String con un Tipo "+ der.toString());
            }
        }
        else if(izq instanceof TipoChar){
            if(der instanceof TipoChar || der instanceof TipoInt){
                return izq;
            }
             else{
                throw new Exception("Error Semantico no se puede sumar un Tipo Char con un Tipo "+ der.toString());
            }
        }
        else{
            throw new Exception("Error Semantico no se puede sumar Tipo "+ izq.toString()+ " con Tipo "+ der.toString());
        
        }
    
    }
    
     @Override
    public String generarCodigo() {
        return izquierdo.generarCodigo()+derecho.generarCodigo()+"add\n";
    }
    
}
