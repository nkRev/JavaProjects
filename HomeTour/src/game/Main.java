package game;

import java.util.HashMap;
import java.util.Scanner;

import fixtures.Item;
import fixtures.Room;

public class Main {
	// boolean for loop
	private static boolean finished = true;
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// initialize RoomManager and create rooms
		RoomManager rm = new RoomManager();
		rm.init();

		// initialize Player
		Player p = new Player();
		p.setCurrentRoom(rm.getStartingRoom());

		// print player guide
		System.out.println(howTo());

		// initiate loop
		try {
		do {
			printRoom(p);
			String[] command = collectInput();
			parse(command, p);

		} while (!finished);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong...");
		}
		}

	private static void printRoom(Player p) {
		String room = p.getCurrentRoom().toString();
		int roomItems = p.getCurrentRoom().getItems().size();
		System.out.println(room);
		// if items are in room
		if (roomItems != 0) {
			printRoomInventory(p);
		}
		printExits(p);

	}

	// prints exits + descriptions
	private static void printExits(Player p) {
		System.out.println("Room Exits: ");
		// entrySet allows you to create a "toString()"(set) out of the same elements in
		// the HashMap and returns the set
		for (HashMap.Entry<String, Room> e : p.getCurrentRoom().getExits().entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue().getName());
		}
	}

	// prints room inventory
	private static void printRoomInventory(Player p) {
		System.out.println("Room Items: ");
		int size = p.getCurrentRoom().getItems().size();
		for (int i = 0; i < size; i++) {
			Item item = p.getCurrentRoom().getItems().get(i);
			System.out.println(item.getShortDescription());
		}
	}

	// guide on how to play
	private static String howTo() {
		return String.format("Player's Guide\n" 
						+ "go (direction): move around the house based on the direction given.\n"
						+ "\t For instance moving to the next room is go north.\n"
						+ "take (item name): pick up an item and add to inventory.\n"
						+ "inspect (item name): interact with items in the room.\n"
						+ "help: if you forgotten how to play, type \"help\".\n" + "quit: type quit to quit.\n");
	}

	/**
	 * takes user input and splits the input into a String array
	 * 
	 * @return splitLine: String array that the user entered.
	 */
	private static String[] collectInput() {
		System.out.print(">>");
		String input = in.nextLine();
		String[] splitLine = input.split(" ");
		return splitLine;
	}

	// reprompt
	private static void reprompt(Player p) {
		// if room has items in it print items
		if (p.getCurrentRoom().getItems().size() > 0) {
			printRoomInventory(p);
		}
		printExits(p);
		String[] command = collectInput();
		parse(command, p);
	}

	// make commands happen
	private static void parse(String[] command, Player p) {
		// if command is valid for , take, interact, items or quit is true
		if (cIsValid(command)) {
			// then have player do it
			switch (command[0]) {
			case "go":
				changeRoom(command, p);
				break;
			case "take":
				steal(p, p.getCurrentRoom().getItems().get(0));
				reprompt(p);
				break;
			case "inspect":
				interaction(p);
				reprompt(p);
				break;
			case "items":
				displayInventory(p);
				reprompt(p);
				break;
			case "help":
				System.out.println(howTo());
				reprompt(p);
			case "quit":
				System.out.println("Thanks for visiting.");
				finished = true;
				break;
			}
		}
	}

	// player interaction
	private static void interaction(Player p) {
		// the idea behind this is to get the current room player is in, get items in
		// inventory, then access toString from fixture
		System.out.println(p.getCurrentRoom().getItems().toString());
	}

	// display inventory from ArrayList
	private static void displayInventory(Player p) {
		for (int i = 0; i < p.getInventory().size(); i++) {
			System.out.println(p.getInventory().get(i).getName());
		}
	}

	// checks if command is valid.
	private static boolean cIsValid(String[] command) {

		switch (command[0]) {
		case "go":
			return true;
		case "take":
			return true;
		case "inspect":
			return true;
		case "items":
			return true;
		case "help":
			return true;
		case "quit":
			return true;
		}
		return false;
	}

	private static void changeRoom(String[] command, Player p) {
		p.setCurrentRoom(p.getCurrentRoom().getExit(command[1]));
	}

	// player removes item from current room and adds to inventory
	private static void steal(Player p, Item item) {
		p.addToInventory(item);
		p.getCurrentRoom().rmItem(item);
	}
}
