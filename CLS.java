import java.util.*;

public class CLS{
		
	public String name;
	public String super_class;
		
	public CLS(Ident n, Ident s){
		this.name = n.name;
		this.super_class = s.name;
	}
	
}