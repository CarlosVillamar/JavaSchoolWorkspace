package gooogleCodeCollection;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TroubleSort {

	static ArrayList<Integer> numlist = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Give me a set of numbers one by one");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			int num = Integer.parseInt(reader.readLine());
			numlist.add(num);
			
			troubleSort(numlist);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static  void troubleSort(ArrayList<Integer> list){
		Boolean done = false;
		int [] numarr = new int[list.size()];
		while(!done){
			int temp = 0;
			for(int i = 0; i<numarr.length; i++){
				if(list.get(i)>list.get(i+2)){
					done = false;
					temp = list.get(i);
					list.set(i,list.get(i+2));
					list.set(i+2,temp);
					
					if(list.get(i)>list.get(i+1)){
						done = false;
						temp = list.get(i);
						list.set(i, list.get(i+2));
						list.set(i+1, temp);
					}
					
				}else if (list.get(i)>list.get(i+1)){
					temp = list.get(i);
					list.set(i, list.get(i+2));
					list.set(i+1, temp);
					done = true;
				}
			}
		}
		System.out.println(numarr);
		
	}

}
