/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * SaleBin tester class
 */

package kandhalu.assign1.q2;

import kandhalu.assign1.money.*;
import kandhalu.assign1.salebin.*;

public class SaleBinTester {
	public static void tester() {
		System.out.println("SALE BIN TESTER");
		//part a
		SaleItem item1 = new SaleItem("Couch", new USMoney(200,0), 150, false);
		SaleItem item2 = new SaleItem("Glass Vase", new USMoney(15,99), -15, true);
		SaleItem item3 = new SaleItem("Couch throw", new USMoney(30,0), -10, false);
		SaleItem item4 = new SaleItem("Potatoes", new USMoney(25,49), 30, false);
		SaleItem item5 = new SaleItem("Bed mattress", new USMoney(100,0), 200, false);
		SaleItem item6 = new SaleItem("Lamp shade", new USMoney(45,50), 25, false);
		SaleItem item7 = new SaleItem("Kid-friendly LED TV 1", new USMoney(150,0), 100, false);
		SaleItem item8 = new SaleItem("Kid-friendly LED TV 2", new USMoney(120,0), 75, false);
		
		//part b
		Bin bin1 = new Bin();
				
		//part c
		bin1.addItem(item1);
		bin1.addItem(item2);
		bin1.addItem(item3);
		bin1.addItem(item4);
		bin1.addItem(item5);
		bin1.addItem(item6);
		bin1.addItem(item7);
		bin1.addItem(item8);

		//part d
		System.out.println(bin1.showDetails() + "\n");
		
		//part e
		SaleItem item9  = new SaleItem("Kid-friendly LED TV 1", new USMoney(150,0), 330, true);
		SaleItem item10 = new SaleItem("Umbrella", new USMoney(20,0), 5, false);
		SaleItem item11 = new SaleItem("Glass Vase", new USMoney(15,99), -15, true);
		SaleItem item12 = new SaleItem("Couch", new USMoney(30,0), 200, false);
		SaleItem item13 = new SaleItem("LED TV", new USMoney(100,0), 100, true);
		SaleItem item14 = new SaleItem("Kid-friendly LED TV 2", new USMoney(120,0), 150, false);
		SaleItem item15 = new SaleItem("Lamp shade", new USMoney(45,50), 25, false);
		
		
		//part f
		SmartBin bin2 = new SmartBin();
		
		//part g
		bin2.addItem(item9);
		bin2.addItem(item10);
		bin2.addItem(item11);
		bin2.addItem(item12);
		bin2.addItem(item13);
		bin2.addItem(item14);
		bin2.addItem(item15);
		
		//part h
		System.out.println(bin2.showDetails() + "\n");
		
		//part i
		SaleItem item16 = new SaleItem("LED TV", new USMoney(100,0), 100, true);
		Bin bin3= new SmartBin();
		bin3.addItem(item16);
		System.out.println(bin3.showDetails() + "\n");		//Able to add fragile SaleItems to bin3
	}
}
