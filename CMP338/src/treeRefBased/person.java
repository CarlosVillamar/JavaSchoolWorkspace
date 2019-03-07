package treeRefBased;

public class person extends KeyedItem<String>{

	private String fName;
	private int age;
	private String id; 
	
	public person(String id){
		super(id); // make the id the key... could use age or name as long as it is unique
	}
	
	public person(String id, int age, String fn){
		super(id);
		this.age = age;
		fName = fn;
	}
	
	public String toString(){
		return getKey() + " FirstName: "+ fName + " Age: "+ age;
	}
}