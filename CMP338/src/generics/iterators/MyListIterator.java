package generics.iterators;

import generics.ListInterface;
import generics.ListOutOfBoundsException;

import java.util.NoSuchElementException;

public class MyListIterator<T> implements java.util.ListIterator<T>{

	private ListInterface<T> list;
	private int cursor; //where are we in the list
	private int lastItemIndex;//prev() or next() index
	
	public MyListIterator(ListInterface<T> list){
		this.list = list;
		cursor =0;
		lastItemIndex = -1;
	}

	@Override
	public boolean hasNext() {
		return (cursor < list.size());
	}

	@Override
	public T next() throws java.util.NoSuchElementException{
		try {
			T item = list.get(cursor);
			lastItemIndex = cursor;
			cursor++;
			return item;
		} catch (ListOutOfBoundsException e) {
			throw new java.util.NoSuchElementException("there is no next!!!!");
		}
		
	}

	@Override
	public boolean hasPrevious() {
		return (cursor > 0);
	}

	@Override
	public T previous() throws java.util.NoSuchElementException{
		try {
			T item = list.get(cursor-1);
			lastItemIndex = cursor;
			cursor--;
			return item;
		} catch (ListOutOfBoundsException e) {
			throw new java.util.NoSuchElementException("there is no previous!!!!");
		}
		
	}

	@Override
	public int nextIndex() {
		return cursor;
	}

	@Override
	public int previousIndex() {
		return cursor-1;
	}

	@Override
	public void remove() {
		//programming problem 10
	}

	@Override
	public void set(T e) {
		//programming problem 10
		
	}

	@Override
	public void add(T item) {
		try {
			list.add(cursor, item);
			System.out.println("cursor is: "+cursor);
			lastItemIndex++;//=cursor;
			cursor++;
		} catch (ListOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//display reverse
	public void displayReverse(){
		cursor = list.size();
			System.out.println("\n\nDISPLAY REVERSE");
			try{
				while(hasPrevious()){
					System.out.println(previous());
				}
			}catch(NoSuchElementException nse){
				nse.printStackTrace();
			}
	}
			//display
	public void display(){
			System.out.println("\n\nDISPLAY");
			cursor=0;
			try{
				while(hasNext()){
					System.out.println(next());
				}
			}catch(NoSuchElementException nse){
				nse.printStackTrace();
			}

	}


	
	
	
}
