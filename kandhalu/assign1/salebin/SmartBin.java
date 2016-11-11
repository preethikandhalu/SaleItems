/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * SmartBin class
 */

package kandhalu.assign1.salebin;

import kandhalu.assign1.money.*;

public class SmartBin extends Bin{
	private String label;
	
	//Constructors
	public SmartBin(){
		super("SM");
		this.label="Nothing fragile in this bin";
	}
	
	//Getter and setter methods
	public void setLabel(String label){
		this.label=label;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	//Class related methods
	public void addItem(ItemType item){
		double potentialWeight = item.getWeight() + this.getWeight();
		if (potentialWeight<=MAX_WEIGHT){
			if (this.itemCounter>=20){
				//Bin full; item can't be added to bin though it meets qualifications
				System.out.println("Bin is full; can't add more items!");
			}
			else{
				this.items[this.itemCounter]=item;
				this.itemCounter++;
				if (item.isFragile()) this.setLabel("Fragile - Handle with Care");
			}
		}
	}
	
	//@override
	public USMoney calculatePrice(){
		USMoney totalPrice = new USMoney();
		int i =0;
		while (i<20 && this.items[i]!=null){
			totalPrice.addTo(this.items[i].getPrice().getDollars(), this.items[i].getPrice().getCents());
			if (this.items[i].isFragile()){
				totalPrice.addTo(10, 0);
			}
			i++;
		}
		totalPrice.addTo(100, 0);
		return totalPrice;
	}
	
	//@override
	public String showDetails(){
		String binNumber = this.getBinNumber();
		String label = this.label;
		String currWeight = Double.toString(this.getWeight());
		String totalCost = this.calculatePrice().toString();
		return "Bin Number\t: " + binNumber +
				"\nLabel\t\t: " + label +
				"\nCurrent Weight\t: " + currWeight +
				"\nTotal Cost\t: " + totalCost;
	}
}
