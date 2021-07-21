package fixtures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room extends Fixture {
	// items are held in ArrayList since number of items could be nth number
	private List<Item> items = new ArrayList<>();

	/**********************************************************************************
	 * The implementation of a HashMap is based off of the idea of each direction
	 * (key) has a room object (value).
	 * 
	 * Also for the possibility of scaling a HashMap has O(n) in the worst case
	 * scenario
	 * ********************************************************************************
	 */
	private HashMap<String, Room> exits = new HashMap<>();

	// a parameterized constructor for a room object
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}

	// adds item to current player's ArrayList
	public void addItem(Item item) {
		items.add(item);
	}

	// get items in current player's ArrayList
	public List<Item> getItems() {
		return items;
	}

	// remove items from current player's ArrayList
	public void rmItem(Item item) {
		items.remove(item);
	}

	/***********************************************************************************
	 * this is to set the exits in the room object in a HashMap '.put(key, value)'
	 * inserts exits into the room objects
	 * 
	 * @param dir  is the direction 'north', 'south', 'east', 'west'
	 * @param room objects to be created IE: foyer, kitchen, dining room, etc...
	 ************************************************************************************
	 */
	public void setExits(String dir, Room room) {
		exits.put(dir, room);
	}

	/**************************************************************************************
	 * To be able to retrieve my exits while Implementing my HashMap I have to be
	 * able to specify a String direction(key), and my value Room(object)
	 * 
	 * @return exits HashMap
	 *************************************************************************************
	 */
	public HashMap<String, Room> getExits() {
		return exits;
	}

	/***************************************************************************************
	 * While using a HashMap, the ability to return a specified exit we have to
	 * return a direction(key)
	 * 
	 * @param dir the key for the rooms in the HashMap
	 * @return get exit direction
	 *************************************************************************************
	 */
	public Room getExit(String dir) {
		return exits.get(dir);
	}
}
