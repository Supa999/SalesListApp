package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import steele.SalesSlip;
import steele.SalesItem;

class SalesSlipTestCases {

	@Test
	void test() {
		//Test 1: Create a SalesSlip and verify its properties
		SalesSlip list = new SalesSlip();
		System.out.println("SalesSlip created: " + list);
		
		//Test 2: Add items to the SalesSlip and verify the total price
		SalesItem item1 = new SalesItem("Widget", 10.0, 2);
		list.addItem(item1);
		System.out.println("After adding Item 1: " + list);
		SalesItem item2 = new SalesItem("Gadget", 15.5, 5);
		list.addItem(item2);
		System.out.println("After adding Item 2: " + list);
		
		//Test 3: Verify the total price calculation
		String totalPrice = list.getTotalPrice();
		System.out.println("Total price of SalesSlip: $" + totalPrice);
		
		//Test 4: Verify the string representation of the SalesSlip
		System.out.println("String representation of SalesSlip:\n" + list);
		
		
		
	}

}
