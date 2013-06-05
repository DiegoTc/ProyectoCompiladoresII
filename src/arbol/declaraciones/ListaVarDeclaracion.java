/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ListaVarDeclaracion extends Declaracion{
     public ArrayList<Declaracion> lista;

    public ListaVarDeclaracion() {
        lista=new ArrayList<Declaracion>();
    }

    @Override
    public void validarSemantica() {
      for(int i=0;i<lista.size();i++)
      {
          lista.get(i).validarSemantica();
      }
    }
     
}
