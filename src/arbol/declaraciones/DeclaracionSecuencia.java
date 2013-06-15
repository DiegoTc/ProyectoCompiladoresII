/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import arbol.tipos.Tipo;
import arbol.tipos.TipoArray;
import arbol.tipos.TipoRecord;
import java.util.Collections;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class DeclaracionSecuencia extends Declaracion{
    Declaracion cons;
    Declaracion tipo;
    Declaracion var;
    Declaracion fun;

    public DeclaracionSecuencia(Declaracion cons, Declaracion tipo, Declaracion var, Declaracion fun) {
        this.cons = cons;
        this.tipo = tipo;
        this.var = var;
        this.fun = fun;
    }

    public Declaracion getCons() {
        return cons;
    }

    public void setCons(ConstantDeclaracion cons) {
        this.cons = cons;
    }

    public Declaracion getFun() {
        return fun;
    }

    public void setFun(FuncionDeclaracion fun) {
        this.fun = fun;
    }

    public Declaracion getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeclaracion tipo) {
        this.tipo = tipo;
    }

    public Declaracion getVar() {
        return var;
    }

    public void setVar(VarDeclaracion var) {
        this.var = var;
    }

    @Override
    public void validarSemantica() {
        if(cons!=null){
            cons.validarSemantica();
        }
        if(tipo!=null){
            tipo.validarSemantica();
            Declaracion t=tipo.getSiguiente();
            if(t!=null){
                TipoDeclaracion tmp=((TipoDeclaracion)t);
                while(tmp!=null)
                {
                   tmp.validarSemantica(); 
                   t=t.getSiguiente();
                   if(t!=null){
                       tmp=((TipoDeclaracion)t);
                   }
                   else{tmp=null;}
                }
            }
        }
        if(var!=null){
           var.validarSemantica();
            Declaracion t=var.getSiguiente();
            if(t!=null){
                VarDeclaracion tmp=((VarDeclaracion)t);
                while(tmp!=null)
                {
                   tmp.validarSemantica(); 
                   t=t.getSiguiente();
                   if(t!=null){
                       tmp=((VarDeclaracion)t);
                   }else{tmp=null;}
                }
            }
        }
        if(fun!=null){
            fun.validarSemantica();
            Declaracion t=fun.getSiguiente();
            if(t!=null){
                FuncionDeclaracion tmp=((FuncionDeclaracion)t);
                while(tmp!=null)
                {
                   tmp.validarSemantica(); 
                   t=t.getSiguiente();
                   if(t!=null){
                       tmp=((FuncionDeclaracion)t);
                   }else{tmp=null;}
                }
            }
        }
    }
    
      public String getRecords(){
        StringBuilder resultado= new StringBuilder();
        if(tipo!=null){
        
        Declaracion tmp= tipo;
        TipoDeclaracion tdecl=null;
        TipoRecord trec1=null;
        while(tmp!=null)
        {
            if(tmp instanceof TipoDeclaracion)
            {
                resultado.append(".namespace Ejemplo{\n");
                tdecl=((TipoDeclaracion)tmp);
                resultado.append("\t.class private sequential ansi sealed beforefieldinit ").append(tdecl.getNombre());
                resultado.append(" extends [mscorlib]System.ValueType{\n");
                Tipo t= InfSemantica.getInstancia().tablaGlobal.get(tdecl.getNombre());
                TipoRecord record= ((TipoRecord)t);
                Collections.reverse(record.tbsimbolo.lista);
                Collections.reverse(record.tbsimbolo.tipos);
                for(int i=0;i<record.tbsimbolo.lista.size();i++)
                {
                    if(record.tbsimbolo.tipos.get(i) instanceof TipoRecord){
                        trec1=((TipoRecord)record.tbsimbolo.tipos.get(i));
                        resultado.append("\t\t.field  public\t").append("valuetype Ejemplo.").append(trec1.nombre).append(" ").append(record.tbsimbolo.lista.get(i)).append("\n");
                    }
                    else if(record.tbsimbolo.tipos.get(i) instanceof TipoArray){
                        /* Falta las validaciones para los arreglos **/
                    }
                    else{
                        resultado.append("\t\t.field  public\t").append(record.tbsimbolo.tipos.get(i).toString()).append(" ").append(record.tbsimbolo.lista.get(i)).append("\n");
                    }
                }
            resultado.append("\n\t}\n}\n");
            }
            tmp=tmp.getSiguiente();
        }
        
        }
        else{
            resultado.append("");
        }
        return resultado.toString();
    }
    
}
