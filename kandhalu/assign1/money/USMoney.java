/**
 * @author Preethi Kandhalu (W1192362)
 * COEN 275: Object-Oriented Analysis, Design and Programming
 * Fall 2016
 * Assignment 1 
 * USMoney class
 */

package kandhalu.assign1.money;

public class USMoney {
	//Data members
	private int dollars;
	private int cents;
	
	//Constructors
	//Default constructor initializes both dollar and cents to 0
	public USMoney(){
		this.dollars=0;
		this.cents=0;
	}
	
	public USMoney(int dollars, int cents){
		//To set dollars
		if (dollars<0){
			System.out.println("Invalid dollar value! Dollar value has been set to default value of 0");
			this.setDollars(0);
		}
		else{
			this.setDollars(dollars);
		}
		
		//To set cents
		if (cents<0){
			System.out.println("Invalid cents value! Cents value has been set to default value of 0");
			this.setCents(0);
		}
		else{
			if (cents>=0 && cents<=99){
				this.setCents(cents);
			}
			else{
				int[] converted = convertToDollarAndCents(cents);
				this.setCents(converted[1]);
				this.setDollars(this.getDollars()+converted[0]);
			}
		}
	}
	
	//Getter and Setter methods
	public void setDollars(int dollars){
		if (dollars<0){
			System.out.println("Please enter valid values!");
		}
		else{
			this.dollars=dollars;
		}
	}
	
	public void setCents(int cents){
		if (cents<0){
			System.out.println("Please enter valid values!");
		}
		else{
			if (cents>=0 && cents<=99){
				this.cents=cents;
			}
			else{
				int[] converted = convertToDollarAndCents(cents);
				this.cents=converted[1];
				this.dollars=converted[0];
			}
		}
	}
	
	public int getDollars(){
		return this.dollars;
	}
	
	public int getCents(){
		return this.cents;
	}

	//Class-related methods
	public void addTo(int dollars, int cents){
		if (dollars<0 || cents<0){
			System.out.println("Please enter valid values!");
		}
		else{
			//Get and format money in account
			double currMoney;
			if (this.getCents()<10){
				currMoney = Double.parseDouble(Integer.toString(this.getDollars()) +".0"+ Integer.toString(this.getCents()));
			}
			else{
				currMoney = Double.parseDouble(Integer.toString(this.getDollars()) +"."+ Integer.toString(this.getCents()));
			}
			
			//Get and format money to be added
			if (cents>99){
				int[] converted = convertToDollarAndCents(cents);
				dollars = dollars + converted[0];
				cents = converted[1];
			}
			double inputMoney;
			if (cents<10){
				inputMoney = Double.parseDouble(Integer.toString(dollars) +".0"+ Integer.toString(cents));
			}
			else{
				inputMoney = Double.parseDouble(Integer.toString(dollars) +"."+ Integer.toString(cents));
			}
			
			//Compute total
			Double total= currMoney + inputMoney;
			String total2 = String.format("%.2f", total);
			
			//Set data members
			int length=total2.length();
			this.setDollars(Integer.parseInt(total2.substring(0, length-3)));
			this.setCents(Integer.parseInt(total2.substring(length-2)));
		}
	}

	public USMoney add(USMoney money){
		money.addTo(this.getDollars(), this.getCents());
		return money;
	}
	
	//@override
	public String toString(){
		if (this.cents<10){
			return "$" + Integer.toString(this.getDollars()) + ".0" + Integer.toString(this.getCents());
		}
		return "$" + Integer.toString(this.getDollars()) + "." + Integer.toString(this.getCents());

	}
	
	//Helper method(s)
	private int[] convertToDollarAndCents(int cents){
		int[] converted= new int[2];
		int tempCents=cents%100;
		int tempDollars=(cents-tempCents)/100;
		converted[0]=tempDollars;
		converted[1]=tempCents;
		return converted;
	}
}
