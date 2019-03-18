/**
 * 
 */
package project_metro;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Carlos Villamar http:github.com/carlosvillamar
 *
 */
public class Metrocard {

	private boolean expired, unlimited = false; 

	public boolean activeStatus = false;
	
	private double currentValue = 0.0;
	
	private String cardType = "regular";
	
	private UUID cardID; //consider changes
	
	private Date expirationDate, activeDate, unlimitedEndDate;
	
//	private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	
	
	public Metrocard() {
		// TODO Auto-generated constructor stub
	}
	
	public Metrocard(String cardType, int s) {
		//This is a constructor to purchase a new card or add a pre-paid value to their card
		this.cardType = cardType;
		cardID = UUID .randomUUID();
		this.activeStatus = true;
		this.activeDate = new Date(1);
		setExpirationDate();
		if(cardType == "pre-paid") {
			prePaidValues(s);
		}else if( cardType == "Unlimited") {
			unlimitedValues(s);
			unlimited = true;
			getID();
		}else if(cardType == "Single Ride") {
			prePaidValues(5);
		}
	}
	
	public Metrocard(String cardType, double s) {
		//Constructor for our user to assign their own value regardless if it is a new card or a pre-owned card
		this.cardType = cardType;
		this.cardID =  new UUID(10,2);
		this.activeStatus = true;
		this.activeDate = new Date(1);
		setExpirationDate();
		addValue(s);
		
	}
	
	//Below are methods to retrieve various statuses
	public boolean getActiveStatus() {
		return activeStatus;
	}
	public boolean getExpiredStatus() {
		return expired;
	}
	
	//Method to retrieve  cardType
	public String  getCardType() {
		return cardType;
	}
	
	//Method to retrieve ID
	public  UUID getID() {
		return cardID;
	}
	
	/**
	 * Below are methods centered around the object's values
	 * 
	 */
	
	public double  addValue (double value) {
		currentValue = value + currentValue;
		return currentValue;
	}
	
	public double removeValue(double value) {
		currentValue = currentValue - value;
		return currentValue;
	}
	
	public double getValue() {
		// TODO Auto-generated method stub
		return currentValue;
	} 
	
	public double prePaidValues(int opt) {
		switch(opt){
		case 1: //$5:50
			currentValue  = addValue(5.50);
			return currentValue;
		case 2:	//11:00
			currentValue  = addValue(11.00);
			return currentValue;
		case 3://27.50
			currentValue  = addValue(27.50);
			return currentValue;
		case	4://$55
			currentValue  = addValue(55.00);
			return currentValue;
		case 5: //2.75
			currentValue = addValue(2.75);
			return currentValue;
		}
		return  currentValue;
		
	}

	public void unlimitedValues(int opt) {
		switch(opt) {
		case 1: //single day
			cardType = "Single day";
			unlimited = true;
			activeDate = new Date(1);
			long tomorrow = TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
			setUnlimitedEndDate(tomorrow);
			break;
		case 2://monthly
			cardType = "Monthly unlimited";
			unlimited = true;
			activeDate = new Date(1);
			long endOfTheMonth = TimeUnit.MILLISECONDS.convert(30, TimeUnit.DAYS);
			setUnlimitedEndDate(endOfTheMonth);
			break;
		case 3://weekly
			cardType = " Weekly unlimited";
			unlimited = true;
			activeDate = new Date(1);
			long endOfTheWeek= TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS);
			setUnlimitedEndDate(endOfTheWeek);
			break;
		case 4://xbus pass	
			cardType = " Express bus weekly pass";
			unlimited = true;
			activeDate = new Date(1);
			long endOfTheWeek2= TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS);
			setUnlimitedEndDate(endOfTheWeek2);
			break;
		}
	}
	
	
	//Below are methods created to handle date operations
	public Date getActiveDate() {
		return activeDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public Date setExpirationDate() {
		long twoYearsFromToday = TimeUnit.MILLISECONDS.convert(730, TimeUnit.DAYS);
		expirationDate = new Date(System.currentTimeMillis() + twoYearsFromToday);
		return expirationDate;
	}
	
	public Date setUnlimitedEndDate(long date) {
		unlimitedEndDate = new Date(System.currentTimeMillis() + date);
		return unlimitedEndDate;
	}
	 public Date getUnlimitedEndDate() {
		 return unlimitedEndDate;
	 }

//unused methods below	 
	
//	public String  setCardType(String s) {
//			cardType = s;
//			return cardType;
//		}
	//	
//		public  void setID() {
//			cardID =  new UUID(10,2);
//			activeStatus = true;
//			activeDate = new Date(1);
//			setExpirationDate();
//		}
		

	
}
