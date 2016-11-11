/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * Interface for BinType
 */

package kandhalu.assign1.salebin;

import kandhalu.assign1.money.*;

public interface BinType {
	public void addItem (ItemType item);
	public USMoney calculatePrice();
	public double getWeight();
	public int getNoOfItems();
	public String showDetails();
}
