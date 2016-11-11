/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * Bin class
 */

package kandhalu.assign1.salebin;

import kandhalu.assign1.money.USMoney;

public class Bin implements BinType {
	protected String binNumber;
	protected ItemType[] items;
	protected static final double MAX_WEIGHT=500.0;
	protected static int binCounter=0;
	protected int itemCounter;
	
	//Constructors
	public Bin() {
		this.binNumber = "A" + Integer.toString(generateBinNumber());
		this.items= new ItemType[20];
		this.itemCounter=0;
	}
	
	public Bin(String prefix){
		this.binNumber = prefix + Integer.toString(generateBinNumber());
		this.items= new ItemType[20];
		this.itemCounter=0;
	}
	
	//Getter and setter methods
	public String getBinNumber(){
		return this.binNumber;
	}
	
	public double getMaxWeight(){
		return MAX_WEIGHT;
	}
	
	//Class related methods
	public static int generateBinNumber(){
		binCounter++;
		return binCounter;
	}
	
	public void addItem(ItemType item){
		double potentialWeight = this.getWeight() + item.getWeight();
		if (item.isFragile()==false && potentialWeight<=MAX_WEIGHT){
			if (this.itemCounter>=20){
				//Bin full; item can't be added to bin though it meets qualifications
				System.out.println("Bin is full; can't add more items!");
			}
			else{
				this.items[this.itemCounter]=item;
				this.itemCounter++;
			}
		}
	}
	
	public USMoney calculatePrice(){
		USMoney totalPrice = new USMoney();
		int i=0;
		while (i<20 && this.items[i]!=null){
			totalPrice.addTo(this.items[i].getPrice().getDollars(), this.items[i].getPrice().getCents());
			i++;
		}
		totalPrice.addTo(100,0);
		return totalPrice;
	}
	
	public double getWeight(){
		double totalWeight=0;
		int i=0;
		while (i<20 && items[i]!=null){
			totalWeight+=items[i].getWeight();
			i++;
		}
		return totalWeight;
	}
	
	public int getNoOfItems(){
		int itemCounter=0;
		int i=0;
		while (i<20 && this.items[i]!=null){
			itemCounter++;
			i++;
		}
		return itemCounter;
	}
	
	public String showDetails(){
		String binNumber = this.getBinNumber();
		String currWeight = Double.toString(this.getWeight());
		String totalCost = this.calculatePrice().toString();
		return "Bin Number\t: " + binNumber +
				"\nCurrent Weight\t: " + currWeight + 
				"\nTotal Cost\t: " + totalCost;
	}
}
