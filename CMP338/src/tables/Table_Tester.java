package tables;

import treeRefBased.BinarySearchTree;
import treeRefBased.person;
import treeRefBased.TreeIterator;

public class Table_Tester {

	public static void main(String[] args) {
	
			person [] people = {
					new person("1009", 99, "Gonzo"),
					new person("2241", 39, "Elmo"),
					new person("0824", 37, "Kobe"),
					new person("9214", 54, "Mofongo"),
					new person("3254", 96, "Mangu"),
					new person("1337", 109, "Sancocho"),
					new person("8732", 99, "Gonzo"),
					};
			System.out.println("show unsorted");
			displayArr(people);
			people = treeSort(people);
			System.out.println("\n\nshow sorted");
			displayArr(people);
			
		/*	
		TableInterface<Person,String> myTable = new TableBSTBased<Person,String>();
		try{
			for(int i=0; i<people.length; i++){
				myTable.tableInsert(people[i]);
			}

			System.out.println("show gonzo" + myTable.tableRetrieve("8732"));
			System.out.println("delete gonzo" + myTable.tableDelete("8732"));
			System.out.println(myTable.tableRetrieve("0824"));
			System.out.println(myTable.tableRetrieve("9214"));
			System.out.println("show nada" + myTable.tableRetrieve("9999"));
			System.out.println("show gonzo" + myTable.tableRetrieve("8732"));
			System.out.println(myTable.tableRetrieve("2241"));
		}catch(TableException tabEx){
			tabEx.printStackTrace();
		}
		
		*/
	}
	
	public static void displayArr(person [] arr){
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	
	public static person [] treeSort(person[] arr){
		person[] sortedArr = new person[arr.length];
		BinarySearchTree <person,String> bst = new BinarySearchTree <person,String> ();
		for(int i=0; i<arr.length; i++){
			bst.insert(arr[i]);
		}
		TreeIterator<person> btIter = new TreeIterator<>(bst);
		btIter.setInOrder();
		int i=0;
		while(btIter.hasNext()){
			sortedArr[i]= btIter.next();
			i++;
		}
		return sortedArr;
		
		
		
	}

}
