package steele;

import java.util.ArrayList;

/**
 * SalesSlip represents a sales slip containing multiple sales items and calculates the total price.
 */
public class SalesSlip {
	private ArrayList<SalesItem> items; // List of sales items
	private double totalPrice; // Total price of all items
	
	/**
	 * Constructs an empty SalesSlip.
	 */
	public SalesSlip() {
		items = new ArrayList<SalesItem>();
		this.totalPrice = 0;
	}
	
	/**
	 * Adds a SalesItem to the sales slip and updates the total price.
	 * 
	 * @param item the SalesItem to be added
	 */
	public void addItem(SalesItem item) {
		items.add(item);
		totalPrice += item.getTotal();
	}
	
	/**
	 * Gets the total price of all items in the sales slip as a formatted string.
	 * 
	 * @return the total price of all items
	 */
	public String getTotalPrice() {
		return String.format("%.2f", totalPrice);
	}
	
	/**
	 * Returns a string representation of the SalesSlip, listing all items.
	 * @return a string representation of the SalesSlip
	 */
	@Override
	public String toString() {
		if(items.isEmpty()) {
			return "No items in the sales slip.";
		}		
		StringBuilder sb = new StringBuilder();
		for (SalesItem item : items) {
			sb.append(item.toString()).append("\n");
		}
		return sb.toString();
	}
}
