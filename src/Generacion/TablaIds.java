/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generacion;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author diego
 */
public class TablaIds {
    private  TablaIds() {
    }
    
    private static TablaIds instancia=null;
    
    public static TablaIds getInstancia()
    {
        if(instancia == null)
        {
            instancia=new TablaIds();
        }
        return  instancia;
    }
    
     Hashtable<String,Integer> tabla= new Hashtable<>();
    ArrayList<String> lista=new ArrayList<String>();
    ArrayList<String> tipos=new ArrayList<String>();
     public void addVariable(String nombre,String tipo)
     {
         if(!tabla.containsKey(nombre))
         {
             tabla.put(nombre, new Integer(tabla.size()) );
             lista.add(nombre);
             tipos.add(tipo);
         }
     }
     
     public int getVariableNumber(String nombre)
     {
         if(tabla.containsKey(nombre))
         {
             return tabla.get(nombre).intValue();
         }
         return -1;
     }
     
      public String getLocals()
     {
         StringBuilder local=new StringBuilder(".assembly extern mscorlib {}\n");
         local.append(".assembly Test{\n"+"\t.ver 1:0:1:0"+"\n}\n"+".module test.exe\n");
         local.append(".method static public void main() il managed { \n" +".entrypoint \n" +" .maxstack 100\n" + ".locals init (");
         for(int i=0;i<lista.size();i++)
         {
             local.append(tipos.get(i));
             local.append(" "+lista.get(i));
             if(i<lista.size()-1)
             {
                 local.append(",");
             }
         }
         local.append(")");
         return local.toString();
     }
      
      public String getFinal()
     {
         return " ret\n"+"}";
     }
}
