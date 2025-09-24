package steele;
/**
 * SalesItem represents an item in a sales slip with a name, price, and quantity.
 */
public class SalesItem {
	private String name; // Name of the item
	private String price; // Price of the item as a formatted string
	private int quantity; // Quantity of the item
	
	/**
	 * Constructs a SalesItem with the specified name, price, and quantity.
	 * 
	 * @param name     the name of the item
	 * @param price    the price of the item
	 * @param quantity the quantity of the item
	 */
	public SalesItem(String name, double price, int quantity) {
		this.name = name;
		this.price = String.format("%.2f", price);
		this.quantity = quantity;
	}
	
	/** Getter methods for the SalesItem properties 
	 * @return name, price, quantity, total
	 * */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the price of the item as a formatted string.
	 * @return the price of the item
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * Gets the quantity of the item.
	 * @return the quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Calculates and returns the total price for the item based on its price and quantity.
	 * @return the total price for the item
	 */
		public double getTotal() {
		double total = Double.parseDouble(price) * quantity;
		return total;
	}

	/**
	 * Returns a string representation of the SalesItem.
	 * @return a string representation of the SalesItem
	 */
		public String toString() {
		return name + " $" + price + " " + quantity;
	}
	
	
}
