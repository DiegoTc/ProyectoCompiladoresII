
import Generacion.TablaIds;
import arbol.declaraciones.Program;
import arbol.sentencias.Sentencia;
import java.io.*;
import java.util.Hashtable;
   
public class Main {
  static public void main(String argv[]) {    
    /* Start the parser */
      
    try {
      parser p = new parser(new Lexer(new FileReader("/home/diego/UNITEC/2013/CompiladoresII/ProyectoCompi2Cup/src/sort.pas")));
      Program result = (Program)p.parse().value;
      result.ValidarSemantica();
      System.out.println(TablaIds.getInstancia().getLocals());
      System.out.println(result.GenerarCodigo());
      System.out.println(TablaIds.getInstancia().getFinal());

      //System.out.println("Programa Terminado");
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}


