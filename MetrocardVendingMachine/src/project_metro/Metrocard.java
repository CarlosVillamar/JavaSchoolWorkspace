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
	public Metrocard(String cardType) {
		this.cardType = cardType;
		cardID =  new UUID(10,2);
		activeStatus = true;
		activeDate = new Date(1);
		setExpirationDate();
	}
	
	public String  setCardType(String s) {
		cardType = s;
		return cardType;
	}
	
//	public  void setID() {
//		cardID =  new UUID(10,2);
//		activeStatus = true;
//		activeDate = new Date(1);
//		setExpirationDate();
//	}
	
	public  UUID getID() {
		return cardID;
	}
	
	public double  addValue (double value) {
		currentValue = value + currentValue;
		return currentValue;
	}
	
	public double removeValue(double value) {
		currentValue = currentValue - value;
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
		case 3://16:50
			currentValue  = addValue(27.50);
			return currentValue;
		case	4://$55
			currentValue  = addValue(55.00);
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
		case 2://monthly
			cardType = "Monthly unlimited";
			unlimited = true;
			activeDate = new Date(1);
			long endOfTheMonth = TimeUnit.MILLISECONDS.convert(30, TimeUnit.DAYS);
			setUnlimitedEndDate(endOfTheMonth);
		case 3://weekly
			cardType = " Weekly unlimited";
			unlimited = true;
			activeDate = new Date(1);
			long endOfTheWeek= TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS);
			setUnlimitedEndDate(endOfTheWeek);
		case 4://xbus pass	
			cardType = " Express bus weekly pass";
			unlimited = true;
			activeDate = new Date(1);
			long endOfTheWeek2= TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS);
			setUnlimitedEndDate(endOfTheWeek2);
		}
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
	
	
	
	public void getCardInfromation() {
		//expirationDate 
		//card type
		if(!expired) {
			if(cardType != "regular") {
				//expirationDate
				//active
				//cardType
				//id
			}else {
				//expiration date
				//value
				//id
			}
		}else {
			//exipiration date
		}
		
	} 
}
