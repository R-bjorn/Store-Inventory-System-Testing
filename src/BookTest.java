import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Ravi Trivedi
 * @Student_No 105197609
 *
 */
@DisplayName("This is Book Class Tester")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestBook {
	Book book = new Book("Into the Wilds 2: Return of the Wilds", 19.99, LocalDate.of(1999, 11, 22), 10, 
			new ArrayList<>(Arrays.asList("Jim", "Julie", "Karen")));

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("\nNote the specific order here");
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testBook() {
		System.out.println("testBook called");
		assertAll("book testing",() -> assertEquals("Into the Wilds 2: Return of the Wilds" ,book.getTitle()),
				() -> assertEquals(19.99,book.getRegularPrice()),
				() -> assertEquals(LocalDate.of(1999, 11, 22), book.getReleaseDate()),
				() -> assertEquals(10, book.getQuantity()),
				() -> assertEquals(new ArrayList<>(Arrays.asList("Jim", "Julie", "Karen")), book.getAuthors()));
	}
	
	@Test
	void testgetPrice() {
		System.out.println("testgetPrice of Book called");
		assertEquals(19.99, book.getPrice(LocalDate.of(2000, 11, 21)));
		assertEquals(19.99, book.getPrice(LocalDate.of(2000, 11, 22)));
		assertEquals(19.99, book.getPrice(LocalDate.of(2000, 11, 23)));
	}
	
	@Test
	void testdeepcopy() {
		System.out.println("testdeepcopyconstructor called");
		Book book2 = (Book) book.makeCopy();
		assertNotEquals(book, book2);
		assertAll("deep copy testing", () -> assertEquals(book.getTitle(), book2.getTitle()),
				() -> assertEquals(book.getRegularPrice(), book2.getRegularPrice()),
				() -> assertEquals(book.getReleaseDate(), book2.getReleaseDate()),
				() -> assertEquals(book.getQuantity(), book2.getQuantity()),
				() -> assertEquals(book.getAuthors(), book2.getAuthors()));
	}
	
	@Test
	void testGetAuthors() {
		System.out.println("testGetAuthors called");
		ArrayList<String> authors = new ArrayList<String>();
        authors.add("Jim");
        authors.add("Julie");
        authors.add("Karen");
        Book book = new Book("Into the Wilds 2: Return of the Wilds", 19.99, LocalDate.of(1999, 11, 22), 10,authors);
        assertEquals(authors, book.getAuthors());
	}

}
