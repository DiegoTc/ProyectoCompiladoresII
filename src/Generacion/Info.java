/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generacion;

import java.util.Hashtable;

/**
 *
 * @author diego
 */
public class Info {
    
    static Info intancia = null;
    Hashtable<String, Integer> etiquetas = new java.util.Hashtable<>();

    private Info() {
    }

    public static Info getIntancia() {
        
        if (intancia == null)
        {
            intancia = new Info();
        }
        return intancia;
    }   
    
    public String getEtiqueta(String nombre)
    {
        String tmp;
        if(!etiquetas.containsKey(nombre))
        {
            etiquetas.put(nombre,0);
        }        
        
        tmp = nombre+etiquetas.get(nombre);        
        etiquetas.put(nombre, etiquetas.get(nombre)+1);
          
        return tmp;
        
    }
}