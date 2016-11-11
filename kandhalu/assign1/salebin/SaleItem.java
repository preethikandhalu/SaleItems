/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * SaleItem class
 */

package kandhalu.assign1.salebin;

import kandhalu.assign1.money.*;

public class SaleItem implements ItemType {
	private String itemName;
	private USMoney price;
	private double weight;
	private boolean fragile;
	
	//Constructor
	public SaleItem(){
		this.itemName="";
		this.price= new USMoney();
		this.weight =0;
		this.fragile=false;
	}
	
	public SaleItem(String itemName, USMoney price, double weight, boolean fragile){
		this.itemName=itemName;
		this.price=price;
		if (weight<0){
			this.weight=20;
		}
		else{
			this.weight=weight;
		}
		this.fragile=fragile;
	}
	
	//Getter and Setter Methods	
	public void setFragile(boolean fragile){
		this.fragile=fragile;
	}
	
	public void setPrice(int dollars, int cents){
		this.price=new USMoney(dollars, cents);
	}
	
	public void setWeight(double weight){
		if (weight<0){
			System.out.println("Please enter a positive value");
		}
		else{
			this.weight=weight;	
		}
	}
	
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	
	public boolean isFragile(){
		return this.fragile;
	}
	
	public USMoney getPrice(){
		return this.price;
	}
	
	public double getWeight(){
		return this.weight;
	}
	
	public String getItemName(){
		return this.itemName;
	}
	
	//Class-related methods
	public String getDetails(){
		String details = "Item name: " + this.itemName + "\nPrice: " + this.price.toString();
		return details;
	}
}
