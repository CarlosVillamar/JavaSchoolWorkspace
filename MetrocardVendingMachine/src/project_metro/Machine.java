package project_metro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Machine {

	/**
	 * This class is meant to act as a Mertocard vending machine and will focus
	 * on 3 user purchase work flows
	 *1-purchasing a new card
	 *2-Refilling a card
	 *3-Checking a card's status 
	 *
	 *This class will use a series of switches , hopefully making it much easier to read
	 **/
	
	public static void main(String[] args) {
		//we begin by creating a new instance of a card and a Map Collection to store our cards in 
		//ideally in the future I would like to update this project to use a proper interface and database to properly create, read and update our card objects 
		
		Metrocard card = new Metrocard();
		Map<UUID, Metrocard> cardStash = new HashMap<UUID, Metrocard>();

		Scanner scanner = new Scanner(System.in);
		
		//we welcome our user to the service and ask them what kind of transaction they would like to make
		System.out.println("Welcome!!! what which metrocard would you like to purchase?");
		System.out.println("Enter the option you would like to choose " + "\n1-Purchase a new card"
				+ "\n2-Add value or time to your card " + "\n3-check your card's status");

		int option = scanner.nextInt();
		switch (option) {
		//This switch serves to navigate the users transaction selection
		case 1:
			//This case triggers if the use selects to purchase a new card
			System.out.println("1-Single ride\n" + "2-Regular Cards\n" + "3-Unlimited Rides\n");

			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
				System.out.println("Triggered");
				switch (option) {
				case 1:
					//this case is for the single ride selection 
					option = 5;
					valueOperations(card, cardStash, option);
					break;

				case 2:
					//this case is if the user wants to purchase a new pre-paid card or set the card value
					System.out.println(" Would you like a preset value or set the value");
					System.out.println("1-$5.50\n" + "2-$11.00\n" + "3-$27.50\n" + "4-55.00\n" + "9-Set card value");
					option = scanner.nextInt();
					valueOperations(card, cardStash, option);
					break;

				case 3:
					//This case triggers if the user wants to purchase a new unlimited card
					System.out.println("Which unlimited card would you like?\n" + "1-Single Day\n"
							+ "2-Monthly Unlimited\n" + "3-Weekly Unlimited\n" + "4-Express Bus Weekly Pass");
					option = scanner.nextInt();
					unlimitedOperations(card, cardStash, option);
					break;

				}
			}
			break;

		case 2:
			//This case triggers if the user wants to refill their card
			System.out.println("You have selected to add on to your card\n");
			System.out.println("Would you like to add value or time?\n" + "1-add value\n" + "2-add time");
		
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
				switch (option) {
				case 1:
					//this case triggers if the user wants to add value to thier card
					System.out.println(" Would you like a preset value or set the value\n");
					System.out.println("1-$5.50\n" + "2-$11.00\n" + "3-$16.50\n" + "4-$27.50\n" + "5-55.00\n"
							+ "6-Set card value\n");
					option = scanner.nextInt();
					valueOperations(card, cardStash, option);
					break;
				case 2:
					//this case triggers if the user wants to add time to their card
					System.out.println("Which unlimited card would you like?\n" + "1-Single Day\n"
							+ "2-Monthly Unlimited\n" + "3-Weekly Unlimited\n" + "4-Express Bus Weekly Pass");
					option = scanner.nextInt();
					unlimitedOperations(card, cardStash, option);
					break;
				}
			}
			break;

		case 3:
			//This case triggers if the user wants to check their card status
			System.out.println("Enter card ID");
			String ID = scanner.nextLine();
			if (ID != null && scanner.hasNextLine()) {
				System.out.println(ID);
				// card = cardStash.get(ID);
				// card.getCardInfromation();
				System.out.println("Feature coming soon");
			}
			break;
		}
		scanner.close();
		System.out.println("Thank you for riding the MTA");
		System.exit(0);

	}

//The methods below handle the operations required for transactions adding time to a card 
	public static void unlimitedOperations(Metrocard card, Map<UUID, Metrocard> cardStash, int opt) {
		// TODO Auto-generated method stub
		//in the future this method will need to be updated to check if the card is active or expired to add to an exisiting card
		card = new Metrocard("Unlimited", opt);
		cardStash.put(card.getID(), card);
		System.out.println(card.getID());
		System.out.println(cardStash);
		System.out
				.println("you now have a " + card.getCardType() + " unlimited Metrocard, Thank you for riding the MTA");
	}
	//The methods below handle the operations required for transactions adding valueto a card 
	public static void valueOperations(Metrocard card, Map<UUID, Metrocard> cardStash, int opt) {
		// TODO Auto-generated method stub
		//in the future this method will need to be updated to check if the card is active or expired to add to an exisiting card
		if (opt == 9) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("How much would you like to place on your card");
			double s = scanner.nextDouble();
			card = new Metrocard("Regular", s);
			cardStash.put(card.getID(), card);
			System.out.println("You now have a card with" + card.getValue() + "Thank for riding the MTA");
			scanner.close();
		} else if (opt == 5) {
			card = new Metrocard("pre-paid", 5);
			cardStash.put(card.getID(), card);

			System.out.println("you now have a single ride, Thank you for riding the MTA");
		} else {
			card = new Metrocard("pre-paid", opt);
			cardStash.put(card.getID(), card);
			System.out.println("you now have a " + card.getCardType() + " card, Thank you for riding the MTA");
		}

	}

	public static void getCardInfo(Metrocard card, Map<UUID, Metrocard> cardStash, UUID id) {
		card = cardStash.get(id);

		if (card.getExpiredStatus()) {
			System.out.println("Your card is expired and no longer available for use");
		} else if (card.getActiveStatus() && card.getCardType() != "Unlimited") {

			System.out.println("Your card value is" + card.getValue() + "\nCard Expiration Date: "
					+ card.getExpirationDate() + "\nDate Purchased " + card.getActiveDate());
		} else if (card.getActiveStatus() && card.getCardType() == "Unlimited") {

			System.out.println("You have an " + card.getCardType() + "unlimited" + "\nGood until"
					+ card.getUnlimitedEndDate() + "\nCard Expiration Date: " + card.getExpirationDate()
					+ "\nDate Purchased " + card.getActiveDate());
		} else {
			System.out.println("This card is not active or has no current value\n" + "This card will expire on: "
					+ card.getExpirationDate());
		}

	}

}
