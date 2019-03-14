/**
 * 
 */
package project_metro;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author user
 *
 */
public class Metrocard {

	private boolean expired, unlimited = false; 

	public boolean activeStatus = false;
	
	private double currentValue = 0.0;
	
	private String cardType = "regular";
	
	private UUID cardID; //consider changes
	
	private Date expirationDate, activeDate, unlimitedEndDate;
	
	private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	public String  setCardType(String s) {
		cardType = s;
		return cardType;
	}
	
	public  void setID() {
//			cardID =  new UUID();
		activeStatus = true;
		activeDate = new Date();
		setExpirationDate();
	}
	
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
			activeDate = new Date();
			unlimited = true;
			//set end date of tomorrow
		case 2://monthly
			cardType = "Monthly unlimited";
			unlimited = true;
			activeDate = new Date();
			//set end date of  30 days
		case 3://weekly
			cardType = " Weekly unlimited";
			unlimited = true;
			activeDate = new Date();
			//set an end date of  date from active date
		case 4://xbus pass	
			cardType = " Express bus weekly pass";
			unlimited = true;
			activeDate = new Date();
			//set an end date of  date from active date
		}
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public Date setExpirationDate() {
		expirationDate = new Date();
		return expirationDate;
	}
	
	
	
	
	
}
