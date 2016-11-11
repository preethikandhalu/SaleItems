/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * USMoney tester class
 */

package kandhalu.assign1.q1;

import kandhalu.assign1.money.*;

public class USMoneyTester {
	public static void tester() {		
		System.out.println("USMONEY TESTER");
		
		//Object with default constructor
		USMoney amt1 = new USMoney();
		System.out.println(amt1);						//$0.00
		
		//Test setCents and addTo methods with invalid inputs
		amt1.setCents(-1);
		System.out.println(amt1);						//$0.00
		
		amt1.setDollars(-12);
		System.out.println(amt1);						//$0.00
		
		amt1.addTo(-182, -10);
		System.out.println(amt1);						//$0.00

		amt1.addTo(12, -140);
		System.out.println(amt1);						//$0.00
		
		amt1.addTo(-312, -10);
		System.out.println(amt1);						//$0.00
		
		//Test all methods with valid inputs
		amt1.addTo(0, 1106);
		System.out.println(amt1);						//$11.06
		
		amt1.addTo(0, 4);
		System.out.println(amt1);						//$11.10		
		
		amt1.setCents(250);
		System.out.println(amt1);						//$2.50
		System.out.println(amt1.getCents());			//50
		System.out.println(amt1.getDollars());			//2
		
		amt1.setDollars(10);
		System.out.println(amt1);						//$10.50
		System.out.println(amt1.getCents());			//50
		System.out.println(amt1.getDollars());			//10
			
		//Object with constructor that takes parameters
		USMoney b = new USMoney(2,-10);
		System.out.println(b);							//$2.00
		
		USMoney c = new USMoney(-20,90);
		System.out.println(c);							//$0.90
			
		b.add(c);
		System.out.println(c);							//$2.90
		System.out.println(b);							//$2.00
		
		USMoney amt2 = amt1.add(c);
		System.out.println(amt1);						//$10.50
		System.out.println(amt2);						//$13.40
		
		amt2.addTo(amt1.getDollars(), amt1.getCents());
		System.out.println(amt2);						//$23.90
		
		USMoney amt3 = new USMoney (99,120);
		amt3.addTo(99, 120);			
		System.out.println(amt3);						//$200.40
		System.out.println("");
	}
}
