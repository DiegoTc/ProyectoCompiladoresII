/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.declaraciones;

import Generacion.TablaIds;
import arbol.expresiones.Expresion;
import arbol.sentencias.Sentencia;
import arbol.tipos.Tipo;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantica.InfSemantica;

/**
 *
 * @author diego
 */
public class FuncionDeclaracion extends Declaracion{
    String nombre;
    Tipo tipo;
    Expresion expr;
    Sentencia compound;

    public FuncionDeclaracion(String nombre, Tipo tipo, Expresion expr, Sentencia compound) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.expr = expr;
        this.compound = compound;
    }

    public Sentencia getCompound() {
        return compound;
    }

    public void setCompound(Sentencia compound) {
        this.compound = compound;
    }
    
    

    public Expresion getExpr() {
        return expr;
    }

    public void setExpr(Expresion expr) {
        this.expr = expr;
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

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Declaracion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Declaracion siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public void validarSemantica() {
       if(InfSemantica.getInstancia().tablaFunciones.containsKey(nombre)&&InfSemantica.getInstancia().tablaGlobal.containsKey(nombre)
          &&TablaIds.getInstancia().getVariableNumber(nombre)==-1          )
       {
            try {
                throw new Exception("Error Semantico--- Ya existe una variable con ese nombre");
            } catch (Exception ex) {
                Logger.getLogger(FuncionDeclaracion.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       else
       {
           InfSemantica.getInstancia().tablaGlobal.put(nombre, tipo);
           InfSemantica.getInstancia().tablaFunciones.put(nombre, new FuncionDeclaracion(nombre, tipo, expr, compound));
           TablaIds.getInstancia().addVariable(nombre,tipo.toString());
       }
    }
    
    
}
