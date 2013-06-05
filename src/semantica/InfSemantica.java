/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semantica;

import arbol.declaraciones.FuncionDeclaracion;
import arbol.tipos.*;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class InfSemantica {
    public HashMap<String, Tipo> tablaGlobal= new HashMap<>();
    public HashMap<String, FuncionDeclaracion> tablaFunciones= new HashMap<>();
    public HashMap<String, Tipo> tablaTipos= new HashMap<>();
    private static InfSemantica instance=null;

    InfSemantica() {
        tablaTipos.put("int", new TipoInt());
        tablaTipos.put("String", new TipoString());
        tablaTipos.put("float", new TipoFloat());
        tablaTipos.put("Boolean", new TipoBooleano());
        tablaTipos.put("char", new TipoChar());
    }
    
    public static InfSemantica getInstancia()
    {
        if(instance== null)
        {
            instance= new InfSemantica();
        }
        return instance;
    }
}