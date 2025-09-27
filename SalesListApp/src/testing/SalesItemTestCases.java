package testing;



import org.junit.jupiter.api.Test;
import steele.SalesItem;

class SalesItemTestCases {

	@Test
	void test() {
		//Test 1: Create a SalesItem and verify its properties
		SalesItem item1 = new SalesItem("Widget", 10.0, 2);
		System.out.println("Item 1: " + item1);
		
		//Test 2: Create another SalesItem and verify its properties
		SalesItem item2 = new SalesItem("Gadget", 15.5, 5);
		System.out.println("Item 2: " + item2);
		
		//Test 3: Calculate and verify the total price of item2
		double total2 = item2.getTotal();
		System.out.println("Total price of Item 2: $" + total2);
		
	}

}
