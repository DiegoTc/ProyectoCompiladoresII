/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

/**
 *
 * @author diego
 */
public abstract class Sentencia {
    Sentencia siguiente;

    public Sentencia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Sentencia siguiente) {
        this.siguiente = siguiente;
    }
     public abstract void validarSemantica();

     public void SentValSemantica()
     {
         validarSemantica();
         if (siguiente != null)
         {
            siguiente.SentValSemantica();
         }            
     }
     
     public abstract String generarCodigoSentencia();
    
    public String generarCodigo()
    {
        String valor=this.generarCodigoSentencia();
        if(siguiente!= null)
        {
            valor+=siguiente.generarCodigo();
        }
        return valor;
    }
    
    
}
