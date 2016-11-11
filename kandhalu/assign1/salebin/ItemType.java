/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * Interface for ItemType
 */

package kandhalu.assign1.salebin;

import kandhalu.assign1.money.*;

public interface ItemType {
	public boolean isFragile();
	public USMoney getPrice();
	public double getWeight();
	public String getDetails();
}
