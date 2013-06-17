/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generacion;

import arbol.tipos.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import semantica.InfSemantica;

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
     
     public String getVariables()
     {
         StringBuilder local=new StringBuilder();
         StringBuilder arreglos= new StringBuilder();
          local.append(".method static public void main() il managed { \n" +".entrypoint \n" +" .maxstack 100\n" + ".locals init (");
          Tipo t=null;
          TipoRecord trecord=null;
          TipoArray tarray=null;
          //Collections.reverse(lista);
          //Collections.reverse(tipos);
          for(int i=0;i<lista.size();i++)
         {
             if(InfSemantica.getInstancia().tablaGlobal.containsKey(lista.get(i)))
             {
                 t= InfSemantica.getInstancia().tablaGlobal.get(lista.get(i));
                 if(t instanceof TipoRecord){
                    trecord=((TipoRecord)t);
                    int id=TablaIds.getInstancia().getVariableNumber(lista.get(i));
                    local.append("valuetype Ejemplo.").append(trecord.nombre).append("\t").append(lista.get(i)).append(id);
                    if(i<lista.size()-1)
                    {
                        local.append(",").append("\n");
                    }
                 }
                 else if(t instanceof TipoArray){
                     tarray=((TipoArray)t);
                     local.append(tarray.getT()).append("[");
                     
                     for( int ii=1;ii<tarray.sizearreglos.size();ii++){
                         local.append(",");
                     }
                     for( int ii=0;ii<tarray.sizearreglos.size();ii++){
                         arreglos.append(tarray.sizearreglos.get(ii).generarCodigo());
                     }
                     String tip="";
                     if(tarray.getT() instanceof TipoInt){
                         tip="Int32";
                     }
                     else if(tarray.getT() instanceof TipoFloat){
                         tip="Single";
                     }
                     if(tarray.sizearreglos.size()<=1){
                        arreglos.append("newarr [mscorlib]System.").append(tip).append("\n");
                     }
                     else{
                         arreglos.append("newobj instance void ").append(tarray.getT().toString()).append("[");
                         for( int ii=1;ii<tarray.sizearreglos.size();ii++){
                            arreglos.append(",");
                         }
                         arreglos.append("]::'.ctor'(").append(tarray.getT().toString());
                         for(int ii=1;ii<tarray.sizearreglos.size();ii++){
                             arreglos.append(",").append(tarray.sizearreglos.get(ii).toString());
                        }
                         arreglos.append(")\n");
                     }
                     arreglos.append("stloc ").append(getVariableNumber(lista.get(i))).append("\n");
                     local.append("]");
                     local.append(" ").append(lista.get(i));
                     if(i<lista.size()-1)
                     {
                        local.append(",\n");
                     }
                 }
                 else{
                    local.append(tipos.get(i));
                    local.append(" ").append(lista.get(i));
                    if(i<lista.size()-1)
                    {
                        local.append(",\n");
                    }
                }
             }
             
         }
         local.append(")\n");
         local.append(arreglos.toString());
         return local.toString();
     }
     
     
      public String getLocals()
     {
         StringBuilder local=new StringBuilder(".assembly extern mscorlib {}\n");
         local.append(".assembly Test{\n"+"\t.ver 1:0:1:0"+"\n}\n"+".module test.exe\n");
         return local.toString();
     }
      
      public String getFinal()
     {
         return " ret\n"+"}";
     }
}
