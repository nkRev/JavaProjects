package game;

import fixtures.Item;
import fixtures.Room;

public class RoomManager {
	private Room startingRoom;

	public void init() {
		/************************************************
		 * Room creation
		 */
		Room foyer = new Room("The Foyer", "a small foyer",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
						+ "\n" + "The hardwood floor leads west to a kitchen" + "\n"
						+ "To the north is a small room, where you can see a bookcase.");

		Room diningRoom = new Room("The dining room", "A medium sized room where meals are eaten. ",
				"The dining room holds a table with porcelain plates and silverwear for six people.\nA candelabra sits in the middle of the table with the candles lit. "
						+ "There is a painting of on the wall.\n");

		Room study = new Room("The study", "A small room with bookshelves and a desk to do work.",
				"In the study is where I do most of my work and studying.\n"
						+ "The bookshelves are filled with a variety of books of various genres.\n"
						+ "My desk is a mess, but my it is where I research and implement projects, and play video games.\n");

		Room kitchen = new Room("The kitchen", "A large kitchen with a floating island in the center",
				"The large kitchen has a refrigerator to the left, a pantry to the right, \nand in the center sits a large island that has a six burner stove in the center with a ventilation hood above.\n"
						+ "There are also two ovens on the opposite end of the stove");

		/******************************************************************
		 * item creation
		 * 
		 */
		Item painting = new Item("Nimphee Painting", "This painting was drawn by Claude Monet in 1926.",
				"The Nimphee was regarded as one of the greatest paintings of all time. It displays Monet's two greatest achievements: his garden and the paintings they inspired."
						+ "The Nimphee displays an arching bridge going over a river with lily pads, the background is covered by green shrubs and trees.");
		
		Item silverware = new Item("Silverware", "Vintage Grand Baroque silverware",
				"To the left of the porcelain plate lies a dinner fork and salad fork."
						+ " To the right sits a soup spoon and a tablespoon. Lastly above the porcelain plate sits a butter knife and dessert spoon.");
		
		Item refrigerator = new Item("Refigerator", "A large refrigerator",
				"The refrigerator holds all of the food in the house that needs to be at 40\u00B0F any higher the food would be prone to spoiling. "
						+ "As we peer inside of the refrigerator we see eggs, milk, carrots, lettuice, cheese, and a leftover slice of pizza.");
		
		Item pizza = new Item("A slice of leftover pizza", "A slice of extra cheese pizza from Domino's",
				"It looks like someone ordered Domino's Pizza the other night and almost finished a whole large box of pizza with extra cheese on it.\n"
						+ "Although it is cold, the cheese still has its slight char to it.");
		
		Item book = new Item("A book", "Big Java Late Objects.",
				"A textbok on Java programming concepts by Cay Horstman. The book appears to only be used a few times. \nIt's possible that this person prefers online resources as opposed to textbooks");
		

		/*************************************************************************
		 * Building home layout
		 * 
		 * each room has (an) exit(s) and each certain rooms will have items added
		 */
		foyer.setExits("north", study);
		foyer.setExits("south", diningRoom);
		foyer.setExits("west", kitchen);

		kitchen.setExits("east", foyer);
		kitchen.setExits("south", diningRoom);
		kitchen.setExits("north", study);
		kitchen.addItem(refrigerator);
		kitchen.addItem(pizza);

		diningRoom.setExits("west", kitchen);
		diningRoom.setExits("north", foyer);
		diningRoom.addItem(painting);
		diningRoom.addItem(silverware);

		study.setExits("south", foyer);
		study.setExits("west", kitchen);
		study.addItem(book);

		// Player starts here.
		setStartingRoom(foyer);
	}

	private void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}

	public Room getStartingRoom() {
		return startingRoom;
	}
}
