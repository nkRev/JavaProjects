package game;


import java.util.Map;
import java.util.Scanner;

import fixtures.Item;
import fixtures.Room;

public class Main {
	// boolean for loop
	private static boolean finished = true;
	public static Scanner in = new Scanner(System.in);
	private static RoomManager rm = new RoomManager();
	public static void main(String[] args) {
		// initialize RoomManager and build house w/ items
		
		rm.init();

		// initialize Player, set currentRoom by getting startingRoom
		Player p = new Player();
		p.setCurrentRoom(rm.getStartingRoom());

		// print player guide
		System.out.println(howTo());

		// initiate loop
		do {
			// handle user input exception
			try {
				printRoom(p);
				// retrieve LOWERCASE splitLine[] from collectInput
				String[] command = collectInput();
				parse(command, p);
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println("Error: your input may be wrong, please try entering your input correctly.\n"
						+ "Use Command \"help\" to pull up the Player's Guide if you forgot how to play.");

				continue;
			}
		} while (!finished);

	}

	// ******Print CURRENT room description and item names into rooms*******
	private static void printRoom(Player p) {
		// get CURRENT room description (name, short description and long description)
		String room = p.getCurrentRoom().toString();
		// get number of items in current room
		int roomItems = p.getCurrentRoom().getItems().size();
		System.out.println(room);
		// if items are in room
		if (roomItems != 0) {
			printRoomInventory(p);
		}
		printExits(p);

	}

	// ************Retrieve possible Exits and Room Name. Then Prints***************
	private static void printExits(Player p) {
		System.out.println("Room Exits: ");
		// entrySet allows you to create a "toString()"(set) out of the same elements in
		// the HashMap and returns the set
		for (Map.Entry<String, Room> e : p.getCurrentRoom().getExits().entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue().getName());
		}
	}

	// *******prints room inventory*******
	private static void printRoomInventory(Player p) {
		System.out.println("Room Items: ");
		int size = p.getCurrentRoom().getItems().size();
		for (int i = 0; i < size; i++) {
			Item item = p.getCurrentRoom().getItems().get(i);
			System.out.println(item.getName());
		}
	}

	/**********************************
	 * Player's Guide
	 */
	private static String howTo() {
		return String
				.format("Player's Guide\n" + "go (direction): move around the house based on the direction given.\n"
						+ "\t For instance moving to the next room is go north.\n"
						+ "take (item name): pick up an item and add to inventory.\n"
						+ "inspect (item name): interact with items in the room.\n" + "items: open your inventory"
						+ "help: if you forgotten how to play, type \"help\".\n" + "quit: type \"quit\" to quit.\n");
	}

	/**
	 * takes user input and splits the input into a String array
	 * 
	 * @return splitLine: String array that the user entered.
	 */
	private static String[] collectInput() {
		System.out.print(">> ");
		// to ensure all of player's input is lower case before it goes into splitLine[]
		String input = in.nextLine().toLowerCase();
		String[] splitLine = input.split(" ");
		return splitLine;
	}

	/************************************************
	 * re-prompt, re-collect, and re-parse input
	 */
	private static void reprompt(Player p) {
		// if room has items in it print items
		if (p.getCurrentRoom() != null) {
			if (p.getCurrentRoom().getItems().size() > 0) {
				printRoomInventory(p);
			}

			printExits(p);
			String[] command = collectInput();
			parse(command, p);
		}
	}

	// make commands happen
	private static void parse(String[] command, Player p) {
		// if command is valid for , take, interact, items or quit is true
		if (cIsValid(command)) {
			// then have player do it
			switch (command[0]) {
			case "go":
			case "move":
				changeRoom(command, p);
				reprompt(p);
				break;
			case "take":
				steal(p, p.getCurrentRoom().getItems().get(0));
				reprompt(p);
				break;
			case "inspect":
				inspect(p);
				reprompt(p);
				break;
			case "items":
			case "inventory":
				displayInventory(p);
				reprompt(p);
				break;
			case "help":
				System.out.println(howTo());
				reprompt(p);
			case "quit":
			case "leave":
				System.out.println("Thank you for visiting.");
				finished = true;
				break;
			default:
				System.out.println("Use Command \"help\" to pull up the Player's Guide if you forgot how to play.");
				break;
			}
		}
	}

	// player interaction
	private static void inspect(Player p) {
		// the idea behind this is to get the current room player is in, get items in
		// inventory, then access toString from fixture
		System.out.println(p.getCurrentRoom().getItems().toString());
	}

	// display inventory from ArrayList
	private static void displayInventory(Player p) {
		System.out.println("************Player's Inventory****************");
		for (int i = 0; i < p.getInventory().size(); i++) {
			System.out.println(p.getInventory().get(i).getName());
		}
		System.out.println();
	}

	// checks if command is valid.
	private static boolean cIsValid(String[] command) {

		String[] validCommands = { "go", "move", "take", "inspect", "inventory", "items", "help", "quit", "leave" };
		for (int i = 0; i < validCommands.length; i++) {
			if (validCommands[i].equalsIgnoreCase(command[0])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * to change current room, the next room's direction should be specified and
	 * retrieved, then set
	 * 
	 * @param command
	 * @param p
	 */
	private static void changeRoom(String[] command, Player p) {

		p.setCurrentRoom(p.getCurrentRoom().getExit(command[1]));
		// if the CURRENT room is not null
		if (p.getCurrentRoom() != null) {
			// print toString for getCurrentRoom
			p.getCurrentRoom().toString();
		}

	}

	// player removes item from current room and adds to inventory
	private static void steal(Player p, Item item) {
		p.addToInventory(item);
		p.getCurrentRoom().rmItem(item);
	}

}
