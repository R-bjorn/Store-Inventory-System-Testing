import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;

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
@DisplayName("This is Movie Class Tester")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TestMovie {
	Movie movie = new Movie("Into the Wilds", 22.00, LocalDate.of(1999, 11, 22), 10, "Bob", "Joe");
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMovie() {
		System.out.println("testMovie called");
		assertAll("movie testing",() -> assertEquals("Into the Wilds",movie.getTitle()),
				() -> assertEquals(22.0,movie.getRegularPrice()),
				() -> assertEquals(LocalDate.of(1999, 11, 22), movie.getReleaseDate()),
				() -> assertEquals(10, movie.getQuantity()),
				() -> assertEquals("Bob", movie.getDirector()),
				() -> assertEquals("Joe", movie.getProducer())
				);
	}
	
	@Test
	void testGetPrice() {
		System.out.println("testGetPrice of Item called");
		assertEquals(22.00,movie.getPrice(LocalDate.of(2000, 11, 21)));	// Day before a year
		assertEquals(22.00,movie.getPrice(LocalDate.of(2000, 11, 22))); // Day of the year
		assertEquals(11.00,movie.getPrice(LocalDate.of(2000, 11, 23))); // Day after the year
	}
	
	@Test
	void testdeepcopy() {
		System.out.println("testdeepcopyconstructor called");
		Movie movie2 = (Movie) movie.makeCopy();
		assertNotEquals(movie, movie2);
		assertAll("deep copy testing", () -> assertEquals(movie.getTitle(), movie2.getTitle()),
				() -> assertEquals(movie.getRegularPrice(), movie2.getRegularPrice()),
				() -> assertEquals(movie.getReleaseDate(), movie2.getReleaseDate()),
				() -> assertEquals(movie.getQuantity(), movie2.getQuantity()),
				() -> assertEquals(movie.getDirector(), movie2.getDirector()),
				() -> assertEquals(movie.getProducer(), movie2.getProducer()));
	}
}
