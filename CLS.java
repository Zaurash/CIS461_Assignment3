import java.util.*;

public class CLS{
		
	public String name;
	public String super_class;
		
	public CLS(Ident n, Ident s){
		this.name = n.name;
		this.super_class = s.name;
	}
		
		public static Boolean check_super(Program res, LinkedList lis, String s){
	  	  for(int inc = 0; inc < res.class_list.size(); inc++){
	  		  String temp = res.class_list.get(inc).name;
	  				  if(s == temp){
					return true;	  				  	
	  		  }
	  	  }
		  return false;
		}
		
		public static int loop_check(Program res, LinkedList visit, String s){			
		  if(s == "Obj"){
			  return 0;
		  }
		  
  	  	  for(int inc = 0; inc < res.class_list.size(); inc++){
			  CLS temp = res.class_list.get(inc);
			  
			  if(s.equals(temp.name)){

				  if(visit.contains(s)){
					  System.err.println("ERROR: Loop Detected in Class Hierarchy involving " + s);
					  System.exit(1);
				  }
				visit.add(s);

				loop_check(res, visit, temp.super_class);
			  }
		  }
		return 0;
		}


}