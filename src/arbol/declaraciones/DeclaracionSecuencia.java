/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import arbol.tipos.Tipo;
import arbol.tipos.TipoRecord;
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
        resultado.append(".namespace Test{\n ");
        Declaracion tmp= tipo;
        TipoDeclaracion tdecl=null;
        while(tmp!=null)
        {
            if(tmp instanceof TipoDeclaracion)
            {
                tdecl=((TipoDeclaracion)tmp);
                resultado.append(".class public auto ansi beforefieldinit ").append(tdecl.getNombre());
                resultado.append(" extends [mscorlib]System.Object{\n");
                Tipo t= InfSemantica.getInstancia().tablaGlobal.get(tdecl.getNombre());
                TipoRecord record= ((TipoRecord)t);
                for(int i=0;i<record.tbsimbolo.lista.size();i++)
                {
                    resultado.append(".field  public\t").append(record.tbsimbolo.tipos.get(i).toString()).append(" ").append(record.tbsimbolo.lista.get(i)).append("\n");
                }
                resultado.append(".method public hidebysig specialname rtspecialname instance default void '.ctor' ()  cil managed\n {");
                resultado.append(".maxstack 8\n");
                resultado.append("ldarg.0\n");
                resultado.append("call instance void object::'.ctor'()");
                resultado.append("ret\n }\n}");
            }
            tmp=tmp.getSiguiente();
        }
        resultado.append("\n}");
        }
        else{
            resultado.append("");
        }
        return resultado.toString();
    }
    
}
