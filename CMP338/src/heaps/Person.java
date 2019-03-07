package heaps;

import tables.KeyedItem;

public class Person extends KeyedItem<String>{

	private String fName;
	private int age;
	private String id; 
	
	public Person(String id){
		super(id); // make the id the key... could use age or name as long as it is unique
	}
	
	public Person(String id, int age, String fn){
		super(id);
		this.age = age;
		fName = fn;
	}
	
	public String toString(){
		return getKey() + " FirstName: "+ fName + " Age: "+ age;
	}
}
