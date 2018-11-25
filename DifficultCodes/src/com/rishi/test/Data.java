package com.rishi.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Data
{
    private String message ;
    
    public void setMessage( String m ) { message = m ; }
    public String getMessage( ) { return message ; }
    
    public static void main(String[] args) {
		Random random = new Random();
		List<String> list = new ArrayList<>();
		list.add("Red");
		list.add("Pink");
		list.add("Yellow");
		list.add("Green");
		list.add("Blue");
		list.add("White");
		
		int index = random.nextInt(list.size());
		System.out.println(list.get(index));
		list.remove(index);
		
		index = random.nextInt(list.size());
		System.out.println(list.get(index));
		list.remove(index);
		
		index = random.nextInt(list.size());
		System.out.println(list.get(index));
		list.remove(index);
	}
    
}
