/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.tipos;

import arbol.expresiones.Expresion;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class TipoArray extends Tipo{
    Expresion e;
    Tipo t;
    public ArrayList<Expresion> sizearreglos;
    public TipoArray(Expresion e, Tipo t) {
        this.e = e;
        this.t = t;
        sizearreglos=new ArrayList<>();
        converttoList();
    }

    public void converttoList(){
        Expresion tmp=e;
        while(tmp!=null){
            sizearreglos.add(tmp);
            tmp=tmp.siguiente;
        }
    }
    
    public Tipo getT() {
        return t;
    }

    public void setT(Tipo t) {
        this.t = t;
    }

    
    public Expresion getE() {
        return e;
    }

    public void setE(Expresion e) {
        this.e = e;
    }
     @Override
    public Boolean esEquivalente(Tipo t) {
        return t instanceof TipoArray;
    }
    @Override
    public String toString(){
        return "Array";
    }
     
}
