import static org.junit.jupiter.api.Assertions.*;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Ravi Trivedi
 * @Student_No 105197609
 *
 */
@DisplayName("This is CompactDist Class Tester")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TestCompactDisc {
	CompactDisc c1 = new CompactDisc("The Tide, The Thief, and River's End", 40.00, LocalDate.of(2013, 10, 4), 100, "Caligula's Horse");
	CompactDisc c2 = new CompactDisc("Rise Radiant", 50.00, LocalDate.of(2020, 5, 22), 100, "Caligula's Horse", "Inside Out Music");
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
	void testCompactDisc() {
		System.out.println("testCompactDisc called");
		assertAll("compactDisc test", () -> assertEquals("Rise Radiant", c2.getTitle()),
				() -> assertEquals(50.00, c2.getRegularPrice()),
				() -> assertEquals(LocalDate.of(2020, 5,22), c2.getReleaseDate()),
				() -> assertEquals(100, c2.getQuantity()),
				() -> assertEquals("Caligula's Horse", c2.bandName),
				() -> assertEquals("Inside Out Music", c2.recordLabel),
				() -> assertEquals("Indie", c1.recordLabel)
				);
	}
	
	@Test 
	void testGetPrice() {
		System.out.println("testGetPrice of CompactDisc called");
		assertEquals(40.00,c1.getPrice(LocalDate.of(2014, 10, 3)));	// Day before a year
		assertEquals(40.00,c1.getPrice(LocalDate.of(2014, 10, 4))); // Day of the year
		assertEquals(20.00,c1.getPrice(LocalDate.of(2014, 10, 5))); // Day after the year
	}
	
	@Test
	void testdeepcopy() {
		System.out.println("testdeepcopyconstructor called");
		CompactDisc c3 = (CompactDisc) c1.makeCopy();
		assertNotEquals(c1, c3);
		assertAll("deep copy testing", () -> assertEquals(c1.getTitle(), c3.getTitle()),
				() -> assertEquals(c1.getRegularPrice(), c3.getRegularPrice()),
				() -> assertEquals(c1.getReleaseDate(), c3.getReleaseDate()),
				() -> assertEquals(c1.getQuantity(), c3.getQuantity()),
				() -> assertEquals(c1.bandName, c3.bandName),
				() -> assertEquals(c1.recordLabel, c3.recordLabel)
				);
	}

}
