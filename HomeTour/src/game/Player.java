package game;

import java.util.ArrayList;
import java.util.List;

import fixtures.Item;
import fixtures.Room;

public class Player {
	private Room currentRoom;
	// initialize inventory
	private List<Item> inventory = new ArrayList<>();

	/**
	 * Getter for current room
	 * 
	 * @return current room
	 */
	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	/**
	 * Setter for current room
	 * 
	 * @param currentRoom current room player is in
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * Adds item to inventory
	 * 
	 * @param item
	 */
	public void addToInventory(Item item) {
		inventory.add(item);
	}

	/**
	 * getter for List<Item> inventory
	 * 
	 * @return your inventory
	 */
	public List<Item> getInventory() {
		return inventory;
	}

	/**
	 * removes item from the List<Item> inventory
	 * 
	 * @param item to be removed from inventory
	 */
	public void removeItem(Item item) {
		inventory.remove(item);
	}

}
