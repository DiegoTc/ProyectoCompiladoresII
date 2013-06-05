/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

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
    
}
