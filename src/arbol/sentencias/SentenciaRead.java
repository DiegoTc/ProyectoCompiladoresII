/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.sentencias;

/**
 *
 * @author diego
 */
public class SentenciaRead extends Sentencia{
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SentenciaRead(String id) {
        this.id = id;
    }

    @Override
    public void validarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generarCodigoSentencia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
