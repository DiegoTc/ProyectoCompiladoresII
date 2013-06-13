/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import Generacion.TablaIds;
import arbol.tipos.Tipo;
import arbol.tipos.TipoId;
import arbol.tipos.TipoRecord;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class TipoDeclaracion extends Declaracion{
      String nombre;
    Tipo tipo;

    public TipoDeclaracion(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public void validarSemantica() {
        
        if(InfSemantica.getInstancia().tablaGlobal.containsKey(nombre)&& TablaIds.getInstancia().getVariableNumber(nombre)==-1)
        {
            try {
                throw new Exception("Error Semantico--- Ya existe una variable con ese nombre");
            } catch (Exception ex) {
                Logger.getLogger(TipoDeclaracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            
            if(tipo instanceof TipoRecord)
            {
                TipoRecord tmp= ((TipoRecord)tipo);
                Declaracion tmp1=tmp.getDecl();
                VarDeclaracion var=null;
                
                String name=null;
                Tipo tip=null;
                tmp.nombre=nombre;
                while(tmp1 instanceof VarDeclaracion)
                {
                    var=((VarDeclaracion)tmp1);
                    for(int i=0;i< var.nombre.size();i++)
                    {
                        try {
                            name=var.nombre.get(i);
                            tip=var.getTipo();
                            if(tip instanceof TipoId)
                            {
                                TipoId tid= ((TipoId)tip);
                                if(InfSemantica.getInstancia().tablaGlobal.containsKey(tid.getNombre()))
                                {
                                    Tipo t= InfSemantica.getInstancia().tablaGlobal.get(tid.getNombre());
                                     tmp.tbsimbolo.addVariable(name, t);
                                     
                                }
                                else{
                                    throw new Exception("Error Semantico -- El tipo "+ name+ " no a sido declarado");
                                }
                            }
                            else{
                                tmp.tbsimbolo.addVariable(name, tip);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(TipoDeclaracion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    tmp1=tmp1.getSiguiente();   
                }
                InfSemantica.getInstancia().tablaGlobal.put(nombre, tmp);
               // TablaIds.getInstancia().addVariable(nombre, tmp.toString());
            }
            else
            {
                InfSemantica.getInstancia().tablaGlobal.put(nombre, tipo);
                TablaIds.getInstancia().addVariable(nombre,tipo.toString());
            }
        }
    }
    
  
}
