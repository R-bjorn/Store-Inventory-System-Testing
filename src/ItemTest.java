import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
/**
 * 
 */
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Ravi Trivedi
 * @Student_No 105197609
 *
 */
@DisplayName("This is Item Class Tester")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestItem {
	private Item item = new Item("title",10,LocalDate.of(1999, 11, 22), 1);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Created a item variable of the type Item.");
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
	}

	@Test
	@Order(2)
	void testItem() {
		System.out.println("testItem called");
		assertAll("item testing", () -> assertEquals("title",item.getTitle()),
				() -> assertEquals(10.0, item.getRegularPrice()),
				() -> assertEquals(LocalDate.of(1999, 11, 22),item.getReleaseDate()),
				() -> assertEquals(1, item.getQuantity()));
	}
	
	@Test
	void testdeepcopy() {
		System.out.println("testdeepcopyconstructor called");
		Item item2 = item.makeCopy();
		assertNotEquals(item, item2);
		assertAll("deep copy testing", () -> assertEquals(item.getTitle(), item2.getTitle()),
				() -> assertEquals(item.getRegularPrice(), item2.getRegularPrice()),
				() -> assertEquals(item.getReleaseDate(), item2.getReleaseDate()),
				() -> assertEquals(item.getQuantity(), item2.getQuantity()));
	}
	
	@Test
	@Order(3)
	void boundryTests() {
		System.out.println("boundryTest called");
		Book book = new Book("Into the Wilds 2: Return of the Wilds", 19.99, LocalDate.of(1999, 11, 22), 10, 
				new ArrayList<>(Arrays.asList("Jim", "Julie", "Karen")));
		Game game = new Game("Halo 7: Even More Infinite - Diamond Edition", 1099.99, LocalDate.of(2026, 1, 17), 35, "Bungie", false);
		CompactDisc compactDisc = new CompactDisc("The Tide, The Thief, and River's End", 40.00, LocalDate.of(2013, 10, 4), 100, "Caligula's Horse");
		Movie movie = new Movie("Into the Wilds", 22.00, LocalDate.of(1999, 11, 22), 10, "Bob", "Joe");
		assertAll("boundry test", () -> assertTrue(book instanceof Book),
				() -> assertTrue(game instanceof Game),
				() -> assertTrue(movie instanceof Movie),
				() -> assertTrue(compactDisc instanceof CompactDisc));
	}
	
	@Test
	@Order(1)
	void testCurrentIdIncrement() {
		System.out.println("testCurrentIdIncrement called"); 
		assertEquals(9000, item.getItemID());
		assertEquals(9100, Item.currentItemID);
	}
	
	@Test
	void testGetPrice() {
		System.out.println("testGetPrice of Item called");
		assertEquals(10.00,item.getPrice(LocalDate.of(2000, 11, 21)));	// Day before a year
		assertEquals(10.00,item.getPrice(LocalDate.of(2000, 11, 22))); // Day of the year
		assertEquals(5.00,item.getPrice(LocalDate.of(2000, 11, 23))); // Day after the year
	}
	
	@Test 
	void testSetDiscount() {
		System.out.println("testSetDiscount called");
		assertFalse(item.setDiscount(0.7));
		assertFalse(item.setDiscount(1.0));
		assertTrue(item.setDiscount(0.4));
	}
	
	@Test 
	void testSell() {
		System.out.println("testSell called");
		assertEquals(0, item.sell(0, LocalDate.of(2000, 11, 22)));	// amount <= 0
//		sellDate is before release date
		assertEquals(0, item.sell(10, LocalDate.of(1999, 11, 21))); 
		assertEquals(10, item.sell(1, LocalDate.of(1999, 11, 22))); // amount == quality
		assertEquals(0 , item.sell(2, LocalDate.of(2000, 11, 22)));	// amount > quality
	}
	
	@Test 
	void testAddStock () {
		System.out.println("testAddStock called");
		assertFalse(item.addStock(100));
		assertTrue(item.addStock(99));
		assertFalse(item.addStock(10));
	}	
}
