import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
/**
 * 
 */
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Ravi Trivedi
 * @Student_No 105197609
 *
 */
@DisplayName("This is Store Class Tester")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestStore {
	private Store store = new Store();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Created a store variable of the type Store.");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("\nThis happened after everything\n\nNote the order and how there isn't a clear pattern here");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("\nThis happened before each test");
		if (true) {
			System.out.println("The true thing happened");
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("This happened after each test");
		store = new Store();
	}

	@Test
	@Order(1)
	void testStore() {
		System.out.println("testStore called");
		ArrayList<Item> arr = new ArrayList<Item>();
		assertEquals(arr, store.inventory);
	}

	@Test
	@Order(2)
	void testAddItem() {
		System.out.println("testAddItem called");
		assertEquals(0,store.inventory.size());
		store.addItem(new Item("Title",10.00, LocalDate.of(1999, 11, 22),100));
		assertEquals(1, store.inventory.size());
		store.addItem(null);
		assertEquals(1, store.inventory.size());
	}

	@Test
	@Order(3)
	void testMakeSale() {
		System.out.println("testMakeSale called");
		assertEquals(false, store.makeSale(0, 0, null));
		store.addItem(new Item("Title",10.00, LocalDate.of(1999, 11, 22),100));
		assertEquals(false, store.makeSale(9100, 101, LocalDate.of(2000, 11, 23)));
		store.makeSale(9100, 10, LocalDate.of(2000, 11, 22));
		assertEquals(1,store.getTotalNumberOfSales());
		assertEquals(100, store.getTotalSalesValue());
	}
}
