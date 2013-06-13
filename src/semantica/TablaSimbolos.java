/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semantica;

import arbol.tipos.Tipo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class TablaSimbolos {
    public HashMap<String, Tipo> tablaLocal= new HashMap<>();
    public ArrayList<String> lista=new ArrayList<String>();
    public ArrayList<Tipo> tipos=new ArrayList<Tipo>();
    public void addVariable(String nombre,Tipo tipo) throws Exception
     {
         if(!tablaLocal.containsKey(nombre))
         {
             tablaLocal.put(nombre, tipo );
             lista.add(nombre);
             tipos.add(tipo);
         }
         else
         {
             throw new Exception("Error - Semantico la variable "+ nombre + "ya fue declarada");
         }
     }
    
    public TablaSimbolos() {
    }
    
}
