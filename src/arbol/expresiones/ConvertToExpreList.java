/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.expresiones;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ConvertToExpreList {
   
    private ArrayList<String> lista;

    public ConvertToExpreList(ArrayList<String> lista) {
        this.lista = lista;
    }
    
    public ExpreList getLista()
    {
        ExpreList l=new ExpreList();
        LiteralString s=null;
        for(int i =0;i<lista.size();i++)
        {
            s= new LiteralString(lista.get(i));
            l.lista.add(s);
        }
        return l;
    }
    
     
}
