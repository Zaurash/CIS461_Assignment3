import java.io.*;
import java.util.*;


public class scanner_driver {
  static public void main(String argv[]) {    
    /* Start the parser */
	System.out.println("Beginning parse ...");
    try {
      parser p = new parser(new Lexer(new FileReader(argv[0])));
      Program result = (Program)p.parse().value;
	  System.out.println("Parsing completed with no errors");    
	  LinkedList class_names = new LinkedList<String>();
	  LinkedList super_names = new LinkedList<String>();
	  LinkedList visited = new LinkedList<String>();
	  class_names.addAll(Arrays.asList("Obj", "String", "Int"));
	  for(int i = 0; i < result.class_list.size(); i++){
		  String c_name = result.class_list.get(i).name;
		  String c_super = result.class_list.get(i).super_class;
		  class_names.add(c_name);
		  super_names.add(c_super);
	  }
	  
	  for(int i = 0; i < result.statement_list.size(); i++){
	  	
	  }
	  
	  /* Tests to see if superclasses are existing classes */
	  
	  for(int i = 0; i < result.class_list.size(); i++){
		  String temp = result.class_list.get(i).super_class;
		  if(!class_names.contains(temp)){
  		  	System.err.println("ERROR: super class " + temp + " does not exist ");
			System.exit(1);
		  }
		  /* Check if there are any loops in the class hierarchy */
		  else{
			  CLS.loop_check(result, visited, temp);
		  }
	  } 
	  
	  
	  

	  
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}