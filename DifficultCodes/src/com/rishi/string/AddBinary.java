package com.rishi.string;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Add two binary strings "11" + "1" = "100"
 * Concept is similar to adding Decimal numbers instead of dividing and moduling by 10 we do it here by 2 (binary)
 * 1. Keep adding the values in the carry, at last insert the carry%2 in 0 index
 * 2. Update carry with carry /= 2;
 * 3. Repeat till the condition is broken (prtA >= 0 || ptrB >= 0 || carry != 0)
 * 
 * 
 * @author rishi
 *
 */
public class AddBinary {
	ArrayList<String> li = new ArrayList<>(); 
	public static String add(String a, String b){
		if(a == null && b == null)
			return "";
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		int ptrA = a.length() - 1;
		int ptrB = b.length() - 1;
		StringBuilder result = new StringBuilder();
		int carry = 0;
		
		while(ptrA >= 0 || ptrB >= 0 || carry != 0){
		    if(ptrA >= 0){
		        carry += a.charAt(ptrA) - '0';
		    }
		    
		    if(ptrB >= 0){
		        carry += b.charAt(ptrB) - '0';
		    }
		    
		    result.insert(0, carry%2);
		    carry /= 2;
		    ptrB--;
		    ptrA--;
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(3/10);
//		System.out.println("Result "+ add("11", "1"));
		
        AddBinary obj = new AddBinary();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        str.append("\t\tScorpion Gas Pump\n\t San Fernando Street, San Jose\n");
        str.append("\n\t\tSale Receipt\n\n");
        Date date = new Date();
        str.append("\tDate\t\t\tTime\n");
        str.append("\t" + dateFormat.format(date) + " \t\t" + timeFormat.format(date)+ "\n\n");
        str.append("\tInvoice# " + random.nextInt(1000000) + "\n");
        str.append("\tMastercard \n\tAccount Number\t\t ***19 \n\n");
        str.append("\tGallons     Fuel Type     Total\n");
        str.append("\t%s          %s            $%s\n\n");
        
        str.append("\tAdditional Services\n");
        str.append("\tCar Wash\t\t$ 15.00\n\n");
        
        str.append("\t\tTHANK YOU!");
        
        String str1 = String.format(str.toString(), 10+"", 89+"", 30+"");
        StringBuilder str2 = new StringBuilder();
        System.out.println(str2.toString());
	}
	
}
