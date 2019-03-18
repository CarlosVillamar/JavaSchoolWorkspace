package project_metro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Machine {

	public static void main(String[] args) {
		Metrocard card = new Metrocard();
		Map<UUID, Metrocard> cardStash = new HashMap<UUID, Metrocard>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome!!! what which metrocard would you like to purchase?");
		System.out.println("Enter the option you would like to choose " + "\n1-Purchase a new card"
				+ "\n2-Add value or time to your card " + "\n3-check your card's status");

		int option = scanner.nextInt();
		// if (option == 1) {
		switch (option) {
		case 1:
			System.out.println("1-Single ride\n" + "2-Regular Cards\n" + "3-Unlimited Rides\n");
			// if (option == 1&& scanner.hasNextInt()) {
			// valueOperations(card, cardStash, option);
			// }
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
				System.out.println("Triggered");
				switch (option) {
				case 1:

					option = 5;
					valueOperations(card, cardStash, option);
					break;

				case 2:
					System.out.println(" Would you like a preset value or set the value");
					System.out.println("1-$5.50\n" + "2-$11.00\n" + "3-$27.50\n" + "4-55.00\n" + "9-Set card value");
					option = scanner.nextInt();
					valueOperations(card, cardStash, option);
					break;

				case 3:
					System.out.println("Which unlimited card would you like?\n" + "1-Single Day\n"
							+ "2-Monthly Unlimited\n" + "3-Weekly Unlimited\n" + "4-Express Bus Weekly Pass");
					option = scanner.nextInt();
					unlimitedOperations(card, cardStash, option);
					break;

				}
			}
			break;
		// } else if (option == 2) {// adding value to your card
		case 2:
			System.out.println("You have selected to add on to your card\n");
			System.out.println("Would you like to add value or time?\n" + "1-add value\n" + "2-add time");
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
				switch (option) {
				case 1:
					System.out.println(" Would you like a preset value or set the value\n");
					System.out.println("1-$5.50\n" + "2-$11.00\n" + "3-$16.50\n" + "4-$27.50\n" + "5-55.00\n"
							+ "6-Set card value\n");
					option = scanner.nextInt();
					valueOperations(card, cardStash, option);
					break;
				case 2:
					System.out.println("Which unlimited card would you like?\n" + "1-Single Day\n"
							+ "2-Monthly Unlimited\n" + "3-Weekly Unlimited\n" + "4-Express Bus Weekly Pass");
					option = scanner.nextInt();
					unlimitedOperations(card, cardStash, option);
					break;
				}
			}
			break;
		// } else if (option == 3) {
		case 3:
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
		System.out.println("Thank you come again!");
		System.exit(0);

	}

	public static void unlimitedOperations(Metrocard card, Map<UUID, Metrocard> cardStash, int opt) {
		// TODO Auto-generated method stub

		card = new Metrocard("Unlimited", opt);
		cardStash.put(card.getID(), card);
		System.out.println("you now have a " + card.getCardType() + " card, Thank you for riding the MTA");
	}

	public static void valueOperations(Metrocard card, Map<UUID, Metrocard> cardStash, int opt) {
		// TODO Auto-generated method stub

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

}
