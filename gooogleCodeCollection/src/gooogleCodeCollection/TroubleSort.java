package gooogleCodeCollection;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TroubleSort {

	static ArrayList<Integer> numlist = new ArrayList<>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		try {
			System.out.println("Give me a number 3 or larger ");
			Scanner scanner = new Scanner(System.in);
			int setLength = scanner.nextInt();
			if(setLength>=3) {
				System.out.println("Enter " + setLength +" numbers one by one ");
				for(int i =0; i<setLength;i++) {
					int num2 = scanner.nextInt();
					numlist.add(num2);
				}
				
				troubleSort(numlist);
				
		}else {
			System.out.println("Whoops try again");
			System.exit(0);
		
			}
	}
	
	public static  void troubleSort(ArrayList<Integer> list){
		System.out.println("outtttt \n" + list);
		Boolean done = false;
//		int [] numarr = new int[list.size()];
		
		
			int temp = 0;
			for(int i = 0; i<=list.size()-1; i++){
//				System.out.println(list.get(i));
				if(i==list.size()-2) {
					
					if(list.get(i)>list.get(i+1)){
						temp = list.get(i);
						list.set(i, list.get(i+2));
						list.set(i+1, temp);
						done = true;
					}
					
				}else if(i==list.size()) {
					done=true;
					System.out.print("We sorted the list" );
					System.out.println(list);
				}else if(i<list.size()-1){
					System.out.println("index: " + String.valueOf(i) + " list size " + String.valueOf(list.size()-1));
					while(!done){//TODO: check this case
				
				if(list.get(i)>list.get(i+2)){
					System.out.println("number 2 indecies over is smaller " +  String.valueOf(list.get(i+1)));
					temp = list.get(i);
					list.set(i,list.get(i+2));
					list.set(i+2,temp);
					done = true;
					
//					if(list.get(i)>list.get(i+1)){
//						
//						temp = list.get(i);
//						list.set(i, list.get(i+1));
//						list.set(i+1, temp);
//						done = false;
//					}
					
				}else if (list.get(i)>list.get(i+1)){
					temp = list.get(i);
					System.out.println("number index over is smaller" +  String.valueOf(list.get(i+1)));
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					done = false;
					
				}
			}
			}
		}
	}


}
