import java.io.*;
import java.util.*;


public class scanner_driver {
  static public void main(String argv[]) {    
    /* Start the parser */
	System.out.println("Beginning parse ...");
    try {
      parser p = new parser(new Lexer(new FileReader(argv[0])));
      Node result = (Node)p.parse().value;
	  System.out.println(result);
	  for(int i = 0; i < result.class_list.size(); i++){
		  System.out.println("Class name " + result.class_list.get(i).name);
		  System.out.println("Super class " + result.class_list.get(i).super_class);
		  
	  }
	  System.out.println("Parsing completed with no errors");     
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}